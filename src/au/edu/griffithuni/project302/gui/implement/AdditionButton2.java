package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_2_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class AdditionButton2 extends JButton implements IComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;

	public AdditionButton2(ApplicationManager manager) {
		this.manager = manager;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arguments = " python "+System.getProperty("user.dir") +"\\project302\\Python\\3DMain.py "+"\""+manager.animate.currentFlieName+"\"";
				System.out.println(arguments);
				try{
					Process process = Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c"+ arguments);
					BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line = null;
					while ((line = in.readLine())!= null){
						System.out.println(line);
					}
					in.close();
				}catch(Exception error){
					error.printStackTrace();
				}
			}
		});
	}

	@Override
	public void iInitialize() {
		setText("3D");
		setBounds(UPPER_ADDITION_BTN_2_LOC_X, UPPER_ADDITION_BTN_2_LOC_Y, UPPER_ADDITION_BTN_2_SIZE_X,
				UPPER_ADDITION_BTN_2_SIZE_Y);
		manager.addComponent(this);
		setEnabled(false);

	}

	@Override
	public void iWait() {
		setEnabled(true);
	}

	@Override
	public void iPlay() {
		// TODO Auto-generated method stub

	}

}
