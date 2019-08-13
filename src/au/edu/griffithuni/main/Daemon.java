package au.edu.griffithuni.main;

import au.edu.griffithuni.project302.ApplicationGuiManager;

/**
 * Main entry of the application
 * 
 * @author Firklaag_ins
 *
 */
public class Daemon {
	
	private ApplicationGuiManager appManager;
	
	public Daemon() {
		//do nothing
	}
	
	private void start() {
		appManager = ApplicationGuiManager.getInstance();
		appManager.draw();
	}
	
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				ViewerFrame f = new ViewerFrame(FRAME_TITLE);
////				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				
//				Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
//				f.setLocation((int)(screenSize.getWidth() - FRAME_WIDTH) / 2, (int)(screenSize.getHeight() - FRANE_HEIGHT) / 2);
//				f.setSize(FRAME_WIDTH, FRANE_HEIGHT);
//				f.setResizable(false);
//				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				f.setVisible(true);
//			}
//
//		});
//
//
//	}

}
