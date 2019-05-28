/*
 * This is the validator class that takes in a string and returns whether it matches. 
 * 
 * */
package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	//string parameter returns a bool
	public boolean valid(String str) {
		if(str.isEmpty())
			return false;
		Pattern p = Pattern.compile("^[ A-Za-z]+$");
		Matcher m = p.matcher(str);
		return m.matches();
	}
}
