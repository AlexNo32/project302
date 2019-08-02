package au.edu.griffithuni.ui;

import javax.swing.JComboBox;

public class UiCombobox extends JComboBox<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewerFrame frame;
	
	public UiCombobox(ViewerFrame frame) {
		this.frame = frame;
	}

}
