package au.edu.griffithuni.project302.gui.middle;

import static au.edu.griffithuni.project302.tools.Constants.*;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class UiCanvas extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		paint(g);	
		super.paintComponent(g);
	}

	public void paint(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;     
         Stroke st = g2d.getStroke();     
         Stroke bs;     
         //LINE_TYPE_DASHED     
         bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{16, 4}, 0);     
         g2d.setStroke(bs);     
         g2d.drawLine(0, (SCREEN_PANEL_HEIGHT / 2), PANEL_WIDTH, (SCREEN_PANEL_HEIGHT / 2));     
         g2d.drawLine((PANEL_WIDTH / 2), 0, (PANEL_WIDTH / 2), SCREEN_PANEL_HEIGHT);    
         g2d.setStroke(st);     
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
