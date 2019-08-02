package au.edu.griffithuni.ui;

import java.awt.Dimension;

import javax.swing.JButton;

public class UiButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiButton(String title) {
		super(title);
		
		this.setPreferredSize(new Dimension(100,50));
	}

}
