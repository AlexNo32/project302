package au.edu.griffithuni;

import static au.edu.griffithuni.tools.Constants.FRAME_TITLE;
import static au.edu.griffithuni.tools.Constants.FRAME_WIDTH;
import static au.edu.griffithuni.tools.Constants.FRANE_HEIGHT;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import au.edu.griffithuni.ui.ViewerFrame;

/**
 * Main entry of the application
 * 
 * @author Firklaag_ins
 *
 */
public class Daemon {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ViewerFrame f = new ViewerFrame(FRAME_TITLE);
//				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
				f.setLocation((int)(screenSize.getWidth() - FRAME_WIDTH) / 2, (int)(screenSize.getHeight() - FRANE_HEIGHT) / 2);
				f.setSize(FRAME_WIDTH, FRANE_HEIGHT);
				f.setResizable(false);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}

		});


	}

}
