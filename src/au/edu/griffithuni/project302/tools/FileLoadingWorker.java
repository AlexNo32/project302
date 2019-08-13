package au.edu.griffithuni.project302.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import au.edu.griffithuni.project302.gui.top.CmbFlieList;
import au.edu.griffithuni.project302.vo.PositionVo;

public class FileLoadingWorker extends SwingWorker<Map<String, List<PositionVo>>, String> {

	private File[] files;
	private CmbFlieList cmb;
	private Scanner scanner;
	
	public FileLoadingWorker(CmbFlieList cmb, File... files) {
		this.cmb = cmb;
		this.files = files;
	}
	
	@Override
	protected Map<String, List<PositionVo>> doInBackground() throws Exception {
		HashMap<String, List<PositionVo>> trackList = new HashMap<String, List<PositionVo>>();
		
		for(File fd: files) {
			ArrayList<PositionVo> track = new ArrayList<PositionVo>();
			scanner = new Scanner(fd);
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				track.add(voConvert(scanner.nextLine()));
			}
			trackList.put(fd.getName(), track);
		}
		return trackList;
	}
	
	@Override
	protected void done() {
		try {
			cmb.setItems(get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private PositionVo voConvert(String data) {
		String s[] = data.split(",");
		double time = Double.valueOf(s[0]);
		
		double headX = Double.valueOf(s[1]);
		double headY = Double.valueOf(s[2]);
		
		double leftHandX = Double.valueOf(s[7]);
		double leftHandY = Double.valueOf(s[8]);
		
		double rightHandX = Double.valueOf(s[13]);
		double rightHandY = Double.valueOf(s[14]);
		
		return new PositionVo(time, headX, headY, leftHandX, leftHandY, rightHandX, rightHandY);
	}
	
}
