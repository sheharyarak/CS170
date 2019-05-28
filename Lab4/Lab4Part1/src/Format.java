/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 1
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * The format class is for formatting the output.
 * The setW function is used format a string so that its length reaches w characters
 * if the length of the input string is less than w characters it fills the rest of the characters with the string f.
 */
public class Format {
	public String setW(String s, int w, String f) {
		String str = ""; //empty string
		str += s;// Concatenates string
		for(int i = s.length(); i < w; i++) {//fills up rest of string
			str += f;
		}
		return str;
	}
}
