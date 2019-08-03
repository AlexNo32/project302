package au.edu.griffithuni.ui.upper;

import static au.edu.griffithuni.tools.Constants.COMBOBOX_DEFAULT;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_LOC_X;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_LOC_Y;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_SIZE_X;
import static au.edu.griffithuni.tools.Constants.UPPER_COMBOX_SIZE_Y;

import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.edu.griffithuni.ui.UiCombobox;
import au.edu.griffithuni.ui.ViewerFrame;
import au.edu.griffithuni.vo.PositionVo;

public class CmbFlieList extends UiCombobox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, List<PositionVo>> csvData = new HashMap<String, List<PositionVo>>();
	
	public CmbFlieList(ViewerFrame frame) {
		super(frame);
		addItem(COMBOBOX_DEFAULT);
		setSelectedIndex(0); 
		setBounds(UPPER_COMBOX_LOC_X, UPPER_COMBOX_LOC_Y, UPPER_COMBOX_SIZE_X, UPPER_COMBOX_SIZE_Y);
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
		// TODO Auto-generated method stub
		
	}


}
