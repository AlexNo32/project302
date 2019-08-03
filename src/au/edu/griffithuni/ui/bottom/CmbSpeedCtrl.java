package au.edu.griffithuni.ui.bottom;

import au.edu.griffithuni.ui.UiCombobox;
import au.edu.griffithuni.ui.ViewerFrame;
import static au.edu.griffithuni.tools.Constants.*;

public class CmbSpeedCtrl extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmbSpeedCtrl(ViewerFrame frame) {
		super(frame);
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		
	}
	
}
