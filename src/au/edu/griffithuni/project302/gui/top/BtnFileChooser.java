package au.edu.griffithuni.project302.gui.top;

import static au.edu.griffithuni.project302.tools.Constants.BTN_FILE;
import static au.edu.griffithuni.project302.tools.Constants.FILE_CHOOSER_FILTER;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_BTN_FILE_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiButton;
import au.edu.griffithuni.project302.tools.FileLoadingWorker;

public class BtnFileChooser extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileNameExtensionFilter filter = new FileNameExtensionFilter(null, FILE_CHOOSER_FILTER);
	
	public BtnFileChooser(ApplicationManager manager) {
		super(manager);
	}

	@Override
	public void iInitialize() {
		setText(BTN_FILE);
		setBounds(UPPER_BTN_FILE_LOC_X, UPPER_BTN_FILE_LOC_Y, UPPER_BTN_FILE_SIZE_X,UPPER_BTN_FILE_SIZE_Y);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showFileOpenDialog(filter);
			}
		});
		
		getManager().addComponentUpper(this);
		
	}

	public void showFileOpenDialog(FileNameExtensionFilter filter) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles(); 
            new FileLoadingWorker(getManager(), files).execute();
        }
	}
	
	@Override
	public void iPlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iWait() {
		// TODO Auto-generated method stub
		
	}
}
