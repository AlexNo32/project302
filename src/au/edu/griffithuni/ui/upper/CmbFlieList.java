package au.edu.griffithuni.ui.upper;

import static au.edu.griffithuni.tools.Constants.COMBOBOX_DEFAULT;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_LOC_X;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_LOC_Y;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_SIZE_X;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_SIZE_Y;

import au.edu.griffithuni.ui.UiCombobox;
import au.edu.griffithuni.ui.ViewerFrame;

public class CmbFlieList extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CmbFlieList(ViewerFrame frame) {
		super(frame);

		addItem(COMBOBOX_DEFAULT);
		setBounds(UPPER_COMBOX_LOC_X, UPPER_COMBOX_LOC_Y, UPPER_COMBOX_SIZE_X, UPPER_COMBOX_SIZE_Y);
	}


}
