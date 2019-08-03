package au.edu.griffithuni.ui.bottom;

import au.edu.griffithuni.ui.UiButton;
import au.edu.griffithuni.ui.ViewerFrame;
import static au.edu.griffithuni.tools.Constants.*;

public class PlayControl extends UiButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PlayControl(ViewerFrame frame) {
		super(frame);
		setBounds(LOWER_BTN_PLAY_LOC_X, LOWER_BTN_PLAY_LOC_Y, LOWER_BTN_PLAY_SIZE_X, LOWER_BTN_PLAY_SIZE_Y);
		setText(BTN_PALY);
	}

}
