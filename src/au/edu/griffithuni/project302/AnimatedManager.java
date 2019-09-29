package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.ANIMATE_FPS;
import static au.edu.griffithuni.project302.tools.Constants.GRID_GAP;
import static au.edu.griffithuni.project302.tools.Constants.HAND_DIAMETER;
import static au.edu.griffithuni.project302.tools.Constants.HEAD_DIAMETER;
import static au.edu.griffithuni.project302.tools.Constants.INITIAL_LOCATION_X;
import static au.edu.griffithuni.project302.tools.Constants.INITIAL_LOCATION_Y;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.tools.Constants.Direction;
import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener {

	private ApplicationManager manager;// Application control
	private Timer timer; // Animation timer
	private boolean pause = false;
	private int nCount, cursor;

	/* data map Key: absolute path of file. Value: position list of data */
	public HashMap<String, LinkedList<PositionVo>> csvDataMap = new HashMap<String, LinkedList<PositionVo>>();
	public String currentFlieName; // current file name (key)
	public LinkedList<PositionVo> currentPerformed; // current data list (value)
	public float speedRate = 1.0f; // speed rate
	public float scaleRate = 1.0f; // scale rate
	public double movingRate; // @ unused
	public int referX, referY;// Animation initial base point
	public int currReferX, currReferY; // current referX and Y

	/*
	 * if the dummy reach the border, move the screen. The number is not actual
	 * pixel width, is the times of moving grids
	 */
	private Direction offset = Direction.NONE; // moving direction
	private int rightOffset = 0, topOffset = 0, bottomOffset = 0; // testing, not finished

	private final int rightBorderLimit = SCREEN_PANEL_WIDTH - HAND_DIAMETER; // right border
	private final int topBorderLimit = 0 + HEAD_DIAMETER; // top border
	private final int bottomBorderLimit = (SCREEN_PANEL_HEIGHT / 2)  - (int)(HAND_DIAMETER * 1.5); // bottom border

	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
		this.referX = INITIAL_LOCATION_X;
		this.referY = INITIAL_LOCATION_Y;
	}

	// receive data map.
	public void recv(Map<String, LinkedList<PositionVo>> csv) {
		csvDataMap.putAll(csv);
	}

	// update current data list.
	public void setCurrentPerforme(String fdName) {
		currentFlieName = fdName;
		if (csvDataMap.size() == 0)
			System.err.println("[DEBUG] csv data map is empty. ");

		currentPerformed = new LinkedList<PositionVo>(csvDataMap.get(currentFlieName));
		if (currentPerformed == null)
			System.err.println("[DEBUG] data cannot find. " + currentFlieName);
	}

	/* btn 'play' has been clicked */
	public void performance() {
		PositionVo s = currentPerformed.getFirst();
		@SuppressWarnings("unused")
		PositionVo e = currentPerformed.getLast();
//		int timeCost = (int) (e.getTime() - s.getTime());
//		int span = (int) Math.abs(e.getHead().getX() - s.getHead().getX());
		// TODO according to the moving rate decide how many nodes fill the gap

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

		/* (*)absolute point = initial point - current point */
		referX -= s.getHead().getX();
		referY += s.getHead().getY();
		currReferX = referX;
		currReferY = referY;

		/* update gui */
		manager.proceBar.setMinimum(0);
		manager.proceBar.setMaximum(nCount);
		/* end */

		startTimer((int) (ANIMATE_FPS * speedRate));
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
			tmp[i] = new Point((int) x, (int) y);
		}
		return tmp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PositionVo curr = currentPerformed.get(cursor);

		/* border verify */
//		System.out.println("[right border check]" + (referX + curr.getLeftHand().x) + " vs " + rightBorderLimit);
//		System.out.println("[top border check]" + (referY + curr.getHead().y) + " vs " + topBorderLimit);
//		System.out.println("[bottom border check]" + referY + "." + curr.getLeftHand().y + "." + (referY + curr.getLeftHand().y) + " vs " + bottomBorderLimit + " ->" + bottomOffset + "->" + rightOffset);
		
		if ((referX + curr.getLeftHand().x) > rightBorderLimit) {
			offset = Direction.RIGHT;
			rightOffset += 2;
		} else if ((referY +  curr.getLeftHand().y) < bottomBorderLimit) { // lost track
			offset = Direction.BOTTOM;
			bottomOffset += 1;
		} else if (referY + curr.getHead().y < topBorderLimit) { // lost track
			offset = Direction.TOP;
			topOffset += 1;
		}

		
		
		if (rightOffset == 0 && topOffset == 0 && bottomOffset == 0) {
//			if(offset != Direction.NONE)
//				System.out.println("Resotre!!!!" + offset);
			offset = Direction.NONE;
		}
		
		switch (offset) {
		case RIGHT:
			referX -= GRID_GAP;
			rightOffset -= 1;
			break;
		case TOP:
			referY += GRID_GAP;
			topOffset -= 1;
			break;
		case BOTTOM:
			referY -= GRID_GAP;
			bottomOffset -= 1;
			break;
		default:
			break;

		}
//		System.out.println("[DEBUG]" + rightOffset + ":" + topOffset + ":" + bottomOffset);
		
		currReferX = referX;
		currReferY = referY;	
		/* end */

		manager.canvas.setJoneDoe(curr, new Point(currReferX, currReferY), offset);
		cursor++;

		/* update gui */
		if (curr.getTime() != 0)
			manager.proceBar.setValue(cursor);
		/* end */

		if (cursor >= nCount - 1)
			finish();
	}

	/* call it when animate finished */
	public void finish() {
		PositionVo v = new PositionVo(1d, 0d, 0d, 0d, 0d, 0d, 0d);
		manager.canvas.setJoneDoe(v, new Point(0, 0), Direction.NONE);
		stopTimer();
		free();
		manager.iWait();
	}

	private void free() {
		pause = false;
		nCount = 0;
		cursor = 0;

		speedRate = 1.0f;
		scaleRate = 1.0f;
//		public double movingRate;
		referX = INITIAL_LOCATION_X;
		referY = INITIAL_LOCATION_Y;
		currReferX = currReferY = 0;

		currentPerformed.clear();
		currentPerformed = new LinkedList<PositionVo>(csvDataMap.get(currentFlieName));
		if (currentPerformed == null)
			System.err.println("[DEBUG] data cannot find. " + currentFlieName);

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
		if (timer != null && timer.isRunning()) {
			timer.setDelay((int) (ANIMATE_FPS * speedRate));
		}
	}

	public void setScaleRate(float scaleRate) {
		this.scaleRate = scaleRate;
	}

}
