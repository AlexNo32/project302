package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.COMBOBOX_DEFAULT;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_Y;

import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.UiCombobox;
import au.edu.griffithuni.project302.vo.PositionVo;

public class CmbFlieList extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, List<PositionVo>> csvData = new HashMap<String, List<PositionVo>>();
	
	public CmbFlieList(ApplicationGuiManager manager) {
		super(manager, COMBOBOX_DEFAULT);
	}
	
	public void setItems(Map<String, List<PositionVo>> data) {
		csvData.putAll(data);
		updateUi();
	}
	
	private void updateUi() {
		removeAllItems();
		
		for(String fName: csvData.keySet())
			addItem(fName);
		
		setSelectedIndex(0); 
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange()  == ItemEvent.SELECTED) {
			String item = (String) e.getItem(); 
			if(csvData.containsKey(item)) {
//				getFrame().getCanvas().;
			}
		}
		
	}

	@Override
	public void iInitialize() {
		setSelectedIndex(0); 
		setBounds(UPPER_COMBOX_LOC_X, UPPER_COMBOX_LOC_Y, UPPER_COMBOX_SIZE_X, UPPER_COMBOX_SIZE_Y);
		
		getManager().addComponentUpper(this);
	}

}
