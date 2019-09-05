package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.PROCE_BAR_CONTENYS;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;


/***
 * play speed control
 * @author Firklaag_ins
 *
 */
public class BtmSpeedCtrl extends JComboBox<String> implements IComponent  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float newSpeedRate;
	private ApplicationManager manager;
	
	/* Constructor */
	public BtmSpeedCtrl(ApplicationManager manager) {
		this.manager = manager;
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		for(String s: PROCE_BAR_CONTENYS)
			addItem(s);

		manager.addComponent(this);
		
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
			
		});
		
		newSpeedRate = 1.0f;
		setEnabled(false);
	}

	@Override
	public void iWait() {
		setEnabled(true);
		manager.getAnimate().setSpeedRate(getNewSpeedRate());
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

	public float getNewSpeedRate() {
		return newSpeedRate;
	}

	public void setNewSpeedRate(float newSpeedRate) {
		this.newSpeedRate = newSpeedRate;
	}
	
	

}
