
public class Rectangle extends RectangularShape{

	public Rectangle(double length) {
		super(length);
		// TODO Auto-generated constructor stub
	}
	public Rectangle(double length, double width) {
		super(length, width);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computeArea() {
		// TODO Auto-generated method stub
		area = length * width;
	}

	@Override
	public void computeVolume()	{
		volume = 0.0;
	}
	@Override
	public String toString() {
		String str ="";
		str += "Shape: " + shape + "\n";
		str += "Length: " + length + "\nWidth: " + width;
		str += "\nArea: " + area + "\n\n";
		return str;
	}
}
