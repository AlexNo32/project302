package au.edu.griffithuni.project302;

import java.util.HashMap;

public class ApplicationGuiManager {

	HashMap components = new HashMap();
	
	private ApplicationGuiManager() {
		
	}

	public void draw() {
		
	}
	
	public static ApplicationGuiManager getInstance() {
        return ApplicationManagerHolder.instance;
    }
	
	private static class ApplicationManagerHolder {
        private static final ApplicationGuiManager instance = new ApplicationGuiManager();
    }

}
