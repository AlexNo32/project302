package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_0;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_1;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;
import static au.edu.griffithuni.project302.tools.Constants.CONTROL_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.MARGIN;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import au.edu.griffithuni.project302.gui.middle.UiCanvas;

public class UiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel upper;
	private JPanel bottom;

	public UiFrame(String title) {
		super(title);
		setUi();
	}
	
	private void setUi() {
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setContentPane(contentPane);
		contentPane.setBackground(COLOR_0);
		contentPane.setLayout(null);

		setUpperPanel();
//		setScreen();
		setBottomPanel();
	}

	private void setUpperPanel() {
		upper = new JPanel();
		upper.setLayout(null);
		upper.setBackground(COLOR_1);
		upper.setBorder(new EtchedBorder(EtchedBorder.RAISED));
//		upper.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		upper.setBounds(MARGIN, MARGIN, SCREEN_PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(upper);
	}

	private void setBottomPanel() {
		bottom = new JPanel();
		bottom.setLayout(null);
		bottom.setBackground(COLOR_3);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		bottom.setBounds(MARGIN, 855, SCREEN_PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(bottom);
	}

	/**
	 * @return the upper
	 */
	public JPanel getUpper() {
		return upper;
	}

	/**
	 * @param upper the upper to set
	 */
	public void setUpper(JPanel upper) {
		this.upper = upper;
	}

	/**
	 * @return the bottom
	 */
	public JPanel getBottom() {
		return bottom;
	}

	/**
	 * @param bottom the bottom to set
	 */
	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}
}
