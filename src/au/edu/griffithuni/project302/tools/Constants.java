package au.edu.griffithuni.project302.tools;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class Constants {
	// ******************* Main frame *********************
	public static final String FRAME_TITLE 	= "Griffithuni 2D Viewer";
	public static final String PANEL_TITLE 	= "Screen";
	public static final int FRAME_WIDTH 	= 1280;
	public static final int FRANE_HEIGHT 	= 740;//960
	public static final String FRAME_FONT 	= "Georgia";
//	public static final String THEME = UIManager.getCrossPlatformLookAndFeelClassName();
	public static final String THEME = UIManager.getSystemLookAndFeelClassName();
//	public static final String THEME = "javax.swing.plaf.metal.MetalLookAndFeel";

	public static final int ANIMATE_FPS = 200;
	
	// ******************* Upper panel *************************
	// ********* Combobox ********
	public static final String COMBOBOX_DEFAULT 	= "------- EXISTING FILE LIST -------";
	public static final int UPPER_COMBOX_LOC_X 		= 10;
	public static final int UPPER_COMBOX_LOC_Y 		= 10;

	public static final int UPPER_COMBOX_SIZE_X 	= 200; // 250
	public static final int UPPER_COMBOX_SIZE_Y 	= 25;
	
	// ***************** Addition 1 *************************
	public static final int UPPER_ADDITION_BTN_1_LOC_X = 215;
	public static final int UPPER_ADDITION_BTN_1_LOC_Y = 10;
	
	public static final int UPPER_ADDITION_BTN_1_SIZE_X = 80;
	public static final int UPPER_ADDITION_BTN_1_SIZE_Y = 25;
	
	// ***************** addition 2 *************************
	
	public static final int UPPER_ADDITION_BTN_2_LOC_X = 300;
	public static final int UPPER_ADDITION_BTN_2_LOC_Y = 10;
	
	public static final int UPPER_ADDITION_BTN_2_SIZE_X = 80;
	public static final int UPPER_ADDITION_BTN_2_SIZE_Y = 25;
	
	// ********* Text field ********
	public static final int UPPER_TEXT_LOC_X 		= 385; // 270
	public static final int UPPER_TEXT_LOC_Y 		= 10;

	public static final int UPPER_TEXT_SIZE_X 		= 765;// 880
	public static final int UPPER_TEXT_SIZE_Y 		= 25;
	// ********* File Button *******
	public static final int UPPER_BTN_FILE_LOC_X 	= 1160;
	public static final int UPPER_BTN_FILE_LOC_Y 	= 10;

	public static final int UPPER_BTN_FILE_SIZE_X 	= 110;
	public static final int UPPER_BTN_FILE_SIZE_Y 	= 25;
	
	public static final String[] FILE_CHOOSER_FILTER 	= { "csv" };
	public static final String BTN_FILE 	= "File";

	// ******************* Middle panel ************************
	// ******************* Canvas ********************
	public static final int SCREEN_POS_LOC_X 	= 10;
	public static final int SCREEN_POS_LOC_Y 	= 45;
	public static final int SCREEN_PANEL_WIDTH 	= 1260;
	public static final int SCREEN_PANEL_HEIGHT = 650;// 870
	
	public static final Color SCREEN_BACKGROUND = new Color(176,196,222); 
	public static final int GRID_GAP 			= 50;
	public static final Font MARK_FONT = new Font("Arial", Font.PLAIN, 13);
	
	// ******************* Canvsa DashBoard***************
	public static final int DASHBOARD_POS_LOC_X 	= 945;
	public static final int DASHBOARD_POS_LOC_Y 	= 17;
	public static final int DASHBOARD_WIDTH 		= 260;
	public static final int DASHBOARD_HEIGHT 		= 75;

	// ******************* Lower panel *************************
	// ********* play Button ********
	public static final int LOWER_BTN_PLAY_LOC_X 	= 10;
	public static final int LOWER_BTN_PLAY_LOC_Y 	= 705;//925
	
	public static final int LOWER_BTN_PLAY_SIZE_X 	= 110;
	public static final int LOWER_BTN_PLAY_SIZE_Y 	= 25;
	
	public static final String BTN_PALY 	= "Play";
	public static final String BTN_PAUSE 	= "Pause";

	// ******** combobox speed list *********
	public static final int LOWER_CMB_SPEED_LOC_X 	= 130;
	public static final int LOWER_CMB_SPEED_LOC_Y 	= 705;
	
	public static final int LOWER_CMB_SPEED_SIZE_X 	= 110;
	public static final int LOWER_CMB_SPEED_SIZE_Y 	= 25;
	
	public static final String ITEM_1 = "x 0.5";
	public static final String ITEM_2 = "x 0.8";
	public static final String ITEM_3 = "x 1.0";
	public static final String ITEM_4 = "x 2.0";
	public static final String ITEM_5 = "x 3.0";
	public static final String[] PROCE_BAR_CONTENYS = { ITEM_1, ITEM_2, ITEM_3, ITEM_4, ITEM_5};

	// ******* process bar **********
	public static final int LOWER_PROC_LOC_X 	= 250;
	public static final int LOWER_PROC_LOC_Y 	= 705;
	
	public static final int LOWER_PROC_SIZE_X 	= 720;
	public static final int LOWER_PROC_SIZE_Y 	= 25;

	// ****** label ***********
	public static final int LOWER_LABEL_LOC_X 	= 980;
	public static final int LOWER_LABEL_LOC_Y 	= 705;
	
	public static final int LOWER_LABEL_SIZE_X 	= 50;
	public static final int LOWER_LABEL_SIZE_Y 	= 25;

	// ***** scale bar *********
	public static final int LOWER_SCALE_BAR_LOC_X 	= 1030;
	public static final int LOWER_SCALE_BAR_LOC_Y 	= 705;
	
	public static final int LOWER_SCALE_BAR_SIZE_X 	= 240;
	public static final int LOWER_SCALE_BAR_SIZE_Y 	= 25;
	
	public static final String SCALE_LABEL 	= "Scale: ";
	
	// ******************* MEnu ***************************
	public static final String MENU_FILE 		= "File";
	public static final String MENU_HELP 		= "help";
	public static final String MENU_ITEM_OPEN 	= "Open";
	public static final String MENU_ITEM_CLOSE 	= "Close";
	public static final String MENU_ITEM_ABOUT 	= "About";
	public static final String MENU_ITEM_DEC 	= "|";

	// ****************** Jone Doe *************************
	public static final float FONT_SIZE 	= 4.6f;
	public static final int HEAD_DIAMETER 	= 30;
	public static final int HAND_DIAMETER 	= 24;
	public static final Color HEAD_COLOR 	= new Color(255, 0, 0); // red
	public static final Color HAND_COLOR 	= new Color(0, 0, 255); // blue
	public static final Color LINE_COLOR 	= Color.BLACK;
	public static final int INITIAL_LOCATION_X = 50; // initial loc x
	public static final int INITIAL_LOCATION_Y = (int)(SCREEN_PANEL_HEIGHT / 2);// initial loc y
	
	
	// ****************** Data represting *******************
	public static final int PRECISION 	= 100; // 1000 keep three digits behind point, 100 keep two
}
