package au.edu.griffithuni.project302;

import java.util.HashMap;
import java.util.List;

import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager {
	
	private HashMap<String, List<PositionVo>> csvData = new HashMap<String, List<PositionVo>>();
	private String currentData;
	
	public void startLoading() {
		
	}
	
	private AnimatedManager() {
		
	}
	
	public static AnimatedManager getInstance() {
        return AnimatedManagerHolder.instance;
    }
	
	private static class AnimatedManagerHolder {
        private static final AnimatedManager instance = new AnimatedManager();
    }
	
}
