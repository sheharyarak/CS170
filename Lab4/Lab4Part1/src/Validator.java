/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 1
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * This is the Validator class. it validates inputs for emails, names, and addresses.
 */
public class Validator {

	//validates email. it makes sure the String contains a "." and "@" and is not empty.
	public boolean validEmail(String email) {
		// TODO Auto-generated method stub
		if (email.isEmpty() == true) {
			return (false);
		}
		if(email.contains("@") == true
		&& email.contains(".") == true) {
			return (true);
		}
		else
			return (false);
	}
	//validates name. makes sure there are no numbers.
	public boolean validName(String str) {
		// TODO Auto-generated method stub
		if (str.isEmpty() == true)
			return (false);	
		for(int i = 0; i <= 9; i++)
		{
			if(str.contains(Integer.toString(i)) == true)
				return (false);
		}
		return (true);
	}
	//validates the address. makes sure its not empty
	public boolean validAddress(String str) {
		// TODO Auto-generated method stub
		if (str.isEmpty() == true)
			return (false);			
		else
			return (true);
	}
}
