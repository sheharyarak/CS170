//abstract class CircularShape2
//The second level of the abstract class in circular computing

public abstract class CircularShape2 extends Shape {		//Inheritance
	protected double radius;

public CircularShape2() {
	x1 = y1 = x2 = y2 = 0.0;
	}
public CircularShape2(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);		//Call constructor of Shape
	}
public CircularShape2(double radius) {
	 	this.radius = radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void computeRadius() {
		radius = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	public String toString() {//Returns a description of the Object in String format.
		return super.toString() + "Radius: " + radius + "\n";
	}
}
