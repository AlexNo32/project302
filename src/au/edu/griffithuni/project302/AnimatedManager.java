package au.edu.griffithuni.project302;

import static au.edu.griffithuni.project302.tools.Constants.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.Timer;

import au.edu.griffithuni.project302.vo.PositionVo;

public class AnimatedManager implements ActionListener{
	
	private ApplicationManager manager;
	private Timer timer;
	private boolean pause = false;
	
	public HashMap<String, LinkedList<PositionVo>> csvDataMap = new HashMap<String, LinkedList<PositionVo>>();
	public String currentFlieName;
	public LinkedList<PositionVo> currentPerformed;
	public float speedRate;
	public float scaleRate;
	
	public AnimatedManager(ApplicationManager manager) {
		this.manager = manager;
	}
	
	public void recv(Map<String, LinkedList<PositionVo>> csv) {
		csvDataMap.putAll(csv);
	}
	
	public void setCurrentPerforme(String fdName) {
		this.currentFlieName = fdName;
		if(csvDataMap.size() == 0) 
			System.err.println("[DEBUG] csv data map is empty.");
		
		this.currentPerformed = csvDataMap.get(fdName);
		if(this.currentPerformed == null)
			System.err.println("[DEBUG] data cannot find. " + fdName);
		
		manager.canvas.setJoneDoe(currentPerformed.get(0));
		manager.canvas.repaint();
	}
	
	/* btn 'play' has been clicked */
	public void performance(){
		// fill the data
		startTimer(ANIMATE_FPS);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LinkedList<PositionVo> frame = csvDataMap.get(currentFlieName);
		
		if(frame.size() == 0)
			timer.stop();
		
		PositionVo p = frame.poll();

		manager.canvas.setJoneDoe(null);
		manager.canvas.repaint();
		
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
    
    /* pause */
    public void pauseTimer() {
		if (timer != null) {
			if (pause && !timer.isRunning()) {
				timer.restart();
				pause = false;
			} else {
				timer.stop();
				pause = true;
			}
		}
	}

	public void stopTimer() {
		if (timer != null)
			timer.stop();
		timer = null;
	}

}
