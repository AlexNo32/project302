package au.edu.griffithuni.project302.gui;

public interface IComponent {
	
	/* initial state */
	void iInitialize();
	
	/* FileLoadingWorker return */
	void iWait();
	
	/* BtmPlayControl click 'play' */
	void iPlay();	
}
