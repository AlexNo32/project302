package au.edu.griffithuni.project302.tools;

import java.awt.Color;

public class Constants {
	//******************* Main frame *********************
	public static final String FRAME_TITLE = "2D Viewer";
	public static final String PANEL_TITLE = "Screen";
	public static final int FRAME_WIDTH  = 1280;
	public static final int FRANE_HEIGHT = 960; 
	//******************* panel ********************
	public static final int MARGIN 		= 5;
	public static final int CONTROL_PANEL_HEIGHT 	= 40;
	public static final int SCREEN_POS_HEIGHT 		= 50;
	public static final int SCREEN_PANEL_WIDTH 		= 1255;
	public static final int SCREEN_PANEL_HEIGHT 	= 800;
	
	//******************* Upper panel *************************
	//********* Combobox ********
	public static final String COMBOBOX_DEFAULT = "---------- EXISTING FILE LIST ----------";
	public static final int UPPER_COMBOX_LOC_X 	= 10;
	public static final int UPPER_COMBOX_LOC_Y 	= 10;
	public static final int UPPER_COMBOX_SIZE_X = 250;
	public static final int UPPER_COMBOX_SIZE_Y = 25;
	//********* Text field ********
	public static final int UPPER_TEXT_LOC_X 	= 340;
	public static final int UPPER_TEXT_LOC_Y 	= 10;
	public static final int UPPER_TEXT_SIZE_X 	= 800;
	public static final int UPPER_TEXT_SIZE_Y 	= 25;
	//********* File Button *******
	public static final int UPPER_BTN_FILE_LOC_X 	= 1145;
	public static final int UPPER_BTN_FILE_LOC_Y 	= 5;
	public static final int UPPER_BTN_FILE_SIZE_X 	= 100;
	public static final int UPPER_BTN_FILE_SIZE_Y 	= 30;
	
	//******************* Middle panel ************************
	
	//******************* Lower panel *************************
	//********* play Button ********
	public static final int LOWER_BTN_PLAY_LOC_X 	= 10;
	public static final int LOWER_BTN_PLAY_LOC_Y 	= 10;
	public static final int LOWER_BTN_PLAY_SIZE_X 	= 100;
	public static final int LOWER_BTN_PLAY_SIZE_Y 	= 25;
	
	//******** combobox speed list *********
	public static final int LOWER_CMB_SPEED_LOC_X 	= 120;
	public static final int LOWER_CMB_SPEED_LOC_Y 	= 10;
	public static final int LOWER_CMB_SPEED_SIZE_X 	= 100;
	public static final int LOWER_CMB_SPEED_SIZE_Y 	= 25;
	
	//******* process bar **********
	public static final int LOWER_PROC_LOC_X 	= 230;
	public static final int LOWER_PROC_LOC_Y 	= 10;
	public static final int LOWER_PROC_SIZE_X 	= 700;
	public static final int LOWER_PROC_SIZE_Y 	= 25;
	
	//****** label ***********
	public static final int LOWER_LABEL_LOC_X 	= 960;
	public static final int LOWER_LABEL_LOC_Y 	= 10;
	public static final int LOWER_LABEL_SIZE_X 	= 50;
	public static final int LOWER_LABEL_SIZE_Y 	= 25;
	
	//***** scale bar *********
	public static final int LOWER_SCALE_BAR_LOC_X 	= 1000;
	public static final int LOWER_SCALE_BAR_LOC_Y 	= 10;
	public static final int LOWER_SCALE_BAR_SIZE_X 	= 250;
	public static final int LOWER_SCALE_BAR_SIZE_Y 	= 25;
	
	//******************* MEnu ***************************
	public static final String MENU_FILE 		= "File";
	public static final String MENU_HELP 		= "help";
	public static final String MENU_ITEM_OPEN 	= "Open";
	public static final String MENU_ITEM_CLOSE 	= "Close";
	public static final String MENU_ITEM_ABOUT 	= "About";
	public static final String MENU_ITEM_DEC 	= "|";
	
	//******************* Button *************************
	public static final String BTN_PALY 	= "Play";
	public static final String BTN_PAUSE 	= "Pause";
	public static final String BTN_FILE 	= "File";
	public static final String SCALE_LABEL 	= "Scale: ";
	
	
	
	//******************* File chooser fliter *******************
	public static final String[] FILE_CHOOSER_FILTER = {"csv"};
	//******************* process speed contents ************
	public static final String[] PROCE_BAR_CONTENYS = {" x 0.5", " x 0.8", " x 1.0", " x 1.5"};
	
	//******************* Theme **************************
	public static final Color COLOR_0 = new Color(228,231,234);
	public static final Color COLOR_1 = new Color(186,200,206);
	public static final Color COLOR_2 = new Color(235,243,246);
	public static final Color COLOR_3 = new Color(179,213,214);
//	public static final Color COLOR_4 = new Color(#A88B4C);
//	public static final Color COLOR_5 = new Color(#A88B4C);
	//******************* *********************************
	public static final int POS_TOP 	= 1;
	public static final int POS_MIDDLE 	= 2;
	public static final int POS_BOTTOM 	= 3;
	
	//****************** Jone Doe *************************
	public static final float FONT_SIZE  = 6.6f;
	public static final int DIAMETER	 = 30;
	public static final Color HEAD_COLOR = new Color(255, 0, 0); // red
	public static final Color HAND_COLOR = new Color(0, 0, 255); // blue
	public static final Color LINE_COLOR = Color.BLACK;
	
	
}
