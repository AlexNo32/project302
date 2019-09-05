package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.*;
import static au.edu.griffithuni.project302.tools.Constants.HEAD_COLOR;
import static au.edu.griffithuni.project302.tools.Constants.PANEL_TITLE;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class MainCanvas extends JPanel implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point head, leftHand, rightHand;
	private ApplicationManager manager;
	private boolean animate; 
	
	public MainCanvas(ApplicationManager manager) {
		this.manager = manager;
		
	}
	
	public void setJoneDoe(Point[] pos) {
		setHead(pos[0]);
		setLeftHand(pos[1]);
		setRightHand(pos[2]);
	}
	
	@Override
	public void iInitialize() {
		animate  = false;
		setBackground(COLOR_2);
		setBounds(SCREEN_POS_LOC_X, SCREEN_POS_LOC_Y, SCREEN_PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		manager.getMainFrame().add(this);
	}

	@Override
	public void iWait() {
		animate = true;
		
	}
	
	@Override
	public void iPlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iFinished() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		paintBackground(g2d);
		
		if(animate) {
			g2d.translate((getWidth() / 2) - DIAMETER, (getHeight() / 2) - DIAMETER);
			drawJoneDoe(g2d);		
			g2d.translate(-((getWidth() / 2) - DIAMETER), -((getHeight() / 2) - DIAMETER));
		}
			
	}
	
	private void drawJoneDoe(Graphics2D g2d) {
		// head
		g2d.setColor(HEAD_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(head.x, head.y, DIAMETER, DIAMETER);
		
		//left hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(leftHand.x, leftHand.y, DIAMETER, DIAMETER);
		
		//right hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(leftHand.x, leftHand.y, DIAMETER, DIAMETER);
		
		//draw line
		int centerHeadX = head.x + (DIAMETER / 2);
		int centerHeadY = head.y + (DIAMETER / 2);
		int centerLeftX = leftHand.x + (DIAMETER / 2);
		int centerLeftY = leftHand.y + (DIAMETER / 2);
		int centerRightX = rightHand.x + (DIAMETER / 2);
		int centerRightY = rightHand.y + (DIAMETER / 2);
		
//		System.out.println(head.x + ":" + head.y);
//		
//		System.out.println("centerh" + centerHeadX + ":" + centerHeadY);
//		System.out.println("centerl" + centerLeftX + ":" + centerLeftY);
//		System.out.println("centerr" + centerRightX + ":" + centerRightY);
		
		g2d.setColor(LINE_COLOR);
		g2d.fillOval(centerHeadX, centerHeadY, 2, 2);
		g2d.fillOval(centerLeftX, centerLeftY, 2, 2);
		g2d.fillOval(centerRightX, centerRightX, 2, 2);
		g2d.drawLine(centerHeadX , centerHeadY, centerLeftX, centerLeftY);
		g2d.drawLine(centerHeadX , centerHeadY, centerRightX, centerRightY);
		
	}

	private void paintBackground(Graphics2D g2d) {   
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, Color.RED, 0, getHeight(), Color.YELLOW);
//		
		g2d.setPaint(gp);
		Stroke st = g2d.getStroke();
		Stroke bs;

		bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 16, 4 }, 0);
		g2d.setStroke(bs);
		g2d.drawLine(0, (SCREEN_PANEL_HEIGHT / 2), SCREEN_PANEL_WIDTH, (SCREEN_PANEL_HEIGHT / 2));
		g2d.drawLine((SCREEN_PANEL_WIDTH / 2), 0, (SCREEN_PANEL_WIDTH / 2), SCREEN_PANEL_HEIGHT);
		g2d.setStroke(st);  
	}

	public Point getHead() {
		return head;
	}

	public void setHead(Point head) {
		this.head = head;
	}

	public Point getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Point leftHand) {
		this.leftHand = leftHand;
	}

	public Point getRightHand() {
		return rightHand;
	}

	public void setRightHand(Point rightHand) {
		this.rightHand = rightHand;
	}
}
