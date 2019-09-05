	package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_0;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_1;
import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;
import static au.edu.griffithuni.project302.tools.Constants.FRAME_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.FRANE_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.SCREEN_PANEL_WIDTH;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private JPanel contentPane;
//	private JPanel upper;
//	private JPanel bottom;

	public MainFrame(String title) {
		super(title);
		setUi();
	}
	
	public void start() {
		Font font = new Font("Arial", Font.PLAIN, 12);
		UIManager.put("TextField.font", font);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (screenSize.getWidth() - FRAME_WIDTH) / 2, 20);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
		pack();
		setVisible(true);
	}
	
	private void setUi() {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(FRAME_WIDTH, FRANE_HEIGHT)); 
		contentPane.setLayout(null);
		setContentPane(contentPane );
	}

}
