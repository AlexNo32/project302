package au.edu.griffithuni.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class UiButton extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewerFrame frame;
	
	public UiButton(ViewerFrame frame) {
		this.frame = frame;
		addActionListener(this);
	}

	public ViewerFrame getFrame() {
		return frame;
	}

}
