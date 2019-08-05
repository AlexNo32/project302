package au.edu.griffithuni.ui;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import static au.edu.griffithuni.tools.Constants.COLOR_3;

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
