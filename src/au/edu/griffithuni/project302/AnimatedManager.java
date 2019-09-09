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
	public float speedRate;
	public float scaleRate;

	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
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

//		manager.canvas.setJoneDoe(currentPerformed.get(0)); // draw the first frame
//		manager.canvas.repaint();
	}

	/* btn 'play' has been clicked */
	public void performance() {
		// Fill the gaps in 3 elements, 3 is fixed TODO make it flex
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
		System.out.println("[DEBUG] list size: " + nCount);
		
		startTimer(ANIMATE_FPS);
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
		if(cursor >= nCount - 1)
			stopTimer();
			
		System.out.println("[DEBUG]" + currentPerformed.get(cursor).toString());
		
		manager.canvas.setJoneDoe(currentPerformed.get(cursor ++));
//		manager.canvas.repaint();PositionVo
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

}
