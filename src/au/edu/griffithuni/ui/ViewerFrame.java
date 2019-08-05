package au.edu.griffithuni.ui;

import static au.edu.griffithuni.tools.Constants.COLOR_0;
import static au.edu.griffithuni.tools.Constants.COLOR_1;
import static au.edu.griffithuni.tools.Constants.COLOR_2;
import static au.edu.griffithuni.tools.Constants.COLOR_3;
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
import au.edu.griffithuni.ui.middle.UiCanvas;
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
	
	private UiCanvas canvas;
	
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
		
		canvas = new UiCanvas();
		
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
		contentPane.setBackground(COLOR_0);
		contentPane.setLayout(null);
		
		//------------------------------
		int position = MARGIN;
		JPanel upper = new JPanel();
		upper.setLayout(null);
		upper.setBackground(COLOR_1);
		upper.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		upper.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(upper);
		position += (CONTROL_PANEL_HEIGHT + MARGIN);
		
		upper.add(flieList);
		upper.add(addressFileld);
		upper.add(btnFile);
		
		//-------------------------------
		canvas.setBackground(COLOR_2);
		canvas.setBounds(MARGIN, position, PANEL_WIDTH, SCREEN_PANEL_HEIGHT);
		canvas.setBorder(new TitledBorder(null, PANEL_TITLE, TitledBorder.LEADING, TitledBorder.TOP, null));
		contentPane.add(canvas);
		position += (SCREEN_PANEL_HEIGHT + MARGIN);
		
		//---------------------------------
		JPanel bottom = new JPanel();
		bottom.setLayout(null);
		bottom.setBackground(COLOR_3);
		bottom.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		bottom.setBounds(MARGIN, position, PANEL_WIDTH, CONTROL_PANEL_HEIGHT);
		contentPane.add(bottom);
		
		bottom.add(playCtrl);
		bottom.add(speedCtrl);
		bottom.add(proceBar);
		bottom.add(scaleLab);
		bottom.add(scaleBar);

	}

//	public void openFile()
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public DropMenu getMenu() {
		return menu;
	}

	public UiCombobox getFlieList() {
		return flieList;
	}

	public UiTextField getAddressFileld() {
		return addressFileld;
	}

	public UiButton getBtnFile() {
		return btnFile;
	}

	public UiButton getPlayCtrl() {
		return playCtrl;
	}

	public UiCombobox getSpeedCtrl() {
		return speedCtrl;
	}

	public UiSlider getProceBar() {
		return proceBar;
	}

	public UiLabel getScaleLab() {
		return scaleLab;
	}

	public UiSlider getScaleBar() {
		return scaleBar;
	}
	
}
