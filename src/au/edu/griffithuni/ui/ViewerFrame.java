package au.edu.griffithuni.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import static au.edu.griffithuni.tools.Constants.*;

import java.awt.Color;
import java.awt.Dimension;

public class ViewerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private DropMenu menu;
	
	private UiCombobox flieList;
	private UiTextField addressFileld;
	private UiFileChooser fileChooser;
	private UiButton btnPlay;
	private UiButton btnPause;
	private UiSlider proceBar;
	private UiSlider scaleBar;
	
	public ViewerFrame(String title) {
		super(title);
		
		menu = new DropMenu(this);
		setJMenuBar(menu);
		
		flieList = new UiCombobox(this);
		addressFileld = new UiTextField();
		fileChooser = new UiFileChooser();
		
		btnPlay = new UiButton(BUTTON_PALY);
		btnPause = new UiButton(BUTTON_PAUSE);
		
		proceBar = new UiSlider();
		scaleBar = new UiSlider();
		
		setUi();
	}
	
	private void setUi() {
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int position = MARGIN;
		JPanel upper = new JPanel();
		upper.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		upper.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(upper);
		position += (CONTROL_PANEL_HEIGHT + MARGIN);
		
		JPanel middle = new JPanel();
		middle.setBounds(MARGIN, position, PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		middle.setBorder(new TitledBorder(null, "Screen", TitledBorder.LEADING, TitledBorder.TOP, null));
		contentPane.add(middle);
		position += (SCREEN_PANEL_HEIGHT + MARGIN);
		
		JPanel bottom = new JPanel();
		bottom.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.add(bottom);

	}
	
	private void upperPanel() {
		JPanel upper = new JPanel();
		
		upper.setBackground(new Color(102, 102, 204));
		System.out.println(contentPane.getWidth());
		
		upper.setBounds(MARGIN, MARGIN, 430, 40);
		upper.setBorder(new LineBorder(Color.GRAY, 5, true));
		upper.setPreferredSize(new Dimension(100, 50));
		contentPane.add(upper);
	}


	private void middlePanel() {
		JPanel middle = new JPanel();
		middle.setBackground(new Color(51, 204, 0));
		middle.setBounds(2, 46, 430, 181);
		contentPane.add(middle);
	}
	
	private void bottomPanel() {
		JPanel lower = new JPanel();
		lower.setBackground(new Color(102, 102, 204));
		lower.setBounds(2, 228, 430, 30);
		contentPane.add(lower);
	}
//	
//	private void setPanel() {
//		contentPane = new JPanel();
//		contentPane.setBorder(new LineBorder(BORDER_COLOR, 3, true));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		contentPane.getWidth();
//		contentPane.getHeight();
//		
//		contentPane.add(upperPanel());
//		contentPane.add(lowerPanel());
//		contentPane.add(setScreen());
//	}
//	
//	private JPanel upperPanel() {
//		JPanel upper = new JPanel();
//		upper.setBounds(MARGIN, MARGIN, 774, 31);
//		upper.setPreferredSize(new Dimension(780, 20));
//		upper.setLayout(null);
//		
//		return upper;
//	}
//	
//	private JPanel lowerPanel() {
//		JPanel lower = new JPanel();
//		lower.setBounds(5, 497, 774, 36);
//		lower.setLayout(null);
//		
//		return lower;
//	}
//	
//	private JPanel setScreen() {
//		JPanel screen = new JPanel();
//		screen.setBackground(new Color(51, 255, 153));
//		screen.setBounds(5, 47, 774, 439);
//		
//		
//		return screen;
//	}
//	
	
}
