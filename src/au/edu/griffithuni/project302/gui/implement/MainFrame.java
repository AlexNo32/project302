package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_FONT;
import static au.edu.griffithuni.project302.tools.Constants.FRAME_WIDTH;
import static au.edu.griffithuni.project302.tools.Constants.FRANE_HEIGHT;
import static au.edu.griffithuni.project302.tools.Constants.THEME;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

/**
 * Main frame
 * @author Firklaag_ins
 *
 */
public final class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(String title) {
		super(title);
		setUi();
	}
	
	/* draw the frame */
	public void start() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (screenSize.getWidth() - FRAME_WIDTH) / 2, 40); // appear location
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(THEME);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		setFont();
		setIcon();
		pack();
		setVisible(true);
	}
	
	private void setFont() {
		FontUIResource fontRes = new FontUIResource(new Font(FRAME_FONT, Font.PLAIN, 12));
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);

			if (value instanceof FontUIResource) 
				UIManager.put(key, fontRes);
		}
	}
	
	private void setUi() {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(FRAME_WIDTH, FRANE_HEIGHT)); 
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}
	
	private void setIcon() {
		ImageIcon imgicon = new ImageIcon(".\\bin\\img\\guico2.png");
		setIconImage(imgicon.getImage());
	}

}
