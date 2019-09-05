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

	public Point[] getStatue(int s) {
		Point head = new Point((int) headX * s, (int) headY * s);
		Point lhand = new Point((int) leftHandX * s, (int) leftHandY);
		Point rhand = new Point((int) rightHandX * s, (int) rightHandY);
		return new Point[] {head, lhand, rhand}; 
	}
	
	@Override
	public String toString() {
		return "Time:" + time + ", head Pos (" + headX + ", " + headY + "), \n left hand Pos (" + leftHandX + ", "
				+ leftHandY + "), " + "right hand Pos (" + rightHandX + ", " + rightHandY + ")";
	}

}
