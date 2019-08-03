package au.edu.griffithuni.ui;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public abstract class UiSlider extends JSlider implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UiSlider() {
		addChangeListener(this);
	}

}
