package au.edu.griffithuni.project302.gui.middle;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_2;
import static au.edu.griffithuni.project302.tools.Constants.MARGIN;
import static au.edu.griffithuni.project302.tools.Constants.PANEL_TITLE;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_POS_HEIGHT;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class UiCanvas extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiCanvas() {
		setBackground(COLOR_2);
		setBounds(MARGIN, SCREEN_POS_HEIGHT, SCREEN_PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
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

		g2d.translate((getWidth() / 2) - 15, (getHeight() / 2) - 15);
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(6.6f));
		g2d.drawOval(0, 0, 30, 30);
		
		g2d.translate(-((getWidth() / 2) - 15), -((getHeight() / 2) - 15));
	}

//	private void paintCoordinate(Graphics2D g2d) {   
//        Stroke st = g2d.getStroke();     
//        Stroke bs;     
//        
//        bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{16, 4}, 0);     
//        g2d.setStroke(bs);     
//        g2d.drawLine(0, (SCREEN_PANEL_HEIGHT / 2), SCREEN_PANEL_WIDTH, (SCREEN_PANEL_HEIGHT / 2));     
//        g2d.drawLine((SCREEN_PANEL_WIDTH / 2), 0, (SCREEN_PANEL_WIDTH / 2), SCREEN_PANEL_HEIGHT);    
//        g2d.setStroke(st);     
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
