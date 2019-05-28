/*
 * Name: Sheharyar Alam Khan
 * Lab 3
 * This is the driver class. it gets input from the user using JOptionPane and creates an object depending on the input.
 * it then computes its area and volume.
 * finally it displays the object description (radius, height, area, volume). it asks if the user wants to continue.
 */

import javax.swing.JOptionPane;


public class CircularShapeApp
{

	public static void main(String[] args) {
		String title = "RectangularShapeApp";//title of the window
		int messageType = JOptionPane.PLAIN_MESSAGE;//no icon
		String keep_going = "y";//initializing the keep_going variable
		double r, h;//initializing the radius and height variables
		Sphere sphere;//initializing sphere object
		Cone cone;//initializing cone object
		Shape shape;//initializing abstract shape object
		while(keep_going.equals("y"))
		{
			r = Validator.verifyDoubleWithRange("Length", 0, 100000);//gets a validated value for the radius
			h = Validator.verifyDoubleWithRange("Height", 0, 100000);//gets a validated value for the height
			if(h == 0)
			{
				sphere = new Sphere(r);//makes a cone object
				shape = sphere;// using abstract object for polymorphism
			}
			else {
				cone = new Cone(r,h);//makes a cone object
				shape = cone;// using abstract object for polymorphism
			}
			shape.computeVolume();//computes volume
			shape.computeArea();//computes area after volume because the compute area function
			JOptionPane.showMessageDialog(null, shape.toString(), title, messageType);//Using JOptionPane to show the Object description
			//using validator class to get valid input to check if the user wants to keep going
			keep_going = Validator.validateYN("Would you like to keep going");
		}
	}

}
