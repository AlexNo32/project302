package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.ANIMATE_FPS;
import static au.edu.griffithuni.project302.tools.Constants.ITEM_1;
import static au.edu.griffithuni.project302.tools.Constants.ITEM_2;
import static au.edu.griffithuni.project302.tools.Constants.ITEM_3;
import static au.edu.griffithuni.project302.tools.Constants.ITEM_4;
import static au.edu.griffithuni.project302.tools.Constants.ITEM_5;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.LOWER_CMB_SPEED_SIZE_Y;
import static au.edu.griffithuni.project302.tools.Constants.PROCE_BAR_CONTENYS;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

/***
 * play speed control
 * 
 * @author Firklaag_ins
 *
 */
public final class BtmSpeedCtrl extends JComboBox<String> implements IComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationManager manager;
	private int currentRate;

	/* Constructor */
	public BtmSpeedCtrl(ApplicationManager manager) {
		this.manager = manager;
	}

	@Override
	public void iInitialize() {
		setBounds(LOWER_CMB_SPEED_LOC_X, LOWER_CMB_SPEED_LOC_Y, LOWER_CMB_SPEED_SIZE_X, LOWER_CMB_SPEED_SIZE_Y);
		for (String s : PROCE_BAR_CONTENYS)
			addItem(s);

		setSelectedIndex(2);

		manager.addComponent(this);

		addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					switch ((String) e.getItem()) {
					case ITEM_1:
						currentRate = 300;
						break;
					case ITEM_2:
						currentRate = 250;
						break;
					case ITEM_3:
						currentRate = ANIMATE_FPS;
						break;
					case ITEM_4:
						currentRate = 100;
						break;
					case ITEM_5:
						currentRate = 50;
						break;
					default:
						currentRate = ANIMATE_FPS;
						break;
					}
					
					manager.animate.setSpeedRate(currentRate);
				}
			}

		});

		setEnabled(false);
	}

	@Override
	public void iWait() {
		setEnabled(true);
	}

	@Override
	public void iPlay() {
	}

}
