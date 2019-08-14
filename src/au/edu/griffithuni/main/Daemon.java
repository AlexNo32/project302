package au.edu.griffithuni.main;

import au.edu.griffithuni.project302.ApplicationGuiManager;

/**
 * Main entry of the application
 * 
 * @author Firklaag_ins
 *
 */
public class Daemon {
	
	private ApplicationGuiManager appManager;
	
	public Daemon() {
		//do nothing
	} 
	
	private void start() {
		appManager = ApplicationGuiManager.getInstance();
		appManager.draw();
	}
	
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}

}
