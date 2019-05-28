/*
 * Name: Sheharyar Alam Khan
 * Course: CS170
 * Lab: 01
 * Due: 2/27/2019 @ 11PM
 */

//operation class
public class converter {
	//converts °F to °C
	public static float F_to_C(float F)
	{
		return ((((F - 32) * 5)/9) );
	}
	//converts °C to °F
	public static float C_to_F(float C)
	{
		return ((((C * 9)/5)) + 32);
	}
}
