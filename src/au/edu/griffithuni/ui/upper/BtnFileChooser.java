package au.edu.griffithuni.ui.upper;

import static au.edu.griffithuni.tools.Constants.UPPER_BTN_FILE_LOC_X;
import static au.edu.griffithuni.tools.Constants.UPPER_BTN_FILE_LOC_Y;
import static au.edu.griffithuni.tools.Constants.UPPER_BTN_FILE_SIZE_X;
import static au.edu.griffithuni.tools.Constants.*;

import au.edu.griffithuni.ui.UiButton;
import au.edu.griffithuni.ui.ViewerFrame;

public class BtnFileChooser extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BtnFileChooser(ViewerFrame frame) {
		super(frame);
		setBounds(UPPER_BTN_FILE_LOC_X, UPPER_BTN_FILE_LOC_Y, UPPER_BTN_FILE_SIZE_X,UPPER_BTN_FILE_SIZE_Y);
		setText(BTN_FILE);
	}

}
