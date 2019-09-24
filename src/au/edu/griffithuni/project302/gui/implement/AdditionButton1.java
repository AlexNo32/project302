package au.edu.griffithuni.project302.gui.implement;

import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_LOC_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_LOC_Y;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_SIZE_X;
import static au.edu.griffithuni.project302.tools.Constants.UPPER_ADDITION_BTN_1_SIZE_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader; //package required for handling python output
import java.io.InputStreamReader; //package required for handling python output


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
				/*
				The following section contains the mechnism used to trigger the python application
				*/
				String arguments = " python "+System.getProperty("user.dir") +"\\project302\\Python\\TraceMain.py "+"\""+manager.animate.currentFlieName+"\"";
				// an argument is being constructed in the following format
				// "python" "relative path to the python file based on the directory where java VM is launched" "CSV file path" 
				System.out.println(arguments);
				// print the constructed argument for trouble shooting
				try{
					/*
					command promt is to launched with java runtime
					in a russian nesting doll style to prevent cmd being close after execution
					*/
					Process process = Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c"+ arguments);
					// the previously constructed argument is used here
					// cmd -> another cmd -> python program with args
					BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
					// read whatever is printed on the python console
					String line = null;
					while ((line = in.readLine())!= null){
						System.out.println(line);
					}
					// print each line
					in.close();
					//close the input
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
