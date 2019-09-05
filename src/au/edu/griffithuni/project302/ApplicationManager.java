package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_TITLE;
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
import javax.swing.UIManager;

import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.gui.implement.BtmLabel;
import au.edu.griffithuni.project302.gui.implement.BtmPlayControl;
import au.edu.griffithuni.project302.gui.implement.BtmProgressBar;
import au.edu.griffithuni.project302.gui.implement.BtmScaleBar;
import au.edu.griffithuni.project302.gui.implement.BtmSpeedCtrl;
import au.edu.griffithuni.project302.gui.implement.MainCanvas;
import au.edu.griffithuni.project302.gui.implement.MainFrame;
import au.edu.griffithuni.project302.gui.implement.TopFileChooser;
import au.edu.griffithuni.project302.gui.implement.TopFlieList;
import au.edu.griffithuni.project302.gui.implement.TopMenu;
import au.edu.griffithuni.project302.gui.implement.TopTextField;


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
	/* Components */
	private TopMenu menu; // banner menu
	private TopFlieList flieList; // top left, all existing files list
	private TopTextField addressFileld; // top middle, file path  
	private TopFileChooser fileChooser; // top right, file selector
	
	private BtmPlayControl playCtrl;// play/pause button
	private BtmSpeedCtrl speedCtrl; // speed control
	private BtmProgressBar proceBar; // process bar
	private BtmLabel scaleLab; // label
	private BtmScaleBar scaleBar; // scale bar

	private MainFrame mainFrame; // main frame
	private MainCanvas canvas; // canvas
	
	private JPanel contentPane; //
	
	private ApplicationManager() {
		animate = new AnimatedManager(this);
		
		mainFrame = new MainFrame(FRAME_TITLE);
		canvas =    new MainCanvas(this);
		
		menu =          new TopMenu(this);
		flieList =      new TopFlieList(this);
		addressFileld = new TopTextField(this);
		fileChooser =   new TopFileChooser(this);
		
		playCtrl =  new BtmPlayControl(this);
		speedCtrl = new BtmSpeedCtrl(this);
		proceBar =  new BtmProgressBar(this);
		scaleLab =  new BtmLabel(this);
		scaleBar =  new BtmScaleBar(this);

		components.add(flieList);
		components.add(addressFileld);
		components.add(fileChooser);
		components.add(playCtrl);
		components.add(speedCtrl);
		components.add(proceBar);
		components.add(scaleLab);
		components.add(scaleBar);
		
		components.add(canvas);
		
		mainFrame.setJMenuBar(menu);
		initialize();
	}

	public void draw() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mainFrame.start();
			}

		});
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

	public void addComponent(JComponent o) {
		mainFrame.getContentPane().add(o);
	}
	
//	public void addComponentBottom(JComponent o) {
//		mainFrame.getBottom().add(o);
//	}
	
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
	public MainFrame getMainFrame() {
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

	public MainCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(MainCanvas canvas) {
		this.canvas = canvas;
	}

}
