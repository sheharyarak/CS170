//Project: subclass class Circle2 inherits CircularShape2
//implements all abstract methods and overrides toString() for possible polymorphism

public class Circle2 extends CircularShape2{
	protected double area;
	protected double volume;
	public Circle2() {
		super();			//call super class non-argument constructor
		area = 0;
		volume = 0;
	}
	public Circle2(double radius) {
		super(radius);		//call super class one-argument constructor
	}
	public Circle2(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);//call super class four-argument constructor
	}
	@Override
	public void computeArea() {
		area = Math.PI * radius * radius;
	}

	public double getArea() {                	//for possible polymorphic call
		return area;
	}
	@Override
	public void computeVolume() {volume = 0;} 	//must implement
	
	public double getVolume() {					//for possible polymorphic call
		return volume;
	}
	@Override
  	public String toString() {					//override the toString() method
		 return "Circle area: " + area + "\nCircle volume: " + volume + "\n";
 	  }

}
