package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.SCALE_LABEL;

import javax.swing.JLabel;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class UiLabel extends JLabel implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	
	public UiLabel(ApplicationManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void iInitialize() {
		setText(SCALE_LABEL);
		setBounds(LOWER_LABEL_LOC_X, LOWER_LABEL_LOC_Y, LOWER_LABEL_SIZE_X, LOWER_LABEL_SIZE_Y);
		
		getManager().addComponentBottom(this);
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
