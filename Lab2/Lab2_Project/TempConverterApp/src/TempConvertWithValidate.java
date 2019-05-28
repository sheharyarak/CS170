/*
 * Name: Sherry Khan
 * Assignment: Lab 2 - part 2: TempConvertWithValidate
 * Date: 3/13/19
 */
import javax.swing.JOptionPane;

public class TempConvertWithValidate {
	public static float C_to_F(float tmp)
	{
		return(((tmp * 9) / 5) + 32);
	}
	public static float F_to_C(float tmp)
	{
		return(((tmp - 32) * 5) / 9);
	}
	public static void C_to_F()
	{
		float input = Validate.get_valid_input();
		float nb = input;
		nb = C_to_F(nb);
		JOptionPane.showMessageDialog(null, input + "°C is equal to " + nb + "°F.");
	}
	public static void F_to_C()
	{
		float input = Validate.get_valid_input();
		float nb = input;
		nb = F_to_C(nb);
		JOptionPane.showMessageDialog(null, input + "°F is equal to " + nb + "°C.");
	}
}
