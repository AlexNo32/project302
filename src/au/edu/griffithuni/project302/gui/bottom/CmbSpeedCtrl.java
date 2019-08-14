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

public class CmbSpeedCtrl extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmbSpeedCtrl(ApplicationManager manager) {
		super(manager);
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		for(String s: PROCE_BAR_CONTENYS)
			addItem(new ComboxItem(s, ""));
		
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
			
		});
		
		getManager().addComponentBottom(this);
	}

	@Override
	public void update(Object[] array) {
		// do nothing
	}
	
}
