package au.edu.griffithuni.project302.gui;

import javax.swing.JComboBox;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiCombobox.ComboxItem;

public abstract class UiCombobox extends JComboBox<ComboxItem> implements IComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	
	public UiCombobox(ApplicationManager manager) {
		this.manager = manager;
	}

	/**
	 * @return the manager
	 */
	public ApplicationManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(ApplicationManager manager) {
		this.manager = manager;
	}

	public abstract void update(Object[] array);
	
	public class ComboxItem{
	
		private String fName;
		private String absPath;
		
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
