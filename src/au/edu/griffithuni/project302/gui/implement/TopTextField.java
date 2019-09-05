package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_Y;

import javax.swing.JTextField;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

/**
 * File address display field
 * Display only
 * 	- file drop (*)
 *  - read url (*)
 * @author Firklaag_ins
 */
public final class TopTextField extends JTextField implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationManager manager;
	
	/* Constructor */
	public TopTextField(ApplicationManager manager) {
		this.manager = manager;
	}

	@Override
	public void iInitialize() {
		setBounds(UPPER_TEXT_LOC_X, UPPER_TEXT_LOC_Y,UPPER_TEXT_SIZE_X,UPPER_TEXT_SIZE_Y);
		manager.addComponent(this);
	}

	@Override
	public void iWait() {
		setEnabled(true);
	}
	
	@Override
	public void iPlay() {
		setEnabled(false);
	}

}
