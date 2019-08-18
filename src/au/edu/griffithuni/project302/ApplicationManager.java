package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.FRANE_HEIGHT;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import au.edu.griffithuni.project302.gui.middle.UiCanvas;
import au.edu.griffithuni.project302.gui.top.BtnFileChooser;
import au.edu.griffithuni.project302.gui.top.CmbFlieList;
import au.edu.griffithuni.project302.gui.top.UiTextField;
import au.edu.griffithuni.project302.tools.FileLoadingWorker;

/**
 * Application manager, which control gui and part of logic of app.
 * @author Firklaag_ins
 *
 */
public class ApplicationManager {
	/* animation control manager */
	AnimatedManager animate;
	
	/* GUI elements list */
	private List<IComponent> components = new ArrayList<IComponent>();
	private UiFrame mainFrame; // main frame
	private JPanel contentPane; // 
	private DropMenu menu; // banner menu

	private UiCombobox flieList; // top left, all existing files list
	private UiTextField addressFileld; // top middle, file path, usage limited  
	private UiButton btnFile; // top right, file selector

	private UiCanvas canvas;
	
	private UiButton playCtrl;
	private UiCombobox speedCtrl;
	private UiSlider proceBar;
	private UiLabel scaleLab;
	private UiSlider scaleBar;

	private ApplicationManager() {
		animate = new AnimatedManager(this);
		mainFrame = ApplicationGuiFactory.generator();
		menu = new DropMenu(this);
		
		flieList = new CmbFlieList(this);
		addressFileld = new UiTextField(this);
		btnFile = new BtnFileChooser(this);
		canvas = new UiCanvas(this);
		playCtrl = new PlayControl(this);
		speedCtrl = new CmbSpeedCtrl(this);
		proceBar = new ProgressBar(this);
		scaleLab = new UiLabel(this);
		scaleBar = new ScaleBar(this);

		components.add(flieList);
		components.add(addressFileld);
		components.add(btnFile);

		components.add(canvas);
		
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

	public void showFileOpenDialog(FileNameExtensionFilter filter) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        
        int result = fileChooser.showOpenDialog(btnFile);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles(); 
            new FileLoadingWorker(this, files).execute();
        }
	}
	
	public void initialize(){
		for(IComponent c : components){
			c.iInitialize();
		}
	}
	
	public void delay() {
		for(IComponent c : components){
			c.iWait();
		}
	}
	
	public void play(){
		for(IComponent c : components){
			c.iPlay();
		}
	}
	
	public void pause() {
		for(IComponent c : components){
			c.iPause();
		}
	}
	
	public void finish() {
		for(IComponent c : components){
			c.iFinished();
		}
	}

	public void addComponentUpper(JComponent o) {
		mainFrame.getUpper().add(o);
	}
	
	public void addComponentBottom(JComponent o) {
		mainFrame.getBottom().add(o);
	}
	
	/**
	 * @param currentData the currentData to set
	 */
	public void setCurrentData(String currentData) {
		animate.setCurrentData(currentData);
	}
	
	public static ApplicationManager getInstance() {
		return ApplicationManagerHolder.instance;
	}

	private static class ApplicationManagerHolder {
		private static final ApplicationManager instance = new ApplicationManager();
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
	 * @return the flieList
	 */
	public UiCombobox getFlieList() {
		return flieList;
	}

	/**
	 * @return the addressFileld
	 */
	public UiTextField getAddressFileld() {
		return addressFileld;
	}

	/**
	 * @return the btnFile
	 */
	public UiButton getBtnFile() {
		return btnFile;
	}

	/**
	 * @return the playCtrl
	 */
	public UiButton getPlayCtrl() {
		return playCtrl;
	}

	/**
	 * @return the speedCtrl
	 */
	public UiCombobox getSpeedCtrl() {
		return speedCtrl;
	}
	
	/**
	 * @return the proceBar
	 */
	public UiSlider getProceBar() {
		return proceBar;
	}

	/**
	 * @return the scaleLab
	 */
	public UiLabel getScaleLab() {
		return scaleLab;
	}

	/**
	 * @return the scaleBar
	 */
	public UiSlider getScaleBar() {
		return scaleBar;
	}

	/**
	 * @return the animate
	 */
	public AnimatedManager getAnimate() {
		return animate;
	}

	/**
	 * @param animate the animate to set
	 */
	public void setAnimate(AnimatedManager animate) {
		this.animate = animate;
	}

	public UiCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(UiCanvas canvas) {
		this.canvas = canvas;
	}

}
