package au.edu.griffithuni.project302;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener{
	
	private ApplicationManager manager;
	
	private HashMap<String, List<PositionVo>> csvData = new HashMap<String, List<PositionVo>>();
	private String currentData;
	private Timer timer;
	
	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void recv(Map<String, List<PositionVo>> csv) {
		csvData.putAll(csv);
		manager.getFlieList().update(csv.keySet().toArray());
		// draw first frame
	}
	
	public List<PositionVo> getVo(String key) {
		return csvData.get(key);
	}

	/**
	 * @return the currentData
	 */
	public String getCurrentData() {
		return currentData;
	}

	/**
	 * @param currentData the currentData to set
	 */
	public void setCurrentData(String currentData) {
		this.currentData = currentData;
	}
	
}
