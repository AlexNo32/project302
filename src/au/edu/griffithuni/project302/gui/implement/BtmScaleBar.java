package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_SCALE_BAR_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_SCALE_BAR_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_SCALE_BAR_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_SCALE_BAR_SIZE_Y;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public final class BtmScaleBar extends JSlider implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationManager manager;
	
	public BtmScaleBar(ApplicationManager manager) {
		this.manager = manager;
	}

	@Override
	public void iInitialize() {
		setMinimum(1);
		setMaximum(5);
		setValue(1);
		setBounds(LOWER_SCALE_BAR_LOC_X, LOWER_SCALE_BAR_LOC_Y, LOWER_SCALE_BAR_SIZE_X, LOWER_SCALE_BAR_SIZE_Y);
		manager.addComponent(this);
		
		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setEnabled(false);
	}

	@Override
	public void iWait() {
		setEnabled(true);
		setValue(1);
	}
	
	@Override
	public void iPlay() {}

}
