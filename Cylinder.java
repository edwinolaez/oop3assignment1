package shapes;

public class Cylinder extends Shape
{
	//attribute
	private double radius;
	
	//constructor
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//getter
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double calculateVolume()
	{
		return calculateBaseArea() * getHeight();
	}
	
	@Override
	public double calculateBaseArea()
	{
		return Math.PI * radius *radius;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Radius " + String.format("%.3f", getRadius());
	}

}
