package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.*;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener {

	private ApplicationManager manager;
	private Timer timer;
	private boolean pause = false;
	private int nCount, cursor;
	
	public HashMap<String, LinkedList<PositionVo>> csvDataMap = new HashMap<String, LinkedList<PositionVo>>();
	public String currentFlieName;
	public LinkedList<PositionVo> currentPerformed;
	public float speedRate = 1.0f;
	public float scaleRate;
	public double movingRate;
	public int referX, referY;// Animation initial base point
	
	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
//		this.referX = (int)(SCREEN_PANEL_WIDTH / 5);
//		this.referY = (int)(SCREEN_PANEL_HEIGHT / 2);
		this.referX = 50;
		this.referY = (int)(SCREEN_PANEL_HEIGHT / 2);
	}

	public void recv(Map<String, LinkedList<PositionVo>> csv) {
		csvDataMap.putAll(csv);
	}

	public void setCurrentPerforme(String fdName) {
		this.currentFlieName = fdName;
		if (csvDataMap.size() == 0)
			System.err.println("[DEBUG] csv data map is empty. ");

		this.currentPerformed = csvDataMap.get(fdName);
		if (this.currentPerformed == null)
			System.err.println("[DEBUG] data cannot find. " + fdName);

	}

	/* btn 'play' has been clicked */
	public void performance() {
		PositionVo s = currentPerformed.getFirst();
		PositionVo e = currentPerformed.getLast();

		int timeCost = (int) (e.getTime() - s.getTime());
		int span =  (int) Math.abs(e.getHead().getX() - s.getHead().getX()); 
		
		movingRate = (span / timeCost) *  0.1;
		
		System.out.println("[AnimatedManager DEBUG] timecost:" + timeCost + "; span:" + span + "; moving rate:" + movingRate +".\n");
		//TODO according to the moving rate decide how many nodes fill the gap
		
		int size = currentPerformed.size();

		for (int i = 1; i < size * 4 - 4; i += 4) {
			PositionVo s1 = currentPerformed.get(i - 1);
			PositionVo s2 = currentPerformed.get(i);

			Point[] delta_Head = sim_dda(s1.getHead(), s2.getHead(), 4);
			Point[] delta_left_hand = sim_dda(s1.getLeftHand(), s2.getRightHand(), 4);
			Point[] delta_right_hand = sim_dda(s1.getRightHand(), s2.getRightHand(), 4);
			
			for (int j = 0; j < 3; j++) 
				currentPerformed.add(i + j, new PositionVo(delta_Head[j], delta_left_hand[j], delta_right_hand[j]));
		}
		
		nCount = currentPerformed.size();
		cursor = 0;

		referX -= s.getHead().getX();
		referY += s.getHead().getY();
		
		/* update gui */
		manager.proceBar.setMinimum(1);
		manager.proceBar.setMaximum(nCount);
		/* end */
		
		startTimer((int)(ANIMATE_FPS * speedRate));
	}

	/* dda algorithm */
	private Point[] sim_dda(Point p1, Point p2, int h) {
		Point[] tmp = new Point[h - 1];
		float dx = (p2.x - p1.x) / h;
		float dy = (p2.y - p1.y) / h;

		float x = p1.x;
		float y = p1.y;

		for (int i = 0; i < h - 1; i++) {
			x += dx;
			y += dy;
			tmp[i] = new Point((int)x, (int)y);
		}
		return tmp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cursor >= nCount - 1) {
			stopTimer();
			// TODO clean & reset
			manager.iWait();
		}
		PositionVo curr = currentPerformed.get(cursor);
//		referX += movingRate;
		manager.canvas.setJoneDoe(curr, new Point(referX, referY));
		cursor++;
		
		/* update gui */
		if(curr.getTime() != 0)
			manager.proceBar.setValue(cursor);
		/* end */
	}

	/**
	 * Starts the animation
	 */
	public void startTimer(int resolution) {
		if (timer != null) {
			timer.stop();
			timer.setDelay(resolution);
		} else {
			timer = new Timer(resolution, this);
		}
		timer.start();
	}

	/* pause */
	public void pauseTimer() {
		if (timer != null) {
			if (pause && !timer.isRunning()) {
				timer.restart();
				pause = false;
			} else {
				timer.stop();
				pause = true;
			}
		}
	}

	public void stopTimer() {
		if (timer != null)
			timer.stop();
		timer = null;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	public void setSpeedRate(float speedRate) {
		this.speedRate = speedRate;
	}

}
