package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.*;

import javax.swing.event.ChangeEvent;

import au.edu.griffithuni.project302.gui.UiSlider;

public class ProgressBar extends UiSlider{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProgressBar() {
		setMinimum(0);
		setMaximum(100);
		setValue(0);
		setBounds(LOWER_PROC_LOC_X, LOWER_PROC_LOC_Y, LOWER_PROC_SIZE_X, LOWER_PROC_SIZE_Y);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
