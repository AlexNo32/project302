package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.*;

import java.awt.event.ItemEvent;

import au.edu.griffithuni.project302.gui.UiCombobox;
import au.edu.griffithuni.project302.gui.ViewerFrame;

public class CmbSpeedCtrl extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmbSpeedCtrl(ViewerFrame frame) {
		super(frame, PROCE_BAR_CONTENYS);
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
