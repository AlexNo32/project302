package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_SIZE_Y;

import javax.swing.event.ChangeEvent;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiSlider;

public class ProgressBar extends UiSlider{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProgressBar(ApplicationManager manager) {
		super(manager);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iInitialize() {
		setMinimum(0);
		setMaximum(100);
		setValue(0);
		setBounds(LOWER_PROC_LOC_X, LOWER_PROC_LOC_Y, LOWER_PROC_SIZE_X, LOWER_PROC_SIZE_Y);
		
		getManager().addComponentBottom(this);
	}

}
