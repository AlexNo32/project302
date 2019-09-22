package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class AdditionButton2 extends JButton implements IComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;

	public AdditionButton2(ApplicationManager manager) {
		this.manager = manager;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(manager.animate.currentFlieName);
			}
		});
	}

	@Override
	public void iInitialize() {
		setText("3D");
		setBounds(UPPER_ADDITION_BTN_2_LOC_X, UPPER_ADDITION_BTN_2_LOC_Y, UPPER_ADDITION_BTN_2_SIZE_X,
				UPPER_ADDITION_BTN_2_SIZE_Y);
		manager.addComponent(this);
		setEnabled(false);

	}

	@Override
	public void iWait() {
		setEnabled(true);
	}

	@Override
	public void iPlay() {
		// TODO Auto-generated method stub

	}

}
