package au.edu.griffithuni.project302.tools;

import java.awt.Point;

public class Matrix2DTransfer {

	private static Point matrixMultiple(int[][] p, int[][] v) {
		int[][] r = new int[3][1];
		
		for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    r[i][j] += p[i][k] * v[k][j];
                }
            }
        }
		
		return new Point(r[0][0], r[1][0]);
	}

	public static void translate(Point p, Point v) {
		
	}
	
	public static void scale(Point p, float s) {
		float scalingMatrix[][] = new float[][] {{s, 0, 0}, {0, s, 0}, {0, 0, 1}};
		
	}

	public static void rotate() {

	}

	public static void main(String[] args) {
		int p[][] = new int[][] {{1, 0, 5}, {0, 1, 2}, {0, 0, 1}};
		int v[][] = new int[][] {{4}, {10}, {1}};
		
//		System.out.println(translate(p, v));
	}
	
}
