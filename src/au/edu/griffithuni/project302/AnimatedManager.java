package au.edu.griffithuni.project302;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.gui.middle.UiCanvas;
import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener{
	
	private ApplicationManager manager;
	
	private HashMap<String, ArrayList<PositionVo>> csvData = new HashMap<String, ArrayList<PositionVo>>();
	private String currentData;
	private Timer timer;
	private float speedRate;
	private float folatRate;
	
	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
	}
	
	/**
     * Starts the animation
     */
    public void startTimer(int resolution) {
        if (timer != null) {
            timer.stop();
            timer.setDelay(resolution);
        } else {
            timer = new Timer(resolution, this);
        }
        timer.start();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<PositionVo> frame = getVoList(currentData);
		UiCanvas canvas = getManager().getCanvas();
		for(PositionVo p: frame) {
//			canvas.setJoneDoe();
//			canvas.repaint();
		}
		
	}
	
	public void recv(Map<String, ArrayList<PositionVo>> csv) {
		csvData.putAll(csv);
		manager.getFlieList().update(csv.keySet().toArray());
		// draw first frame
	}
	
	public ArrayList<PositionVo> getVoList(String key) {
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

	public float getSpeedRate() {
		return speedRate;
	}

	public void setSpeedRate(float speedRate) {
		this.speedRate = speedRate;
	}

	public float getFolatRate() {
		return folatRate;
	}

	public void setFolatRate(float folatRate) {
		this.folatRate = folatRate;
	}

	public ApplicationManager getManager() {
		return manager;
	}

	public void setManager(ApplicationManager manager) {
		this.manager = manager;
	}
	
}
