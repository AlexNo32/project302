package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import au.edu.griffithuni.project302.ApplicationGuiManager;

public abstract class UiSlider extends JSlider implements ChangeListener, IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationGuiManager manager;
	
	public UiSlider(ApplicationGuiManager manager) {
		this.manager = manager;
		setBackground(COLOR_3);
		addChangeListener(this);
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
