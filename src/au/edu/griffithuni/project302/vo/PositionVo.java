package au.edu.griffithuni.project302.vo;

import static au.edu.griffithuni.project302.tools.Constants.PRECISION;

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
		return new Point(roundOff(headX * PRECISION), roundOff(headY * PRECISION));
	}

	public Point getLeftHand() {
		return new Point(roundOff(leftHandX * PRECISION), roundOff(leftHandY * PRECISION));
	}

	public Point getRightHand() {
		return new Point(roundOff(rightHandX * PRECISION), roundOff(rightHandY * PRECISION));
	}

	@Override
	public String toString() {
		return "Time Stamp:" + time + " \nHead Pos (" + headX + ", " + headY + ").\nLeft Hand Pos (" + leftHandX + ", "
				+ leftHandY + ").\nRight Hand Pos (" + rightHandX + ", " + rightHandY + ").\n";
	}
//	this.append("Time: 302.5378 \n");
//	this.append("Head Pos: (-11.426, 1.435) \n");
//	this.append("Left hand Pos: (-11.426, 1.435) \n");
//	this.append("Right hand Pos: (-11.426, 1.435) \n");	
	private static int roundOff(double f) {
		return (int) Math.round(f + 0.5f);
	}

}
