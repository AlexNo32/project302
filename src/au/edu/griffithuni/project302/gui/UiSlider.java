package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import au.edu.griffithuni.project302.ApplicationManager;

public abstract class UiSlider extends JSlider implements ChangeListener, IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationManager manager;
	
	public UiSlider(ApplicationManager manager) {
		this.manager = manager;
		setBackground(COLOR_3);
		addChangeListener(this);
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
