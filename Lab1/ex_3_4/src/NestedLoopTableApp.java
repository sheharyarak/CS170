/*
 * Name: Sheharyar Alam Khan
 * Course: CS170
 * Lab: 01
 * Due: 2/27/2019 @ 11PM
 */

import javax.swing.JOptionPane;
//Driver Class
public class NestedLoopTableApp {
	//
	public static void main(String[] args) {
		// int variable that keeps track of whether the user wants to keep going
		int keep_going;
		//calling loopy the nested loop function the first time
		NestedLoopTable.loopy();
		// loop that keeps running forever
		while (true)
		{
			/*
			 * using  showConfirmDialog box that is ideal for a yes or no question such as "Would you like to keep going?" to ask the user if they would like to keep going.
			 * @param 1 - null, This parameter is the parent component
			 * @param 2 - string,  This parameter should be the yes or no question
			 * @param 3 - string, this parameter should be the box heading
			 * @param 4 - integer, this parameter decides the options such as Yes & No, Yes, No, & Cancel, OK & Cancel, etc. 
			 * @param 5 - this puts in the question mark logo to the left of the question, but it could also put an exclamation point or an i.
			 */
			keep_going = JOptionPane.showConfirmDialog(null, "Would you like to keep going?", "NestedLoopTableApp", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			// if the user selects yes the program calls NestedLoopTable.loopy() again. Else if the user selects no or hits the x the program exits.
			if (keep_going == JOptionPane.YES_OPTION) 
			{
			    NestedLoopTable.loopy();
			}
			else
			{
			    System.exit(0);
			}
		}
	}
}
