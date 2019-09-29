package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_TITLE;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.gui.implement.AdditionButton1;
import au.edu.griffithuni.project302.gui.implement.AdditionButton2;
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
import au.edu.griffithuni.project302.vo.PositionVo;

/**
 * Application manager, which control gui and part of logic of app.
 * 
 * @author Firklaag_ins
 *
 */
public class ApplicationManager {

	/* animation control manager */
	public AnimatedManager animate;

	/* GUI elements list */
	public List<IComponent> components = new ArrayList<IComponent>();
	/* Components */
	public TopMenu menu; // banner menu
	public TopFlieList flieList; // top left, all existing files list
	public TopTextField addressFileld; // top middle, file path
	public TopFileChooser fileChooser; // top right, file selector

	public BtmPlayControl playCtrl;// play/pause button
	public BtmSpeedCtrl speedCtrl; // speed control
	public BtmProgressBar proceBar; // process bar
	public BtmLabel scaleLab; // label
	public BtmScaleBar scaleBar; // scale bar

	public MainFrame mainFrame; // main frame
	public MainCanvas canvas; // canvas

	/* additions */
	public AdditionButton1 ab1;
	public AdditionButton2 ab2;
	
	private ApplicationManager() {
		animate = new AnimatedManager(this);

		mainFrame = new MainFrame(FRAME_TITLE);
		canvas = new MainCanvas(this);

		menu = new TopMenu(this);
		flieList = new TopFlieList(this);
		addressFileld = new TopTextField(this);
		fileChooser = new TopFileChooser(this);

		playCtrl = new BtmPlayControl(this);
		speedCtrl = new BtmSpeedCtrl(this);
		proceBar = new BtmProgressBar(this);
		scaleLab = new BtmLabel(this);
		scaleBar = new BtmScaleBar(this);

		ab1 = new AdditionButton1(this);
		ab2 = new AdditionButton2(this);
		
		components.add(flieList);
		components.add(addressFileld);
		components.add(fileChooser);
		components.add(playCtrl);
		components.add(speedCtrl);
		components.add(proceBar);
		components.add(scaleLab);
		components.add(scaleBar);
		components.add(canvas);
		
		components.add(ab1);
		components.add(ab2);

		playCtrl.addKeyListener(new GuiKeyAdapter());
		speedCtrl.addKeyListener(new GuiKeyAdapter());
		proceBar.addKeyListener(new GuiKeyAdapter());
		scaleBar.addKeyListener(new GuiKeyAdapter());

		iInitialize();
	}

	/* when the data get ready */
	public void poise(Map<String, LinkedList<PositionVo>> csvPack) {
		// 1, insert data to animate manager
		animate.recv(csvPack);
		// 2, update file list
		String[] fdList = animate.csvDataMap.keySet().stream().toArray(String[]::new);
		flieList.update(fdList);
	}

	public void draw() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mainFrame.start();
			}

		});
	}

	/* initial state */
	public void iInitialize() {
		for (IComponent c : components) {
			c.iInitialize();
		}
	}

	/* wait state */
	public void iWait() {
		for (IComponent c : components) {
			c.iWait();
		}
//		mainFrame.requestFocus();
	}

	/* play state */
	public void iPlay() {
		for (IComponent c : components) {
			c.iPlay();
		}
//		mainFrame.requestFocus();
	}

	/* add components to the main frame */
	public void addComponent(JComponent o) {
		mainFrame.getContentPane().add(o);
	}

	public static ApplicationManager getInstance() {
		return ApplicationManagerHolder.instance;
	}

	private static class ApplicationManagerHolder {
		private static final ApplicationManager instance = new ApplicationManager();
	}

	/* Key listener */
	private class GuiKeyAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
//				PositionVo v = new PositionVo(1d, 0d, 0d, 0d, 0d, 0d, 0d);
//				canvas.setJoneDoe(v, new Point(0, 0), Direction.NONE);
				animate.finish();
			}
		}

	}

}
