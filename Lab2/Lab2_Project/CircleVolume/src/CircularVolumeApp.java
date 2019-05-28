import javax.swing.JOptionPane;

/* Name: Sheharyar Khan
 * Assignment: Lab 2 - part 3: Circular Volume
 * Date: 3/13/19
 * Description:
 * This is the driver class. Here, I have used the while loop to that is true until the user decides to exit the program. We have an array 
 * of the different options for the program. When the user selects an element of the array from the dropdown bar of JOptionPane, it will 
 * prompt the program to perform different overloaded functions and display the correct output in JOptionPane. Then, it will call the 
 * keep_going() function from the validate class that will ask the user if they would like to continue with the program or not. When the 
 * selects exit, the program will exit. 
 */
public class CircularVolumeApp {

	public static void main(String[] args) {
		String op[] =
			{
					"Sphere",
					"Cylinder",
					"Ellipse",
					"Exit"
			};
		String selected;
		while (true)
		{
			selected = (String)JOptionPane.showInputDialog(null, "Select a conversion", "TempConverterApp", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
			if (selected != null && selected.length() > 0)
			{
				if (selected.equals(op[0]))
				{
					CircularVolume.getSphere();
					if(!Validate.keep_going())
					{
						break;
					}
				}
				else if (selected.equals(op[1]))
				{
					CircularVolume.getCylinder();
					if(!Validate.keep_going())
					{
						break;
					}
				}
				else if (selected.equals(op[2]))
				{
					CircularVolume.getEllipse();
					if(!Validate.keep_going())
					{
						break;
					}
					break;
				}
				else {
					break;
				}
			}
			else
			{
				System.exit(0);
			}
			
		}
		return;
	}

}
