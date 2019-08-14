package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.POS_BOTTOM;
import static au.edu.griffithuni.project302.tools.Constants.PROCE_BAR_CONTENYS;

import java.awt.event.ItemEvent;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.UiCombobox;

public class CmbSpeedCtrl extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmbSpeedCtrl(ApplicationGuiManager manager) {
		super(manager, PROCE_BAR_CONTENYS);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		//TODO  Add Action listener
		getManager().addComponentBottom(this);
	}
	
}
