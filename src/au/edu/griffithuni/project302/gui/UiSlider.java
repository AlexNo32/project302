package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.COLOR_3;

import javax.swing.JSlider;

import au.edu.griffithuni.project302.ApplicationManager;

/***
 * abstract object for slider
 * sub-object: ProgressBar, ScaleBar 
 * @author Firklaag_ins
 *
 */
public abstract class UiSlider extends JSlider implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationManager manager; //
	
	public UiSlider(ApplicationManager manager) {
		this.manager = manager;
		setBackground(COLOR_3);
		//default setting
		setMinimum(0);
		setMaximum(100);
		setValue(0);
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
