package au.edu.griffithuni.project302.vo;

import static au.edu.griffithuni.project302.tools.Constants.PRECISION;

import java.awt.Point;

public class PositionVo {

	private double time;

	private double og_headX;
	private double og_headY;

	private double og_leftHandX;
	private double og_leftHandY;

	private double og_rightHandX;
	private double og_rightHandY;
	
	private int headX;
	private int headY;

	private int leftHandX;
	private int leftHandY;

	private int rightHandX;
	private int rightHandY;

	public PositionVo(double time, double headX, double headY, double leftHandX, double leftHandY, double rightHandX,
			double rightHandY) {
		this.time = time;
		this.og_headX = headX;
		this.og_headY = headY;
		this.headX = roundOff(og_headX * PRECISION);
		this.headY = roundOff(og_headY * PRECISION);
		
		this.og_leftHandX = leftHandX;
		this.og_leftHandY = leftHandY;
		this.leftHandX = roundOff(og_leftHandX * PRECISION);
		this.leftHandY = roundOff(og_leftHandY * PRECISION);
		
		this.og_rightHandX = rightHandX;
		this.og_rightHandY = rightHandY;
		this.rightHandX = roundOff(og_rightHandX * PRECISION);
		this.rightHandY = roundOff(og_rightHandY * PRECISION);
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
		return new Point(headX, headY);
	}

	public Point getLeftHand() {
		return new Point(leftHandX, leftHandY);
	}

	public Point getRightHand() {
		return new Point(rightHandX, rightHandY);
	}

	@Override
	public String toString() {
		return "Time Stamp:" + time + " \nHead Pos (" + og_headX + ", " + og_headY + ").\nLeft Hand Pos (" + og_leftHandX + ", "
				+ og_leftHandY + ").\nRight Hand Pos (" + og_rightHandX + ", " + og_rightHandY + ").\n";
	}

	private static int roundOff(double f) {
		return (int) Math.round(f + 0.5f);
	}

}
