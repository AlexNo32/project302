package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.COMBOBOX_DEFAULT;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_COMBOX_SIZE_Y;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;
import au.edu.griffithuni.project302.gui.implement.TopFlieList.ComboxItem;

/**
 * Existing file list
 * @author Firklaag_ins
 *
 */
public final class TopFlieList extends JComboBox<ComboxItem> implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationManager manager;
	
	/* Constructor */
	public TopFlieList(ApplicationManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void iInitialize() {
		setBounds(UPPER_COMBOX_LOC_X, UPPER_COMBOX_LOC_Y, UPPER_COMBOX_SIZE_X, UPPER_COMBOX_SIZE_Y);
		addItem(new ComboxItem(COMBOBOX_DEFAULT, ""));

		manager.addComponent(this);
		
		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()  == ItemEvent.SELECTED) {
					ComboxItem item = (ComboxItem) e.getItem(); 
					manager.addressFileld.setText(item.getAbsPath());
					manager.animate.setCurrentPerforme(item.getAbsPath());
				}
				
			}
			
		});
	}

	@Override
	public void iWait() {
		setEnabled(true);
	}
	
	@Override
	public void iPlay() {
		setEnabled(false);
	}
	
	/* update file list */
	public void update(String[] items) {
		removeAllItems();
		
		for(String abs: items) {
			String fName = abs.substring(abs.lastIndexOf("\\") + 1);
			addItem(new ComboxItem(fName, abs));
		}
		setSelectedIndex(0); 
	}
	
	/**
	 * item object
	 * 
	 * @author Firklaag_ins
	 *
	 */
	class ComboxItem {

		private String fName; // display content
		private String absPath; // value

		public ComboxItem(String fName, String absPath) {
			this.fName = fName;
			this.absPath = absPath;
		}

		public String getAbsPath() {
			return absPath;
		}

		public void setAbsPath(String absPath) {
			this.absPath = absPath;
		}

		@Override
		public String toString() {
			return fName;
		}
	}

}
