package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.COMBOBOX_DEFAULT;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_Y;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiCombobox;

public class CmbFlieList extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmbFlieList(ApplicationManager manager) {
		super(manager);
	}
	
	public void update(Object[] items) {
		removeAllItems();
		
		for(Object abs: items) {
			String absPath = (String) abs;
			String fName = absPath.substring(absPath.lastIndexOf("\\") + 1);
			addItem(new ComboxItem(fName, absPath));
		}
		setSelectedIndex(0); 
	}

	@Override
	public void iInitialize() {
		setBounds(UPPER_COMBOX_LOC_X, UPPER_COMBOX_LOC_Y, UPPER_COMBOX_SIZE_X, UPPER_COMBOX_SIZE_Y);
		addItem(new ComboxItem(COMBOBOX_DEFAULT, ""));
		
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()  == ItemEvent.SELECTED) {
					ComboxItem item = (ComboxItem) e.getItem(); 
					
					getManager().getAddressFileld().setText(item.getAbsPath());
					getManager().setCurrentFile(item.getAbsPath());
				}
				
			}
			
		});
		
		getManager().addComponentUpper(this);
	}

}
