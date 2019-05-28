/*
 * Name: Sherry Khan
 * Assignment: Lab 2 - part 3: Circular Volume
 * Date: 3/13/19
 */
import javax.swing.JOptionPane;

/*
 * This is validation class. It uses the try and catch concept to ensure that the input is valid. If the input is invalid it uses 
 * JOptionPane to display error messages. If there are no errors it returns the floating point value after parsing it from string input.
 */

public class Validate
{	
	public static float get_valid_input()
	{
		String input;
		float nb = 0;
		boolean valid = false;
		while(!valid)
		{
			try 
			{
				input = JOptionPane.showInputDialog("Enter a temperature to convert: ");
				if(input == null)
				{
					System.exit(0);
				}
				else
				{
					nb = Float.parseFloat(input);
					if (nb > 200)
					{
						throw new Exception("Input value greater than 200");
					}
					else if (nb < -100)
					{
						throw new Exception("Input value less than -100");
					}
					else
					{
						valid = true;
					}
				}
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input. Please enter only numbers between -100 to 200.");
			}
		}
		return (nb);
	}
	
	public static boolean keep_going()
	{
		int reply = JOptionPane.showConfirmDialog(null, "Would you like to keep going?", "TempConvertApp", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
        	return (true);
        }
        else {
           return (false);
        }
	}
}

