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

/**
 * progress bar
 * @author Firklaag_ins
 *
 */
public final class BtmProgressBar extends JSlider implements IComponent{

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
				int value = getValue();
		        if (value > 0) {
		        	manager.animate.setCursor(value);
		        }
			}
			
		});
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_PROC_LOC_X, LOWER_PROC_LOC_Y, LOWER_PROC_SIZE_X, LOWER_PROC_SIZE_Y);
		manager.addComponent(this);
		setEnabled(false);
	}

	@Override
	public void iPlay() {
		
		
	}

	@Override
	public void iWait() {
		setEnabled(true);
		setValue(1);
	}

}
