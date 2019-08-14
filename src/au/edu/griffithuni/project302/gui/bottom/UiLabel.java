package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.SCALE_LABEL;

import javax.swing.JLabel;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class UiLabel extends JLabel implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationGuiManager manager;
	
	public UiLabel(ApplicationGuiManager manager) {
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
