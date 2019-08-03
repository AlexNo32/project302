package au.edu.griffithuni.ui.bottom;

import au.edu.griffithuni.ui.UiButton;
import au.edu.griffithuni.ui.ViewerFrame;
import static au.edu.griffithuni.tools.Constants.*;

import java.awt.event.ActionEvent;

public class PlayControl extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isPlay  = true;
	
	public PlayControl(ViewerFrame frame) {
		super(frame);
		setBounds(LOWER_BTN_PLAY_LOC_X, LOWER_BTN_PLAY_LOC_Y, LOWER_BTN_PLAY_SIZE_X, LOWER_BTN_PLAY_SIZE_Y);
		setText(BTN_PALY);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(isPlay) {
			isPlay = false;
			setText(BTN_PAUSE);
//			repaint();
		}else {
			isPlay = true;
			setText(BTN_PALY);
//			repaint();
		}
		
	}

}
