package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_0;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_1;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_2;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;
import static au.edu.griffithuni.project302.tools.Constants.CONTROL_PANEL_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.MARGIN;
import static au.edu.griffithuni.project302.tools.Constants.PANEL_TITLE;
import static au.edu.griffithuni.project302.tools.Constants.PANEL_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_HEIGHT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import au.edu.griffithuni.project302.gui.middle.UiCanvas;

public class UiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel upper;
	private JPanel bottom;

	private UiCanvas canvas;

	public UiFrame(String title) {
		super(title);
		setUi();
	}
	
	private void setUi() {
		int position = MARGIN;

		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setContentPane(contentPane);
		contentPane.setBackground(COLOR_0);
		contentPane.setLayout(null);

		position = setUpperPanel(position);
		position = setScreen(position);
		position = setBottomPanel(position);
	}

	private int setUpperPanel(int position) {
		upper = new JPanel();
		upper.setLayout(null);
		upper.setBackground(COLOR_1);
		upper.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		upper.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(upper);
		return position += (CONTROL_PANEL_HEIGHT + MARGIN);
	}

	private int setScreen(int position) {
		canvas = new UiCanvas();
		canvas.setBackground(COLOR_2);
		canvas.setBounds(MARGIN, position, PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		canvas.setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		contentPane.add(canvas);
		position += (SCREEN_PANEL_HEIGHT + MARGIN);
		return position;
	}

	private int setBottomPanel(int position) {
		bottom = new JPanel();
		bottom.setLayout(null);
		bottom.setBackground(COLOR_3);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		bottom.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(bottom);
		return position;
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
