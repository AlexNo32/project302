package au.edu.griffithuni.project302;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.gui.implement.MainCanvas;
import au.edu.griffithuni.project302.tools.Matrix2DTransfer;
import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener{
	
	private ApplicationManager manager;
	
	private HashMap<String, LinkedList<PositionVo>> csvData = new HashMap<String, LinkedList<PositionVo>>();
	private String currentData;
	private Timer timer;
	private float speedRate;
	private float scaleRate;
	private int timeStep = 500;
	
	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
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
    
    public void pauseTimer() {
		if (timer != null) {
//			if (pause && !timer.isRunning()) {
				timer.restart();
//				pause = false;
//			} else {
				timer.stop();
//				pause = true;
//			}
		}
	}

	public void stopTimer() {
		if (timer != null)
			timer.stop();
		timer = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LinkedList<PositionVo> frame = getVoList(currentData);
		MainCanvas canvas = getManager().getCanvas();
		
		System.out.println(frame.size());
		if(frame.size() == 0)
			timer.stop();
		
		PositionVo p = frame.poll();
//		Point head = new Point((int)p.getHeadX(), (int)p.getHeadY());
//		Point leftHand = new Point((int)p.getLeftHandX(), (int)p.getLeftHandY());
//		Point rightHand = new Point((int)p.getRightHandX(), (int)p.getRightHandY());
		
//		Point rHead = Matrix2DTransfer.rotate(head, 225);
//		Point rLeftHand = Matrix2DTransfer.rotate(leftHand, 225);
//		Point rRightHand = Matrix2DTransfer.rotate(rightHand, 225);
		
//		Point sHead = Matrix2DTransfer.scaling(head, 50f);
//		Point sLeftHand = Matrix2DTransfer.scaling(leftHand, 50f);
//		Point sRighthand = Matrix2DTransfer.scaling(rightHand, 50f);
//		
//		System.out.println();
//		System.out.println(sHead);
//		System.out.println(sLeftHand);
//		System.out.println(sRighthand);
//		System.out.println();
		
		canvas.setJoneDoe(p.getStatue(100));
		canvas.repaint();
		// TODO actio里不能循环调用
//		for(PositionVo p: frame) {
//			Point head = new Point((int)p.getHeadX(), (int)p.getHeadY());
//			Point leftHand = new Point((int)p.getLeftHandX(), (int)p.getLeftHandY());
//			Point rightHand = new Point((int)p.getRightHandX(), (int)p.getRightHandY());
//			
//			Point rHead = Matrix2DTransfer.rotate(head, 225);
//			Point rLeftHand = Matrix2DTransfer.rotate(leftHand, 225);
//			Point rRightHand = Matrix2DTransfer.rotate(rightHand, 225);
//			
//			Point sHead = Matrix2DTransfer.scaling(rHead, 50f);
//			Point sLeftHand = Matrix2DTransfer.scaling(rLeftHand, 50f);
//			Point sRighthand = Matrix2DTransfer.scaling(rRightHand, 50f);
//			
//			System.out.println();
//			System.out.println(sHead);
//			System.out.println(sLeftHand);
//			System.out.println(sRighthand);
//			System.out.println();
//			
//			canvas.setJoneDoe(sHead, sLeftHand, sRighthand);
//			canvas.repaint();
//		}
//		timer.stop();
		
	}
	
	
	public void recv(Map<String, LinkedList<PositionVo>> csv) {
		csvData.putAll(csv);
//		manager.getFlieList().update(csv.keySet().toArray());
		// draw first frame
//		System.out.println("Animate debug " + currentData);
//		prelude(currentData);
	}
	
//	private void prelude(String currentData) {
//		LinkedList<PositionVo> v = getVoList(currentData);
//		PositionVo vo = v.remove(0);
//		UiCanvas canvas = getManager().getCanvas();
//		
//		Point head = new Point((int)vo.getHeadX(), (int)vo.getHeadY());
//		Point leftHand = new Point((int)vo.getLeftHandX(), (int)vo.getLeftHandY());
//		Point rightHand = new Point((int)vo.getRightHandX(), (int)vo.getRightHandY());
//		
//		Point rHead = Matrix2DTransfer.rotate(head, 225);
//		Point rLeftHand = Matrix2DTransfer.rotate(leftHand, 225);
//		Point rRightHand = Matrix2DTransfer.rotate(rightHand, 225);
		
//		System.out.println(canvas.getWidth() + " : " + canvas.getHeight());
//		System.out.println(head);
//		System.out.println(leftHand);
//		System.out.println(rightHand);
//		System.out.println(Matrix2DTransfer.scaling(head, 15f));
//		System.out.println(Matrix2DTransfer.scaling(leftHand, 15f));
//		System.out.println(Matrix2DTransfer.scaling(rightHand, 15f));
		

//		canvas.setJoneDoe(Matrix2DTransfer.scaling(rHead, 50f),  Matrix2DTransfer.scaling(rLeftHand, 50f), Matrix2DTransfer.scaling(rRightHand, 50f));
//		canvas.repaint();
//	}
	
	public LinkedList<PositionVo> getVoList(String key) {
		return csvData.get(key);
	}

	/**
	 * @return the currentData
	 */
	public String getCurrentData() {
		return currentData;
	}

	/**
	 * @param currentData the currentData to set
	 */
	public void setCurrentData(String currentData) {
		this.currentData = currentData;
	}

	public float getSpeedRate() {
		return speedRate;
	}

	public void setSpeedRate(float speedRate) {
		this.speedRate = speedRate;
	}

	public float getScaleRate() {
		return scaleRate;
	}

	public void setScaleRate(float scaleRate) {
		this.scaleRate = scaleRate;
	}

	public ApplicationManager getManager() {
		return manager;
	}

	public void setManager(ApplicationManager manager) {
		this.manager = manager;
	}
	
}
