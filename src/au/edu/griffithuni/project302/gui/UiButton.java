package au.edu.griffithuni.project302.gui;

import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationManager;

public abstract class UiButton extends JButton implements IComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	
	public UiButton(ApplicationManager manager) {
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

}
