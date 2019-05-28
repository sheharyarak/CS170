/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 1
 * Professor Gao
 * 05/08/19
 * Description:
 * This is the driver class and it contains the main functions. In this lab I am using Object which will 
 * contain all of the options for the Friend App. In this class I am using do-while loop to test the cases/options 
 * which are going to be used in the program when it executes. Since this is the driver class it combines all of the 
 * other classes. I am using JPanel to make the window that adds friend's info to the friends mysohu collection.
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FriendApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setting up the program
		Validator valid = new Validator();
		MySohu friends = new MySohu();
		Object message = "Select an Option:";
		String title = "FriendApp";
		int optionType = JOptionPane.PLAIN_MESSAGE;
		int messageType = JOptionPane.PLAIN_MESSAGE;
		Object[] options = {
				"Add",
				"Remove",
				"Print",
				"Search"
		};
		Object initialValue = options[0];
		int choice;
		//making the add panel
		JPanel addPanel = new JPanel();
		//setting up the add panel
		GridLayout gl = new GridLayout(4,2); // 4 rows, 2 columns
		addPanel.setLayout(gl);
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField();
		JLabel emailLabel = new JLabel("Email: ");
		JTextField emailField = new JTextField();
		JLabel addressLabel = new JLabel("Address: ");
		JTextField addressField = new JTextField();
		JButton addButton = new JButton("Add");
		//defining what the add button does on click.
		//(It doesn't clear the fields after adding intentionally because it is easier to test)
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean error = false;
					String errMessage = "";
					String name = nameField.getText();
					String email = emailField.getText();
					String address = addressField.getText();
					if(valid.validEmail(email) == false)
					{
						errMessage += "Invalid Email\n"; //
						error = true;
					}
					if(valid.validName(name) == false)
					{
						errMessage += "Invalid Name\n";
						error = true;
					}
					if(valid.validAddress(address) == false)
					{
						errMessage += "Invalid Address\n";
						error = true;
					}
					if(error)
					{
						throw new Exception(errMessage);
					}
					else {
						FriendInfo friend = new FriendInfo(name, email, address);
						friends.add(friend);
						JOptionPane.showMessageDialog(null, "Friend Added", "FriendApp", JOptionPane.PLAIN_MESSAGE);
					}
				} catch(Exception err) {
					JOptionPane.showMessageDialog(null, err, "FriendApp", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JButton clearButton = new JButton("Clear");
		//defining what the clear button does on click. it clears all the fields
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				emailField.setText("");
				addressField.setText("");
			}
		});
		//adding labels, buttons, and fields to the add panel.
		addButton.setPreferredSize(new Dimension(200, 30));
		addPanel.add(nameLabel);
		addPanel.add(nameField);
		addPanel.add(emailLabel);
		addPanel.add(emailField);
		addPanel.add(addressLabel);
		addPanel.add(addressField);
		addPanel.add(addButton);
		addPanel.add(clearButton);
		//choice set to zero so that program starts with add panel window.
		choice = 0;
		//do while loop instead of while loop because we want to start the program with the add panel
		//and ask the user what they want to do after they've finished adding FriendInfo.
		do {
			if(choice == 0) {//add
				JOptionPane.showMessageDialog(null, addPanel);
			}
			else if(choice == 1) {//delete
				try {
				String input = JOptionPane.showInputDialog(null, "Enter Name of Friend to Remove:", "FriendApp", JOptionPane.PLAIN_MESSAGE);
				if(valid.validName(input) == false)
				{
					throw new Exception("Invalid Name");
				}
				else
				{
					boolean deleted = friends.delete(input);
							if(deleted)
								JOptionPane.showMessageDialog(null, "Friend Removed Successfully");
							else
								JOptionPane.showMessageDialog(null, "No Friend by that name in the list.");
				}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
			else if(choice == 2) {//search
				JOptionPane.showMessageDialog(null, friends.print());
			}
			else if(choice == 3) {
				String search = JOptionPane.showInputDialog(null, "Search: ");
				if (search != null) {
					//using overloaded MySohu constructor with SortedMap parameter to get a collection of the search results.
					MySohu results = new MySohu(friends.search(search)); 
					//show search results
					JOptionPane.showMessageDialog(null, 
							"Searched: \t \"" + search + "\"\n" +
							results.print());
				}
			}
			else//exit
				return;
			//reset choice with user input
			choice = JOptionPane.showOptionDialog(null, message, title, optionType, messageType, null, options, initialValue);
		} while(true);
	}

}
