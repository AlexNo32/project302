package au.edu.griffithuni.ui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static au.edu.griffithuni.tools.Constants.*;

public class UiFileChooser extends JFileChooser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileNameExtensionFilter filter = new FileNameExtensionFilter(null, FILE_CHOOSER_FILTER);
	
	public UiFileChooser() {
//		setBounds(800, 10, 150, 25);       
		setFileFilter(filter);

	}

}
