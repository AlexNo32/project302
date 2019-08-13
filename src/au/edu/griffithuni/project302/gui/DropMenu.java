package au.edu.griffithuni.project302.gui;

import static au.edu.griffithuni.project302.tools.Constants.MENU_FILE;
import static au.edu.griffithuni.project302.tools.Constants.MENU_HELP;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_ABOUT;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_CLOSE;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_DEC;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_OPEN;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DropMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu file, help;
	
	private JMenuItem open, close, about;
	
	private JMenu decorate;
	
	public DropMenu(ViewerFrame frame) {
		file = new JMenu(MENU_FILE);
		help = new JMenu(MENU_HELP);
		file.setMnemonic(KeyEvent.VK_F);
		help.setMnemonic(KeyEvent.VK_H);
		
		open = new JMenuItem(MENU_ITEM_OPEN);
		close = new JMenuItem(MENU_ITEM_CLOSE);
		about = new JMenuItem(MENU_ITEM_ABOUT);
		
		decorate = new JMenu(MENU_ITEM_DEC);
		decorate.setEnabled(false);
		
		file.add(open);
		file.addSeparator();
		file.add(close);
		help.add(about);
		
		add(file);
		add(decorate);
		add(help);
		
		open.setAction(act_open);
	}
	
	//***********************  Actions **************************
	
	Action act_open = new AbstractAction(MENU_ITEM_OPEN) {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5398334147642421864L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Open");
			
		}
		
	};
	
	

}
