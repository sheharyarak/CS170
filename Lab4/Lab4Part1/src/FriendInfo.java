/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 1
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * This class contains the Contact info of the friend. It contains all the variables that the user will need in this program. 
 * These variables will be used to get the contact information for the friend. In this class I have created a default constructor 
 * which takes empty strings. This class has variables which are private by default. Then I made method which will access the 
 * variable which are private variables. 
 * 
 */
public class FriendInfo {
	//variables
	String name;
	String email;
	String address;
	
	/*
	 * This default constructor defines all the variables as empty strings
	 */
	public FriendInfo() {
		name = "";
		email = "";
		address = "";
	}
	/*
	 * This constructor defines all the variables with their respective input strings passed as parameters.
	 */
	public FriendInfo(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	//sets the name to the input string passed as parameter
	public void setName(String name) {
		this.name = name;
	}
	//sets the email to the input string passed as parameter
	public void setEmail(String email) {
		this.email = email;
	}
	//sets the address to the input string passed as parameter
	public void setAddress(String address) {
		this.address = address;
	}
	/*
	 * the toString function returns a formatted string which contains the info of this object.
	 * 
	 */
	@Override
	public String toString() {
		String str = "";
		Format format = new Format();
		str += format.setW(name, 25, " ");
		str += format.setW(email, 30, " ");
		str += format.setW(address, 35, " ");
		str += "\n";
		return (str);
	}
}
