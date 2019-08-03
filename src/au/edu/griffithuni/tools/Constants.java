package au.edu.griffithuni.tools;

import java.awt.Color;

public class Constants {
	//******************* Main frame *********************
	public static final String FRAME_TITLE = "2D Viewer";
	public static final String PANEL_TITLE = "Screen";
	public static final int FRAME_WIDTH = 1280;
	public static final int FRANE_HEIGHT = 960; 
	
	public static final int MARGIN = 5;
	public static final int BORDER_FONT= 3;
	
	public static final int PANEL_WIDTH = FRAME_WIDTH - 5 * MARGIN;
	public static final int CONTROL_PANEL_HEIGHT = 40;
	public static final int SCREEN_PANEL_HEIGHT = 800;
	
	//******************* Upper panel *************************
	//********* Combobox ********
	public static final String COMBOBOX_DEFAULT = "  ---- EXISTING FILE LIST ----";
	public static final int UPPER_COMBOX_LOC_X = 10;
	public static final int UPPER_COMBOX_LOC_Y = 10;
	public static final int UPPER_COMBOX_SIZE_X = 180;
	public static final int UPPER_COMBOX_SIZE_Y = 25;
	//********* Text field ********
	public static final int UPPER_TEXT_LOC_X = 340;
	public static final int UPPER_TEXT_LOC_Y = 10;
	public static final int UPPER_TEXT_SIZE_X = 800;
	public static final int UPPER_TEXT_SIZE_Y = 25;
	//********* File Button *******
	public static final int UPPER_BTN_FILE_LOC_X = 1145;
	public static final int UPPER_BTN_FILE_LOC_Y = 5;
	public static final int UPPER_BTN_FILE_SIZE_X = 100;
	public static final int UPPER_BTN_FILE_SIZE_Y = 30;
	
	//******************* Middle panel ************************
	
	//******************* Lower panel *************************
	public static final int LOWER_BTN_PLAY_LOC_X = 10;
	public static final int LOWER_BTN_PLAY_LOC_Y = 10;
	public static final int LOWER_BTN_PLAY_SIZE_X = 100;
	public static final int LOWER_BTN_PLAY_SIZE_Y = 25;
	
	public static final int LOWER_CMB_SPEED_LOC_X = 120;
	public static final int LOWER_CMB_SPEED_LOC_Y = 10;
	public static final int LOWER_CMB_SPEED_SIZE_X = 100;
	public static final int LOWER_CMB_SPEED_SIZE_Y = 25;
	
	public static final int LOWER_PROC_LOC_X = 230;
	public static final int LOWER_PROC_LOC_Y = 10;
	public static final int LOWER_PROC_SIZE_X = 700;
	public static final int LOWER_PROC_SIZE_Y = 25;
	
	public static final int LOWER_LABEL_LOC_X = 960;
	public static final int LOWER_LABEL_LOC_Y = 10;
	public static final int LOWER_LABEL_SIZE_X = 50;
	public static final int LOWER_LABEL_SIZE_Y = 25;
	
	public static final int LOWER_SCALE_BAR_LOC_X = 1000;
	public static final int LOWER_SCALE_BAR_LOC_Y = 10;
	public static final int LOWER_SCALE_BAR_SIZE_X = 250;
	public static final int LOWER_SCALE_BAR_SIZE_Y = 25;
	
	//******************* MEnu ***************************
	public static final String MENU_FILE = "File";
	public static final String MENU_HELP = "help";
	public static final String MENU_ITEM_OPEN = "Open";
	public static final String MENU_ITEM_CLOSE = "Close";
	public static final String MENU_ITEM_ABOUT = "About";
	public static final String MENU_ITEM_DEC = "|";
	
	//******************* Button *************************
	public static final String BTN_PALY = "Play";
	public static final String BTN_PAUSE = "Pause";
	public static final String BTN_FILE = "File";
	public static final String SCALE_LABEL = "Scale: ";
	
	
	
	//******************* File chooser *******************
	public static final String[] FILE_CHOOSER_FILTER = {"csv"};
	
	//******************* Color **************************
	public static final Color BORDER_COLOR = Color.ORANGE;
	
	
}
