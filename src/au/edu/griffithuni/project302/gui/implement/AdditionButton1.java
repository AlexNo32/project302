package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;

import au.edu.griffithuni.project302.ApplicationManager;
import au.edu.griffithuni.project302.gui.IComponent;

public class AdditionButton1 extends JButton implements IComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationManager manager;

	public AdditionButton1(ApplicationManager manager) {
		this.manager = manager;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arguments = " python C:\\Users\\huhu8\\Documents\\Uni\\3821ICT\\Project\\project302\\Python\\TraceMain.py "+"\""+manager.animate.currentFlieName+"\"";
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
		setText("TRACE");
		setBounds(UPPER_ADDITION_BTN_1_LOC_X, UPPER_ADDITION_BTN_1_LOC_Y, UPPER_ADDITION_BTN_1_SIZE_X,
				UPPER_ADDITION_BTN_1_SIZE_Y);
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
