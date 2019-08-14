package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.FRAME_TITLE;

import au.edu.griffithuni.project302.gui.UiFrame;

public class ApplicationGuiFactory {

	public static UiFrame generator() {
		return new UiFrame(FRAME_TITLE);
	}
	
}
