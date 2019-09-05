package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_LABEL_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.SCALE_LABEL;

import javax.swing.JLabel;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

/**
 * label object
 * @author Firklaag_ins
 *
 */
public final class BtmLabel extends JLabel implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	
	public BtmLabel(ApplicationManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void iInitialize() {
		setText(SCALE_LABEL);
		setBounds(LOWER_LABEL_LOC_X, LOWER_LABEL_LOC_Y, LOWER_LABEL_SIZE_X, LOWER_LABEL_SIZE_Y);
		manager.addComponent(this);
	}

	@Override
	public void iPlay() {}

	@Override
	public void iWait() {}

}
