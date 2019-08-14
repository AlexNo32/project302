package au.edu.griffithuni.project302.gui.bottom;

import static au.edu.griffithuni.project302.tools.Constants.BTN_PALY;
import static au.edu.griffithuni.project302.tools.Constants.BTN_PAUSE;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_BTN_PLAY_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import au.edu.griffithuni.project302.ApplicationGuiManager;
import au.edu.griffithuni.project302.gui.UiButton;

public class PlayControl extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isPlay  = true;
	
	public PlayControl(ApplicationGuiManager manager) {
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
//					repaint();
				}else {
					isPlay = true;
					setText(BTN_PALY);
//					repaint();
				}
			}
		});
		
		getManager().addComponentBottom(this);
	}

}
