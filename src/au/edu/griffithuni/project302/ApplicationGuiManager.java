package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.FRANE_HEIGHT;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import au.edu.griffithuni.project302.gui.DropMenu;
import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.gui.UiButton;
import au.edu.griffithuni.project302.gui.UiCombobox;
import au.edu.griffithuni.project302.gui.UiFrame;
import au.edu.griffithuni.project302.gui.UiSlider;
import au.edu.griffithuni.project302.gui.bottom.CmbSpeedCtrl;
import au.edu.griffithuni.project302.gui.bottom.PlayControl;
import au.edu.griffithuni.project302.gui.bottom.ProgressBar;
import au.edu.griffithuni.project302.gui.bottom.ScaleBar;
import au.edu.griffithuni.project302.gui.bottom.UiLabel;
import au.edu.griffithuni.project302.gui.top.BtnFileChooser;
import au.edu.griffithuni.project302.gui.top.CmbFlieList;
import au.edu.griffithuni.project302.gui.top.UiTextField;

public class ApplicationGuiManager {

	private List<IComponent> components = new ArrayList<IComponent>();
	private UiFrame mainFrame;
	private JPanel contentPane;
	private DropMenu menu;

	private UiCombobox flieList;
	private UiTextField addressFileld;
	private UiButton btnFile;

	private UiButton playCtrl;
	private UiCombobox speedCtrl;
	private UiSlider proceBar;
	private UiLabel scaleLab;
	private UiSlider scaleBar;

	private ApplicationGuiManager() {
		mainFrame = ApplicationGuiFactory.generator();
		menu = new DropMenu(this);
		
		flieList = new CmbFlieList(this);
		addressFileld = new UiTextField(this);
		btnFile = new BtnFileChooser(this);

		playCtrl = new PlayControl(this);
		speedCtrl = new CmbSpeedCtrl(this);
		proceBar = new ProgressBar(this);
		scaleLab = new UiLabel(this);
		scaleBar = new ScaleBar(this);

		components.add(flieList);
		components.add(addressFileld);
		components.add(btnFile);

		components.add(playCtrl);
		components.add(speedCtrl);
		components.add(proceBar);
		components.add(scaleLab);
		components.add(scaleBar);

		mainFrame.setJMenuBar(menu);
		initialize();
	}

	public void draw() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				mainFrame.setLocation((int) (screenSize.getWidth() - FRAME_WIDTH) / 2, (int) (screenSize.getHeight() - FRANE_HEIGHT) / 2);
				mainFrame.setSize(FRAME_WIDTH, FRANE_HEIGHT);
				mainFrame.setResizable(false);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setVisible(true);
			}

		});
	}

	public void initialize(){
		for(IComponent c : components){
			c.iInitialize();
		}
	}

	public void addComponentUpper(JComponent o) {
		mainFrame.getUpper().add(o);
	}
	
	public void addComponentBottom(JComponent o) {
		mainFrame.getBottom().add(o);
	}
	
	public static ApplicationGuiManager getInstance() {
		return ApplicationManagerHolder.instance;
	}

	private static class ApplicationManagerHolder {
		private static final ApplicationGuiManager instance = new ApplicationGuiManager();
	}

	/**
	 * @return the components
	 */
	public List<IComponent> getComponents() {
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(List<IComponent> components) {
		this.components = components;
	}

	/**
	 * @return the mainFrame
	 */
	public UiFrame getMainFrame() {
		return mainFrame;
	}

	/**
	 * @param mainFrame the mainFrame to set
	 */
	public void setMainFrame(UiFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @param contentPane the contentPane to set
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	/**
	 * @return the menu
	 */
	public DropMenu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(DropMenu menu) {
		this.menu = menu;
	}

	/**
	 * @return the flieList
	 */
	public UiCombobox getFlieList() {
		return flieList;
	}

	/**
	 * @param flieList the flieList to set
	 */
	public void setFlieList(UiCombobox flieList) {
		this.flieList = flieList;
	}

	/**
	 * @return the addressFileld
	 */
	public UiTextField getAddressFileld() {
		return addressFileld;
	}

	/**
	 * @param addressFileld the addressFileld to set
	 */
	public void setAddressFileld(UiTextField addressFileld) {
		this.addressFileld = addressFileld;
	}

	/**
	 * @return the btnFile
	 */
	public UiButton getBtnFile() {
		return btnFile;
	}

	/**
	 * @param btnFile the btnFile to set
	 */
	public void setBtnFile(UiButton btnFile) {
		this.btnFile = btnFile;
	}

//	/**
//	 * @return the canvas
//	 */
//	public UiCanvas getCanvas() {
//		return canvas;
//	}
//
//	/**
//	 * @param canvas the canvas to set
//	 */
//	public void setCanvas(UiCanvas canvas) {
//		this.canvas = canvas;
//	}

	/**
	 * @return the playCtrl
	 */
	public UiButton getPlayCtrl() {
		return playCtrl;
	}

	/**
	 * @param playCtrl the playCtrl to set
	 */
	public void setPlayCtrl(UiButton playCtrl) {
		this.playCtrl = playCtrl;
	}

	/**
	 * @return the speedCtrl
	 */
	public UiCombobox getSpeedCtrl() {
		return speedCtrl;
	}

	/**
	 * @param speedCtrl the speedCtrl to set
	 */
	public void setSpeedCtrl(UiCombobox speedCtrl) {
		this.speedCtrl = speedCtrl;
	}

	/**
	 * @return the proceBar
	 */
	public UiSlider getProceBar() {
		return proceBar;
	}

	/**
	 * @param proceBar the proceBar to set
	 */
	public void setProceBar(UiSlider proceBar) {
		this.proceBar = proceBar;
	}

	/**
	 * @return the scaleLab
	 */
	public UiLabel getScaleLab() {
		return scaleLab;
	}

	/**
	 * @param scaleLab the scaleLab to set
	 */
	public void setScaleLab(UiLabel scaleLab) {
		this.scaleLab = scaleLab;
	}

	/**
	 * @return the scaleBar
	 */
	public UiSlider getScaleBar() {
		return scaleBar;
	}

	/**
	 * @param scaleBar the scaleBar to set
	 */
	public void setScaleBar(UiSlider scaleBar) {
		this.scaleBar = scaleBar;
	}

}
