package au.edu.griffithuni.ui;

import javax.swing.JLabel;
import static au.edu.griffithuni.tools.Constants.*;

public class UiLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiLabel() {
		setText(SCALE_LABEL);
		setBounds(LOWER_LABEL_LOC_X, LOWER_LABEL_LOC_Y, LOWER_LABEL_SIZE_X, LOWER_LABEL_SIZE_Y);
	}
	
}
