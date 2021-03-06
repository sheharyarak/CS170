/*
 * Name: Sherry Khan
 * Assignment: Lab 2 - part 2: TempConvertWithValidate
 * Date: 3/13/19
 */
import javax.swing.JOptionPane;

/*
 * This is the TempCovertWithValidate class. The start function is basically the main function in this case. It uses get_option to get the
 * option the user selected. It then calls the corresponding conversion method with no parameters. the conversion methods, F_to_C() 
 * and C_to_F(), get valid input from the user using the get_valid_input() function and then calls the conversion method with one parameter
 * which converts the value the and displays it using JOptionPane. 
 */
public class TempCovertWithValidate {

	public void start() {
		int option;
		boolean carry_on = true; 
		while (carry_on)
		{
			option = this.get_option();
			if (option == 1)
			{
				C_to_F();
				carry_on = Validate.keep_going();
			}
			else if (option == 2)
			{
				F_to_C();
				carry_on = Validate.keep_going();
			}
			else
			{
				carry_on = false;
			}
		}
		System.exit(0);
	}

	private int get_option() {
		String op[] =
		{
			"Celsius to Farenheit",
			"Farenheit to Ceslius",
			"EXIT"
		};
		String selected;
		selected = (String)JOptionPane.showInputDialog(null, "Select a conversion", "TempConverterApp", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
		if (selected != null && selected.length() > 0)
		{
			if (selected.equals(op[0]))
			{
				return (1);
			}
			else if (selected.equals(op[1]))
			{
				return (2);
			}
			else
			{
				return (0);
			}
		}
		else
		{
			System.exit(0);
			return (0);
		}
	}
	private float C_to_F(float tmp)
	{
		return(((tmp * 9) / 5) + 32);
	}
	private float F_to_C(float tmp)
	{
		return(((tmp - 32) * 5) / 9);
	}
	private void C_to_F()
	{
		float input = Validate.get_valid_input();
		float nb = input;
		nb = C_to_F(nb);
		JOptionPane.showMessageDialog(null, input + "�C is equal to " + nb + "�F.");
	}
	private void F_to_C()
	{
		float input = Validate.get_valid_input();
		float nb = input;
		nb = F_to_C(nb);
		JOptionPane.showMessageDialog(null, input + "�F is equal to " + nb + "�C.");
	}
}
