package au.edu.griffithuni.project302.vo;

import java.awt.Point;

public class PositionVo {

	private double time;

	private double headX;
	private double headY;

	private double leftHandX;
	private double leftHandY;

	private double rightHandX;
	private double rightHandY;

	public PositionVo(double time, double headX, double headY, double leftHandX, double leftHandY, double rightHandX,
			double rightHandY) {
		this.time = time;
		this.headX = headX;
		this.headY = headY;
		this.leftHandX = leftHandX;
		this.leftHandY = leftHandY;
		this.rightHandX = rightHandX;
		this.rightHandY = rightHandY;
	}
	
	public PositionVo(Point head, Point leftHand, Point rightHand) {
		this.time = 0L;
		this.headX = head.x;
		this.headY = head.y;
		this.leftHandX = leftHand.x;
		this.leftHandY = leftHand.y;
		this.rightHandX = rightHand.x;
		this.rightHandY = rightHand.y;
	}
	
	public double getTime() {
		return time;
	}

	public Point getHead() {
		return new Point((int)(headX * 1000), (int)(headY * 1000));
	}

	public Point getLeftHand() {
		return new Point((int)(leftHandX * 1000), (int)(leftHandY * 1000));
	}

	public Point getRightHand() {
		return new Point((int)(rightHandX * 1000), (int)(rightHandY * 1000));
	}

	@Override
	public String toString() {
		return "Time:" + time + ", head Pos (" + headX + ", " + headY + "), \n left hand Pos (" + leftHandX + ", "
				+ leftHandY + "), " + "right hand Pos (" + rightHandX + ", " + rightHandY + ")";
	}

}
