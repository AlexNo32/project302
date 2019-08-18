package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.PROCE_BAR_CONTENYS;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiCombobox;

/***
 * play speed control
 * @author Firklaag_ins
 *
 */
public class CmbSpeedCtrl extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float newSpeedRate;
	
	/* Constructor */
	public CmbSpeedCtrl(ApplicationManager manager) {
		super(manager);
		
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
			
		});
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		for(String s: PROCE_BAR_CONTENYS)
			addItem(new ComboxItem(s, ""));
		getManager().addComponentBottom(this);
		newSpeedRate = 1.0f;
		setEnabled(false);
	}

	@Override
	public void iWait() {
		setEnabled(true);
		getManager().getAnimate().setSpeedRate(getNewSpeedRate());
	}
	
	@Override
	public void update(Object[] array) {
		// do nothing
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
