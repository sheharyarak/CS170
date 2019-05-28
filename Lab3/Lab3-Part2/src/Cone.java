
public class Cone extends Circle2{
	double height = 0.0;
	public Cone() {
		super();			//call super class non-argument constructor
	}
	public Cone(double radius) {
		super(radius);		//call super class one-argument constructor
	}
	public Cone(double radius, double height) {
		super(radius);		//call super class one-argument constructor
		this.height = height;
	}
	public Cone(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);//call super class four-argument constructor
	}
	@Override
	public void computeArea() {		//compute cone's area
		super.computeArea();		//call super class' method
		area = area + (Math.PI *radius * (Math.sqrt(radius*radius + height*height))); // A = πr^2 +  πr*l
	}
	@Override
	public void computeVolume() {	//compute Cone's volume
		super.computeArea();
		volume = ((height * area)/3.0);	//	h*πr^2
	}
	@Override
	public String toString() {		//override the toString() method
		//This function returns the description of the object in String format.
		this.computeVolume();
		this.computeArea();
		return "Shape: Cone\nRadius: " + radius +"\nHeight: " + height + "\nArea: " + area + "\nVolume: " + volume + "\n";
	  }
}
