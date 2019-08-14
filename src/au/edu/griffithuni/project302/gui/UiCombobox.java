package au.edu.griffithuni.project302.gui;

import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import au.edu.griffithuni.project302.ApplicationGuiManager;

public abstract class UiCombobox extends JComboBox<String> implements ItemListener, IComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationGuiManager manager;
	
	public UiCombobox(ApplicationGuiManager manager, String[] items) {
		super(items);
		this.manager = manager;
		addItemListener(this);
	}

	/**
	 * @return the manager
	 */
	public ApplicationGuiManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(ApplicationGuiManager manager) {
		this.manager = manager;
	}

}
