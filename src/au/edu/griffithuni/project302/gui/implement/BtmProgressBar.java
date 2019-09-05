package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_PROC_SIZE_Y;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class BtmProgressBar extends JSlider implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationManager manager;
	
	public BtmProgressBar(ApplicationManager manager) {
		this.manager = manager;
		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_PROC_LOC_X, LOWER_PROC_LOC_Y, LOWER_PROC_SIZE_X, LOWER_PROC_SIZE_Y);

		manager.addComponent(this);
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