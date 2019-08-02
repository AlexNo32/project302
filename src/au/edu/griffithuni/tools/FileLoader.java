package au.edu.griffithuni.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import au.edu.griffithuni.vo.PositionVo;

public class FileLoader {

	public static ArrayList<PositionVo> fileLoader(String filePath) {
		
		ArrayList<PositionVo> voList = new ArrayList<PositionVo>();
		File fd = new File(filePath);
		Scanner scanner;
		try {
			scanner = new Scanner(fd);
			
			// skip first line
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				voList.add(msgSplit(scanner.nextLine()));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return voList;
	}
	
	private static PositionVo msgSplit(String msg) {
		String s[] = msg.split(",");
		double time = Double.valueOf(s[0]);
		
		double headX = Double.valueOf(s[1]);
		double headY = Double.valueOf(s[2]);
		
		double leftHandX = Double.valueOf(s[7]);
		double leftHandY = Double.valueOf(s[8]);
		
		double rightHandX = Double.valueOf(s[13]);
		double rightHandY = Double.valueOf(s[14]);
		
		return new PositionVo(time, headX, headY, leftHandX, leftHandY, rightHandX, rightHandY);
	}
	
	public static void main(String[] args) {
//		String relativelyPath = System.getProperty("user.dir"); 
//		System.out.println(relativelyPath);
		ArrayList<PositionVo> l = fileLoader("./demo.csv");
		
		for(PositionVo vo: l) {
			System.out.println(vo.toString());
			
		}

	}

}
