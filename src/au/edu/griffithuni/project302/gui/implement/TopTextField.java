package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_TEXT_SIZE_Y;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

/**
 * input field
 * TODO file drop undone
 * @author Firklaag_ins
 *
 */
public class TopTextField extends JTextField implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationManager manager;
	
	/* Constructor */
	public TopTextField(ApplicationManager manager) {
		this.manager = manager;
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void iInitialize() {
		setBounds(UPPER_TEXT_LOC_X, UPPER_TEXT_LOC_Y,UPPER_TEXT_SIZE_X,UPPER_TEXT_SIZE_Y);

		manager.addComponent(this);
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

	@Override
	public void iWait() {
		// do nothing
		
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

}
