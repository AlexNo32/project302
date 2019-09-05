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

public class BtmScaleBar extends JSlider implements IComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float newScaleRate;
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
		
		newScaleRate = 10f;
	}

	@Override
	public void iWait() {
		manager.getAnimate().setScaleRate(getNewScaleRate());
		
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

	public float getNewScaleRate() {
		return newScaleRate;
	}

	public void setNewScaleRate(float newScaleRate) {
		this.newScaleRate = newScaleRate;
	}

}