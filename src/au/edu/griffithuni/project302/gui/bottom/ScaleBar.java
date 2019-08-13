package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.*;

import javax.swing.event.ChangeEvent;

import au.edu.griffithuni.project302.gui.UiSlider;

public class ScaleBar extends UiSlider{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScaleBar() {
		setMinimum(1);
		setMaximum(5);
		setValue(1);
		setBounds(LOWER_SCALE_BAR_LOC_X, LOWER_SCALE_BAR_LOC_Y, LOWER_SCALE_BAR_SIZE_X, LOWER_SCALE_BAR_SIZE_Y);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
