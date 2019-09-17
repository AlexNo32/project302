package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.DASHBOARD_HEIGHT;
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
import static au.edu.griffithuni.project302.tools.Constants.PANEL_TITLE;
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
import javax.swing.border.TitledBorder;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.tools.Matrix2DTransfer;
import au.edu.griffithuni.project302.vo.PositionVo;

/**
 * canvas.	Draw, baby draw -- Dr.Ruben
 * @author Firklaag_ins
 *
 */
public final class MainCanvas extends JPanel implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	private DashBoard dashBoard;
	private Point head, leftHand, rightHand;
	private Point referPoint; 
//	private Point headLine, handLine;
	
	private boolean animate; 
	public int referX, referY;// Animation initial start position
	
	public MainCanvas(ApplicationManager manager) {
		this.manager = manager;
		setLayout(null);
	}
	
	@Override
	public void iInitialize() {
		animate  = false;
		setBackground(SCREEN_BACKGROUND);// background color (jade green)
		setBounds(SCREEN_POS_LOC_X, SCREEN_POS_LOC_Y, SCREEN_PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		manager.mainFrame.add(this);
		dashBoard = new DashBoard();
		add(dashBoard);
		
		dashBoard.display("2D viewer Gui initial ... done.");
	}

	@Override
	public void iWait() {
		dashBoard.display("Csv files upload ... done.");
		animate  = false;
	}

	@Override
	public void iPlay() {
		dashBoard.clear();
		animate = true;
	}
	
	/* reference point - current pos = right position */
	public void setJoneDoe(PositionVo pos, Point reference) {
		head 		= pos.getHead();
		leftHand  	= pos.getLeftHand();
		rightHand 	= pos.getRightHand();
		
		// mapping
		head = Matrix2DTransfer.mappingAroundX(head);
		leftHand = Matrix2DTransfer.mappingAroundX(leftHand);
		rightHand = Matrix2DTransfer.mappingAroundX(rightHand);
		referPoint  = reference;
		
		/* dashboard display */
		if(pos.getTime() != 0) 
			dashBoard.display(pos);
		/* end */
		
		System.out.println("[MainCanvase] Head: " + head);
		System.out.println("[MainCanvase] leftHand: " + leftHand);
		System.out.println("[MainCanvase] rigthHand" + rightHand);
		System.out.println();
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		paintBackground(g2d);
		
		if(animate)
			drawJoneDoe(g2d);
	}
	
	private void drawJoneDoe(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.translate(referPoint.x, referPoint.y);
		// head
		g2d.setColor(HEAD_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(head.x, head.y, HEAD_DIAMETER, HEAD_DIAMETER);
		
		//left hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(leftHand.x, leftHand.y, HAND_DIAMETER, HAND_DIAMETER);
		
		//right hand
		g2d.setColor(HAND_COLOR);
		g2d.setStroke(new BasicStroke(FONT_SIZE));
		g2d.drawOval(rightHand.x, rightHand.y, HAND_DIAMETER, HAND_DIAMETER);
		
		//draw line
		int centerHeadX = head.x + (HEAD_DIAMETER / 2);
		int centerHeadY = head.y + (HEAD_DIAMETER / 2);
		int centerLeftX = leftHand.x + (HAND_DIAMETER / 2);
		int centerLeftY = leftHand.y + (HAND_DIAMETER / 2);
		int centerRightX = rightHand.x + (HAND_DIAMETER / 2);
		int centerRightY = rightHand.y + (HAND_DIAMETER / 2);
		
		g2d.setColor(LINE_COLOR);
		g2d.fillOval(centerHeadX, centerHeadY, 2, 2);
		g2d.fillOval(centerLeftX, centerLeftY, 2, 2);
		g2d.fillOval(centerRightX, centerRightX, 2, 2);
		g2d.drawLine(centerHeadX , centerHeadY, centerLeftX, centerLeftY);
		g2d.drawLine(centerHeadX , centerHeadY, centerRightX, centerRightY);
		
		g2d.translate(-referPoint.x, -referPoint.y);
		
	}

	/* background color and grids */
	private void paintBackground(Graphics2D g2d) {   
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, Color.RED, 0, getHeight(), Color.YELLOW);
//		
		g2d.setPaint(gp);
		Stroke st = g2d.getStroke();
		Stroke bs;

		bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 16, 4 }, 0);
		g2d.setStroke(bs);
		
		int i = GRID_GAP;
		while(i < SCREEN_PANEL_WIDTH) {
			g2d.drawLine(0, i, SCREEN_PANEL_WIDTH, i);
			g2d.drawLine(i, 0, i, SCREEN_PANEL_HEIGHT);
			i += GRID_GAP;
		}

		g2d.setStroke(st);  
	}

	public class DashBoard extends JTextArea {

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
