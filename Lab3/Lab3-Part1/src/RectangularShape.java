
public abstract class RectangularShape {
	double length = 0.0;
	double width = 0.0;
	double area = 0.0;
	double volume = 0.0;
	String shape = "Rectangular Shape";
	
	public abstract void computeArea();
	public abstract void computeVolume();
	public abstract String toString();
	public RectangularShape(double width, double length) {
		this.width = width;
		this.length = length;
		if(width == length)
			shape = "Square";
		else
			shape = "Rectangle";
	}
	public RectangularShape(double length) {
		this.length = length;
		this.width = length;
		shape = "Square";
	}
}
