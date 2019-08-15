package au.edu.griffithuni.project302.gui;

public interface IComponent {
	
	boolean show = true;
	
	void iInitialize();
	
	void iWait();
	
	void iPlay();
	
	void iPause();
	
	void iFinished();
}
