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

	@Override
	public String toString() {
		return "Time:" + time + ", head Pos (" + headX + ", " + headY + "), \n left hand Pos (" + leftHandX + ", "
				+ leftHandY + "), " + "right hand Pos (" + rightHandX + ", " + rightHandY + ").";
	}

//	public Point getHead() {
//		return new Point(headX, headY);
//	}
	
	public Point leftHand() {
		return new Point();
	}
	
	public double getTime() {
		return time;
	}

	public double getHeadX() {
		return headX;
	}

	public double getHeadY() {
		return headY;
	}

	public double getLeftHandX() {
		return leftHandX;
	}

	public double getLeftHandY() {
		return leftHandY;
	}

	public double getRightHandX() {
		return rightHandX;
	}

	public double getRightHandY() {
		return rightHandY;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public void setHeadX(double headX) {
		this.headX = headX;
	}

	public void setHeadY(double headY) {
		this.headY = headY;
	}

	public void setLeftHandX(double leftHandX) {
		this.leftHandX = leftHandX;
	}

	public void setLeftHandY(double leftHandY) {
		this.leftHandY = leftHandY;
	}

	public void setRightHandX(double rightHandX) {
		this.rightHandX = rightHandX;
	}

	public void setRightHandY(double rightHandY) {
		this.rightHandY = rightHandY;
	}

}
