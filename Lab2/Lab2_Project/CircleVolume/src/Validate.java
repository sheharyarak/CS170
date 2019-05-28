import javax.swing.JOptionPane;

public class Validate
{	
	public static double get_valid_input(String input_type)
	{
		String input;
		double nb = 0;
		boolean valid = false;
		while(!valid)
		{
			try 
			{
				input = JOptionPane.showInputDialog("Enter the " + input_type + " : ");
				if(input == null)
				{
					System.exit(0);
				}
				else
				{
					nb = Float.parseFloat(input);
					if (nb <= 0)
					{
						throw new Exception("Input value less than or equal to 0.");
					}
					else
					{
						valid = true;
					}
				}
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
			}
		}
		return (nb);
	}
	
	public static boolean keep_going()
	{
		int reply = JOptionPane.showConfirmDialog(null, "Would you like to keep going?", "CircularVolumeApp", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
        	return (true);
        }
        else {
           return (false);
        }
	}
}

