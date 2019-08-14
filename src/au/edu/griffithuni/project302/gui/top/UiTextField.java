package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_Y;

import javax.swing.JTextField;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class UiTextField extends JTextField implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationGuiManager manager;
	
	public UiTextField(ApplicationGuiManager manager) {
		this.manager = manager;
	}

	public void setAddr(String addr) {
		setText(addr);
	}

	@Override
	public void iInitialize() {
		setBounds(UPPER_TEXT_LOC_X, UPPER_TEXT_LOC_Y,UPPER_TEXT_SIZE_X,UPPER_TEXT_SIZE_Y);
		getManager().addComponentUpper(this);
	}

	/**
	 * @return the manager
	 */
	public ApplicationGuiManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(ApplicationGuiManager manager) {
		this.manager = manager;
	}

	
}
