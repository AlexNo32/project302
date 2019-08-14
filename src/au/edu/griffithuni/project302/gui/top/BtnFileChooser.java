package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.BTN_FILE;
import static au.edu.griffithuni.project302.tools.Constants.FILE_CHOOSER_FILTER;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.filechooser.FileNameExtensionFilter;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.UiButton;

public class BtnFileChooser extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileNameExtensionFilter filter = new FileNameExtensionFilter(null, FILE_CHOOSER_FILTER);
	
	public BtnFileChooser(ApplicationGuiManager manager) {
		super(manager);
	}

	@Override
	public void iInitialize() {
		setText(BTN_FILE);
		setBounds(UPPER_BTN_FILE_LOC_X, UPPER_BTN_FILE_LOC_Y, UPPER_BTN_FILE_SIZE_X,UPPER_BTN_FILE_SIZE_Y);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getManager().showFileOpenDialog(filter);
			}
		});
		
		getManager().addComponentUpper(this);
		
	}
}
