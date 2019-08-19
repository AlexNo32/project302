package au.edu.griffithuni.project302.tools;

import java.awt.Point;

public class Matrix2DTransfer {
	/**
	 * 
	 * @param p base point
	 * @param v vector of translation
	 */
	public static Point translation(Point p, Point v) {
		return matrixMultiple(translationMatrices(v), transportMatrix(p));
	}
	
	/**
	 * 
	 * @param p base point
	 * @param s scaling rate
	 */
	public static Point scaling(Point p, float s) {
		return 	matrixMultiple(scalingMatrices(s), transportMatrix(p));
	}

//	public static void rotate() {
//
//	}

	private static Point matrixMultiple(float[][] t, float[][] p) {
		float[][] r = new float[3][1];
		
		for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    r[i][j] += t[i][k] * p[k][j];
                }
            }
        }
//		return new Point(Math.round(r[0][0] + .5f), Math.round(r[1][0] + .5f));
		return new Point(Math.round(r[0][0]), Math.round(r[1][0]));
	}
	
	// transport matrix
	private static float[][] transportMatrix(Point p){
		return new float[][] {{p.x}, {p.y}, {1}};
	}
	
	// return Translation matrices
	private static float[][] translationMatrices(Point v){
		return new float[][] {{1, 0, v.x}, {0, 1, v.y}, {0, 0, 1}};
	}
	
	// return Scaling matrices
	private static float[][] scalingMatrices(float s){
		return new float[][] {{s, 0, 0}, {0 ,s, 0}, {0, 0, 1}};
	}
	
	
	
	/* ********debug************* */
	public static void main(String[] args) {
		Point t = new Point(2, -1);
		Point r = new Point(4, 3);
		Point i = new Point(-3, -2);
		
		Point v = new Point(-5, 2);
		float s = 2.5f;
		
		System.out.println(translation(t, v));
		System.out.println(translation(r, v));
		System.out.println(translation(i, v));
		
		System.out.println(scaling(t, s));
		System.out.println(scaling(r, s));
		System.out.println(scaling(i, s));
		
//		Point base = new Point(3, 5);
//		Point v = new Point(1, -1);
//		System.out.println(translation(base, v));
//		int r = 10;
//		System.out.println(scaling(base, r));
	}
	
}
