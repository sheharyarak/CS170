import javax.swing.JOptionPane;
/*
 * Name: Sheharyar Alam Khan
 * Lab 3
 * This is the driver class. it makes 4 objects and displays their descriptions (length, width, height, area, volume).
 */
public class RectangularShapeApp {

	public static void main(String[] args) {
		String message = "";
		String title = "RectangularShapeApp";//initializes the title
		int icon = JOptionPane.PLAIN_MESSAGE;//sets the JOptionPane messageType to make it so that no message appears 
		Cuboid obj1 = new Cuboid(2);//creates a cube
		Cuboid obj2 = new Cuboid(4, 8, 16);//creates a cuboid
		Rectangle obj3 = new Rectangle(32);//creates a square
		Rectangle obj4 = new Rectangle(64,128);//creates a rectangle
		
		/*
		 * The following code uses polymorphism to get descriptions of each of the objects created above using the toString function
		 */
		RectangularShape shape = obj1;
		shape.computeVolume();
		shape.computeArea();
		message += shape.toString();
		shape = obj2;
		shape.computeVolume();
		shape.computeArea();
		message += shape.toString();
		shape = obj3;
		shape.computeVolume();
		shape.computeArea();
		message += shape.toString();
		shape = obj4;
		shape.computeVolume();
		shape.computeArea();
		message += shape.toString();
		JOptionPane.showMessageDialog(null, message, title, icon);//shows the description of the objects created above.
	}

}
