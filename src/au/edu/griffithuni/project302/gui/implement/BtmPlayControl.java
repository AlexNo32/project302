package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.BTN_PALY;
import static au.edu.griffithuni.project302.tools.Constants.BTN_PAUSE;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;


public class BtmPlayControl extends JButton implements IComponent  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isPlay = true;
	private ApplicationManager manager;
	
	public BtmPlayControl(ApplicationManager manager) {
		this.manager = manager;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPlay) {
					isPlay = false;
					setText(BTN_PAUSE);
					manager.play();
					manager.getAnimate().startTimer(1000);
				} else {
					isPlay = true;
					setText(BTN_PALY);
					manager.pause();
				}
			}
		});
	}

	@Override
	public void iInitialize() {
		setText(BTN_PALY);
		setBounds(LOWER_BTN_PLAY_LOC_X, LOWER_BTN_PLAY_LOC_Y, LOWER_BTN_PLAY_SIZE_X, LOWER_BTN_PLAY_SIZE_Y);
		
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

	@Override
	public void iPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void iFinished() {
		// TODO Auto-generated method stub

	}

}
