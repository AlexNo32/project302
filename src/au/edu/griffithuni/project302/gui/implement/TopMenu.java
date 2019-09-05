package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.MENU_FILE;
import static au.edu.griffithuni.project302.tools.Constants.MENU_HELP;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_ABOUT;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_CLOSE;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_DEC;
import static au.edu.griffithuni.project302.tools.Constants.MENU_ITEM_OPEN;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import au.edu.griffithuni.project302.ApplicationManager;

/**
 * Top menu
 *  - need fill the funcs
 * @author Firklaag_ins
 *
 */
public final class TopMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu file, help;
	private JMenuItem open, close, about;
	private JMenu decorate;
	private ApplicationManager manager;

	public TopMenu(ApplicationManager manager) {
		this.manager = manager;
		this.file 	= new JMenu(MENU_FILE);
		this.help 	= new JMenu(MENU_HELP);
		this.file.setMnemonic(KeyEvent.VK_F);
		this.help.setMnemonic(KeyEvent.VK_H);

		this.open 	= new JMenuItem(MENU_ITEM_OPEN);
		this.close 	= new JMenuItem(MENU_ITEM_CLOSE);
		this.about 	= new JMenuItem(MENU_ITEM_ABOUT);

		decorate 	= new JMenu(MENU_ITEM_DEC);
		decorate.setEnabled(false);

		file.add(open);
		file.addSeparator();
		file.add(close);
		help.add(about);

		add(file);
		add(decorate);
		add(help);

		open.setAction(new AbstractAction(MENU_ITEM_OPEN) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5398334147642421864L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}

		});
	}
}
