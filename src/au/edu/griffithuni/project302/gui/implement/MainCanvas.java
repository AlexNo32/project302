package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.*;
import static au.edu.griffithuni.project302.tools.Constants.DASHBOARD_POS_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.DASHBOARD_POS_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.DASHBOARD_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.FONT_SIZE;
import static au.edu.griffithuni.project302.tools.Constants.GRID_GAP;
import static au.edu.griffithuni.project302.tools.Constants.HAND_COLOR;
import static au.edu.griffithuni.project302.tools.Constants.HAND_DIAMETER;
import static au.edu.griffithuni.project302.tools.Constants.HEAD_COLOR;
import static au.edu.griffithuni.project302.tools.Constants.HEAD_DIAMETER;
import static au.edu.griffithuni.project302.tools.Constants.LINE_COLOR;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_BACKGROUND;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_POS_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_POS_LOC_Y;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.tools.Matrix2DTransfer;
import au.edu.griffithuni.project302.vo.PositionVo;

/**
 * canvas. Draw, baby draw -- Dr.Ruben
 * 
 * @author Firklaag_ins
 *
 */
public final class MainCanvas extends JPanel implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	private DashBoard dashBoard;
	private Point head, leftHand, rightHand;
	private Point referPoint;
	private int baseX = 0, baseY = 0;
//	private int mx = 0, my = 0;
	
	private boolean animate;
	private Direction offset = Direction.NONE;
	public int referX, referY;// Animation initial start position

	public MainCanvas(ApplicationManager manager) {
		this.manager = manager;
		setLayout(null);
	}

	@Override
	public void iInitialize() {
		animate = false;
		setBackground(SCREEN_BACKGROUND);// background color (jade green)
		setBounds(SCREEN_POS_LOC_X, SCREEN_POS_LOC_Y, SCREEN_PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
//		setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		manager.mainFrame.add(this);
		dashBoard = new DashBoard();
		add(dashBoard);

		dashBoard.display("2D viewer Gui initial ... done.");
	}

	@Override
	public void iWait() {
		dashBoard.display("Ready the data files ... done.");
		animate = false;
		restore();
	}

	@Override
	public void iPlay() {
		dashBoard.clear();
		animate = true;
	}

	/* reference point - current pos = right position */
	public void setJoneDoe(PositionVo pos, Point reference, Direction direct) {
		head = pos.getHead();
		leftHand = pos.getLeftHand();
		rightHand = pos.getRightHand();
		this.offset = direct;
		
		/* debug delete */
//		if(direct != Direction.NONE)
//			System.out.println("[DEBUG]: " + direct);

		// mapping
		head = Matrix2DTransfer.mappingAroundX(head);
		leftHand = Matrix2DTransfer.mappingAroundX(leftHand);
		rightHand = Matrix2DTransfer.mappingAroundX(rightHand);
		referPoint = reference;

		/* dashboard display */
		if (pos.getTime() == 1) {
			dashBoard.clear();
			dashBoard.display("Animation finished...");
		} else if (pos.getTime() != 0)
			dashBoard.display(pos);

		/* end */

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		paintBackground(g2d, GRID_GAP, offset);

		if (animate)
			drawJoneDoe(g2d);
	}

	private void drawJoneDoe(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.translate(referPoint.x, referPoint.y);
		// head
		g2d.setColor(HEAD_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(head.x, head.y, HEAD_DIAMETER, HEAD_DIAMETER);

		// left hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(leftHand.x, leftHand.y, HAND_DIAMETER, HAND_DIAMETER);

		// right hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(rightHand.x, rightHand.y, HAND_DIAMETER, HAND_DIAMETER);

		// draw line
		int centerHeadX = head.x + (HEAD_DIAMETER / 2);
		int centerHeadY = head.y + (HEAD_DIAMETER / 2);
		int centerLeftX = leftHand.x + (HAND_DIAMETER / 2);
		int centerLeftY = leftHand.y + (HAND_DIAMETER / 2);
		int centerRightX = rightHand.x + (HAND_DIAMETER / 2);
		int centerRightY = rightHand.y + (HAND_DIAMETER / 2);

		g2d.setColor(LINE_COLOR);
		g2d.drawLine(centerHeadX, centerHeadY, centerLeftX, centerLeftY);
		g2d.drawLine(centerHeadX, centerHeadY, centerRightX, centerRightY);

		g2d.translate(-referPoint.x, -referPoint.y);

	}

	/* background color and grids */
	private void paintBackground(Graphics2D g2d, int gap, Direction offset) {
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(25, 25, 112));// TODO 
		g2d.setPaint(gp);
		Stroke st = g2d.getStroke();
		Stroke bs;

		bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 16, 4 }, 0);
		g2d.setStroke(bs);

		g2d.setFont(MARK_FONT);
		
		/* i refer position, j refer mark (number) */
		int i = 5, markX = 0, markY = 0;
		
		switch(offset) {
			case RIGHT:
				baseX += 1; 
				break;
			case TOP:
				baseY += 1;
				break;
			case BOTTOM:
				baseY -= 1;
				break;
			case NONE:
				break;
			default:
				break;
		}
		markX = baseX;
		markY = baseY;
		
		while (i < SCREEN_PANEL_WIDTH) {
			g2d.drawLine(0, i, SCREEN_PANEL_WIDTH, i);
			g2d.drawLine(i, 0, i, SCREEN_PANEL_HEIGHT);

			setMark(markX, i, true, g2d);
			setMark(markY, i, false, g2d);

			markX++;
			markY++;
			i += gap;
		}

		g2d.setStroke(st);
	}

	private void setMark(int mark, int seq, boolean x_axis, Graphics2D g2d) {
		if (x_axis)
			g2d.drawString(mark + "", seq + 2, SCREEN_PANEL_HEIGHT - 8);
		else {
			if (seq == 5)
				return;

			g2d.drawString(mark + "", 8, SCREEN_PANEL_HEIGHT - seq);
		}

	}

	private void restore() {
		baseX = 0;
		baseY = 0;
	}
	
	private class DashBoard extends JTextArea {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public DashBoard() {
			setBounds(DASHBOARD_POS_LOC_X, DASHBOARD_POS_LOC_Y, DASHBOARD_WIDTH, DASHBOARD_HEIGHT);
			setRows(4);
			setBackground(SCREEN_BACKGROUND);
//			setOpaque(false);
		}

		public void display(String msg) {
			append(msg + "\n");
		}

		public void display(PositionVo info) {
			clear();
			append(info.toString());
		}

		public void clear() {
			setText("");
		}

	}

}
