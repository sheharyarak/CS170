/*
 * Name: Sheharyar Alam Khan
 * Course: CS170
 * Lab: 01
 * Due: 2/27/2019 @ 11PM
 */
//importing JOPtionPane
import javax.swing.JOptionPane;
//Driver Class
public class temp_conv {
	//main function
	public static void main(String[] args) {
		//List options
		String[] option =  {
				"Farenheit to Celsius",
				"Celsius to Farenheit",
				"EXIT"
			};
		//selected option
		String selected;
		while (true) {
			//sets selected equal to the selected option from the drop down list.
			selected = (String) JOptionPane.showInputDialog(null, "Pick a conversion.", "Temperature Convertor", JOptionPane.QUESTION_MESSAGE, null, option, "Click here to select");
			//checks if selected is equal to the string at the 0th index in the option array.
			if (selected.equals(option[0]))
			{
				//parses the users input and gets a float value and sets it equal to the tmp.
				float tmp = Float.parseFloat((String) JOptionPane.showInputDialog("Enter a temperature to convert from degrees Farenheight to Celsius:"));
				//shows the converted result on the screen.
				JOptionPane.showMessageDialog(null, tmp + "°F is equal to " + converter.F_to_C(tmp) + "°C.");
			}
			//checks if selected is equal to the string at the 1st index in the option array.
			else if (selected.equals(option[1]))
			{
				// explained above.
				float tmp = Float.parseFloat((String) JOptionPane.showInputDialog("Enter a temperature to convert from degrees Celsius to Farenheight:"));
				//explained above.
				JOptionPane.showMessageDialog(null, tmp + "°C is equal to " + converter.C_to_F(tmp) + "°F.");
			}
			//checks if selected is equal to the string at the 2ndth index in the option array.
			else if (selected.equals(option[2]))
			{
				// exits the program
				System.exit(0);
			}
		}
	}
}
