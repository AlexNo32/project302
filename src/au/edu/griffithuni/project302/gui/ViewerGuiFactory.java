package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.*;

public class ViewerGuiFactory {

	public static ViewerFrame generator() {
		return new ViewerFrame(FRAME_TITLE);
	}

}
