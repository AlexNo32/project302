package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.BTN_PALY;
import static au.edu.griffithuni.project302.tools.Constants.BTN_PAUSE;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.UiButton;

public class PlayControl extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isPlay  = true;
	
	public PlayControl(ApplicationManager manager) {
		super(manager);
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_BTN_PLAY_LOC_X, LOWER_BTN_PLAY_LOC_Y, LOWER_BTN_PLAY_SIZE_X, LOWER_BTN_PLAY_SIZE_Y);
		setText(BTN_PALY);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlay) {
					isPlay = false;
					setText(BTN_PAUSE);
					getManager().play();
				}else {
					isPlay = true;
					setText(BTN_PALY);
					getManager().pause();
				}
			}
		});
		
		getManager().addComponentBottom(this);
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
