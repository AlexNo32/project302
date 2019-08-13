package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.*;

import javax.swing.JTextField;

public class UiTextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UiTextField() {
		setBounds(UPPER_TEXT_LOC_X, UPPER_TEXT_LOC_Y,UPPER_TEXT_SIZE_X,UPPER_TEXT_SIZE_Y);
	}

	public void setAddr(String addr) {
		setText(addr);
	}
}
