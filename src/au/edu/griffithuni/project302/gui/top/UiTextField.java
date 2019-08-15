package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_Y;

import javax.swing.JTextField;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class UiTextField extends JTextField implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationManager manager;
	
	public UiTextField(ApplicationManager manager) {
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
	public ApplicationManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(ApplicationManager manager) {
		this.manager = manager;
	}

	@Override
	public void iPlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iWait() {
		// TODO Auto-generated method stub
		
	}

	
}
