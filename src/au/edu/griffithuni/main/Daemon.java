package au.edu.griffithuni.main;

import au.edu.griffithuni.project302.ApplicationManager;

/**
 * Main entry of the application
 * 
 * @author Firklaag_ins
 *
 */
public class Daemon {
	
	private ApplicationManager appManager;
	
	public Daemon() {
		//do nothing
	} 
	
	private void start() {
		appManager = ApplicationManager.getInstance();
		appManager.draw();
	}
	
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}

}
