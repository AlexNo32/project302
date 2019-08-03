package au.edu.griffithuni.ui;

import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public abstract class UiCombobox extends JComboBox<String> implements ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewerFrame frame;
	
	public UiCombobox(ViewerFrame frame) {
		this.frame = frame;
		addActionListener(this);
	}
	
	public UiCombobox(ViewerFrame frame, String[] items) {
		super(items);
		this.frame = frame;
		addActionListener(this);
	}

	public ViewerFrame getFrame() {
		return frame;
	}

}
