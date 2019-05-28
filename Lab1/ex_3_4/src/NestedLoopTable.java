/*
 * Name: Sheharyar Alam Khan
 * Course: CS170
 * Lab: 01
 * Due: 2/27/2019 @ 11PM
 */

import javax.swing.JOptionPane;
//Operations Class
public class NestedLoopTable {
	public static void loopy()
	{
		// gets starting value from user
		int start = Integer.parseInt((String)JOptionPane.showInputDialog("Enter start value"));
		int start_start = start;
		// gets ending value from user
		int end = Integer.parseInt((String)JOptionPane.showInputDialog("Enter end value"));
		// initializing String str as an empty string.
		String str = "";
		/* Outer Loop
		 * 	while start is less than end because we want to start at the start and end at end, including the end value.
		 * 	each iteration of this loop is one line of the desired output
		 */
		while (start <= end)
		{
			/* Inner Loop
			 * 	this is a for loop because we always want to start at 1 and end at the current value of start.
			 * 	each iteration of this loop is a character and a space in each line of the desired output.
			 */
			for (int i = start_start; i <= start; i++)
			{
				// utilizing Java's feature to be able to concatenate strings and integers by the + operator simultaneously.
				str += i + " ";
			}
			// adding a newline to the string after adding all the characters from the for loop
			str += "\n";
			start++;
		}
		//displays the output on the screen in a box
		JOptionPane.showMessageDialog(null, str);
		return;
	}
}
