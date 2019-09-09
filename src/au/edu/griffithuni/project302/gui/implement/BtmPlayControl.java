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

/**
 * Play control button
 * 
 * @author Firklaag_ins
 *
 */
public final class BtmPlayControl extends JButton implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;
	private boolean pause = false;
	private boolean playing = false;

	public BtmPlayControl(ApplicationManager manager) {
		this.manager = manager;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pause)
					/* state transfer: wait -> play */
					play();
				else
					pause();
			}
		});
	}

	/* play */
	public void play() {
		pause = true;
		setText(BTN_PAUSE);
		if(!playing) {
			playing = true;
			manager.iPlay();
			manager.animate.performance();
		}else 
			manager.animate.pauseTimer();
		
	}

	/* pause */
	public void pause() {
		pause = false;
		setText(BTN_PALY);
		manager.animate.pauseTimer();
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
		playing = false;
	}

	@Override
	public void iPlay() {}

}
