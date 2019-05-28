//subclass Sphere inherits Circle2

 class Sphere extends Circle2{
	public Sphere() {
		super();			//call super class non-argument constructor
	}
	public Sphere(double radius) {
		super(radius);		//call super class one-argument constructor
	}
	public Sphere(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);//call super class four-argument constructor
	}
	@Override
	public void computeArea() {		//compute sphere's area
		super.computeArea();		//call super class' method
		area = 4 * area;
	}
	@Override
	public void computeVolume() {	//compute sphere's volume
		super.computeArea();
		volume = 4.0/3 * radius * area;
	}
	@Override
	public String toString() {					//override the toString() method
		//This function returns the description of the object in String format.
		 return "Shape: Sphere\nRadius: " + radius +"\nArea: " + area + "\nVolume: " + volume + "\n";
	  }
}
