package au.edu.griffithuni.ui;

import static au.edu.griffithuni.tools.Constants.CONTROL_PANEL_HEIGHT;
import static au.edu.griffithuni.tools.Constants.MARGIN;
import static au.edu.griffithuni.tools.Constants.PANEL_TITLE;
import static au.edu.griffithuni.tools.Constants.PANEL_WIDTH;
import static au.edu.griffithuni.tools.Constants.SCREEN_PANEL_HEIGHT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import au.edu.griffithuni.ui.bottom.CmbSpeedCtrl;
import au.edu.griffithuni.ui.bottom.PlayControl;
import au.edu.griffithuni.ui.bottom.ProgressBar;
import au.edu.griffithuni.ui.bottom.ScaleBar;
import au.edu.griffithuni.ui.upper.BtnFileChooser;
import au.edu.griffithuni.ui.upper.CmbFlieList;

public class ViewerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private DropMenu menu;
	
	private UiCombobox flieList;
	private UiTextField addressFileld;
	private UiButton btnFile;
	private UiFileChooser fileChooser;
	
	private UiButton playCtrl;
	private UiCombobox speedCtrl;
	private UiSlider proceBar;
	private UiLabel scaleLab;
	private UiSlider scaleBar;
	
	public ViewerFrame(String title) {
		super(title);
		
		menu = new DropMenu(this);
		setJMenuBar(menu);
		
		flieList = new CmbFlieList(this);
		addressFileld = new UiTextField();
		btnFile = new BtnFileChooser(this);
		fileChooser = new UiFileChooser();
		
		playCtrl = new PlayControl(this);
		speedCtrl = new CmbSpeedCtrl(this);
		proceBar = new ProgressBar();
		scaleLab = new UiLabel();
		scaleBar = new ScaleBar();
		
		setUi();
	}
	
	private void setUi() {
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//------------------------------
		int position = MARGIN;
		JPanel upper = new JPanel();
		upper.setLayout(null);
		upper.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		upper.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(upper);
		position += (CONTROL_PANEL_HEIGHT + MARGIN);
		
		upper.add(flieList);
		upper.add(addressFileld);
		upper.add(btnFile);
		
		//-------------------------------
		JPanel middle = new JPanel();
		middle.setBounds(MARGIN, position, PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		middle.setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		contentPane.add(middle);
		position += (SCREEN_PANEL_HEIGHT + MARGIN);
		
		//---------------------------------
		JPanel bottom = new JPanel();
		bottom.setLayout(null);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		bottom.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(bottom);
		
		bottom.add(playCtrl);
		bottom.add(speedCtrl);
		bottom.add(proceBar);
		bottom.add(scaleLab);
		bottom.add(scaleBar);

	}
	
}
