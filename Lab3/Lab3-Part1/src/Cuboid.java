public class Cuboid extends Rectangle{
	double height = 0.0;
	public Cuboid(double length) {
		super(length);
		height = length;
		shape = "Cube";
		// TODO Auto-generated constructor stub
	}
	public Cuboid(double length, double width, double height) {
		super(length, width);
		// TODO Auto-generated constructor stub
		this.height = height;
		if(length == width && width == height)
			shape = "Cube";
		else
			shape = "Cuboid";
	}

	@Override
	public void computeArea() {
		// TODO Auto-generated method stub
		area = 2*((length * width) + (length * height) + (width * height));
	}

	@Override
	public void computeVolume()	{
		volume = length * width * height;
	}
	@Override
	public String toString() {
		String str ="";
		str += "Shape: " + shape + "\n";
		str += "Length: " + length + "\nWidth: " + width + "\nHeight: " + height;
		str += "\nArea: " + area + "\n";
		str += "Volume: " + volume + "\n\n";
		return str;
	}
}
