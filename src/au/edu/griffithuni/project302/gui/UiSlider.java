package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public abstract class UiSlider extends JSlider implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UiSlider() {
		setBackground(COLOR_3);
		addChangeListener(this);
	}

}
