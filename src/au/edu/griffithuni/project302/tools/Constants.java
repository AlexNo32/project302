package au.edu.griffithuni.project302.tools;

import java.awt.Color;

public class Constants {
	// ******************* Main frame *********************
	public static final String FRAME_TITLE 	= "Griffithuni 2D Viewer";
	public static final String PANEL_TITLE 	= "Screen";
	public static final int FRAME_WIDTH 	= 1280;
	public static final int FRANE_HEIGHT 	= 960;
	public static final String FRAME_FONT 	= "Georgia";
//	public static final String THEME = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//	public static final String THEME = "com.sun.java.swing.plaf.motif.MotifLookAndFee";
	public static final String THEME = "javax.swing.plaf.metal.MetalLookAndFeel";


	// ******************* Upper panel *************************
	// ********* Combobox ********
	public static final String COMBOBOX_DEFAULT 	= "---------- EXISTING FILE LIST ----------";
	public static final int UPPER_COMBOX_LOC_X 		= 10;
	public static final int UPPER_COMBOX_LOC_Y 		= 10;

	public static final int UPPER_COMBOX_SIZE_X 	= 250;
	public static final int UPPER_COMBOX_SIZE_Y 	= 25;
	// ********* Text field ********
	public static final int UPPER_TEXT_LOC_X 		= 270;
	public static final int UPPER_TEXT_LOC_Y 		= 10;

	public static final int UPPER_TEXT_SIZE_X 		= 880;
	public static final int UPPER_TEXT_SIZE_Y 		= 25;
	// ********* File Button *******
	public static final int UPPER_BTN_FILE_LOC_X 	= 1160;
	public static final int UPPER_BTN_FILE_LOC_Y 	= 10;

	public static final int UPPER_BTN_FILE_SIZE_X 	= 110;
	public static final int UPPER_BTN_FILE_SIZE_Y 	= 25;

	// ******************* Middle panel ************************
	// ******************* Canvas ********************
	public static final int SCREEN_POS_LOC_X 	= 10;
	public static final int SCREEN_POS_LOC_Y 	= 45;
	public static final int SCREEN_PANEL_WIDTH 	= 1260;
	public static final int SCREEN_PANEL_HEIGHT = 870;
	
	public static final Color SCREEN_BACKGROUND = new Color(0, 255, 127); 
	public static final int GRID_GAP 			= 45;

	// ******************* Lower panel *************************
	// ********* play Button ********
	public static final int LOWER_BTN_PLAY_LOC_X 	= 10;
	public static final int LOWER_BTN_PLAY_LOC_Y 	= 925;
	
	public static final int LOWER_BTN_PLAY_SIZE_X 	= 110;
	public static final int LOWER_BTN_PLAY_SIZE_Y 	= 25;

	// ******** combobox speed list *********
	public static final int LOWER_CMB_SPEED_LOC_X 	= 130;
	public static final int LOWER_CMB_SPEED_LOC_Y 	= 925;
	
	public static final int LOWER_CMB_SPEED_SIZE_X 	= 110;
	public static final int LOWER_CMB_SPEED_SIZE_Y 	= 25;

	// ******* process bar **********
	public static final int LOWER_PROC_LOC_X 	= 250;
	public static final int LOWER_PROC_LOC_Y 	= 925;
	
	public static final int LOWER_PROC_SIZE_X 	= 720;
	public static final int LOWER_PROC_SIZE_Y 	= 25;

	// ****** label ***********
	public static final int LOWER_LABEL_LOC_X 	= 980;
	public static final int LOWER_LABEL_LOC_Y 	= 925;
	
	public static final int LOWER_LABEL_SIZE_X 	= 50;
	public static final int LOWER_LABEL_SIZE_Y 	= 25;

	// ***** scale bar *********
	public static final int LOWER_SCALE_BAR_LOC_X 	= 1030;
	public static final int LOWER_SCALE_BAR_LOC_Y 	= 925;
	
	public static final int LOWER_SCALE_BAR_SIZE_X 	= 240;
	public static final int LOWER_SCALE_BAR_SIZE_Y 	= 25;

	// ******************* MEnu ***************************
	public static final String MENU_FILE 		= "File";
	public static final String MENU_HELP 		= "help";
	public static final String MENU_ITEM_OPEN 	= "Open";
	public static final String MENU_ITEM_CLOSE 	= "Close";
	public static final String MENU_ITEM_ABOUT 	= "About";
	public static final String MENU_ITEM_DEC 	= "|";

	// ******************* Button txt*************************
	public static final String BTN_PALY 	= "Play";
	public static final String BTN_PAUSE 	= "Pause";
	public static final String BTN_FILE 	= "File";
	public static final String SCALE_LABEL 	= "Scale: ";

	// ******************* File chooser fliter *******************
	public static final String[] FILE_CHOOSER_FILTER 	= { "csv" };
	// ******************* process speed contents ************
	public static final String[] PROCE_BAR_CONTENYS 	= { " x 1.0", " x 2.0", " x 3.0", " x 4.0" };

	// ****************** Jone Doe *************************
	public static final float FONT_SIZE 	= 6.6f;
	public static final int DIAMETER 		= 30;
	public static final Color HEAD_COLOR 	= new Color(255, 0, 0); // red
	public static final Color HAND_COLOR 	= new Color(0, 0, 255); // blue
	public static final Color LINE_COLOR 	= Color.BLACK;

}
