package au.edu.griffithuni.project302.tools;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.vo.PositionVo;

/**
 * Use swing worker to load the files, system call gc() after job done.
 * @author Firklaag_ins
 *
 */
public class FileLoadingWorker extends SwingWorker<Map<String, LinkedList<PositionVo>>, String> {

	private File[] files;
	private ApplicationManager manager;
	private Scanner scanner;
	
	public FileLoadingWorker(ApplicationManager manager, File... files) {
		this.manager = manager;
		this.files = files;
	}
	
	@Override
	protected Map<String, LinkedList<PositionVo>> doInBackground() throws Exception {
		HashMap<String, LinkedList<PositionVo>> trackList = new HashMap<String, LinkedList<PositionVo>>();
		
		for(File fd: files) {
			LinkedList<PositionVo> track = new LinkedList<PositionVo>();
			scanner = new Scanner(fd);
			scanner.nextLine();// jump title
			scanner.nextLine();// jump first line
			
			while(scanner.hasNextLine())
				track.add(voConvert(scanner.nextLine()));
			
			trackList.put(fd.getAbsolutePath(), track);
		}
		return trackList;
	}
	
	@Override
	protected void done() {
		try {
			manager.poise(get()); // load files done
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		/* state transfer: initial -> wait */
		manager.iWait(); // get ready to play
	}
	
	private PositionVo voConvert(String data) {
		String s[] = data.split(",");
		double time 		= Double.valueOf(s[0]);
		
		double headX 		= Double.valueOf(s[1]);
		double headY 		= Double.valueOf(s[2]);
		
		double leftHandX 	= Double.valueOf(s[7]);
		double leftHandY 	= Double.valueOf(s[8]);
		
		double rightHandX 	= Double.valueOf(s[13]);
		double rightHandY 	= Double.valueOf(s[14]);
		
		return new PositionVo(time, headX, headY, leftHandX, leftHandY, rightHandX, rightHandY);
	}
	
}
