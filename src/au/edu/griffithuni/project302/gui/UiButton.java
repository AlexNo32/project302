package au.edu.griffithuni.project302.gui;

import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationGuiManager;

public abstract class UiButton extends JButton implements IComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationGuiManager manager;
	
	public UiButton(ApplicationGuiManager manager) {
		this.manager = manager;
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
