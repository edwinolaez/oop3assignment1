package shapes;

public class Cone extends Shape
{
	//attribute
	private double radius;
	
	//constructor
	public Cone(double height, double radius)
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
		return  calculateBaseArea()*getHeight()/3;
	}
	
	@Override
	public double calculateBaseArea()
	{
		return Math.PI *radius * radius;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Radius: " + String.format("%.3f", getRadius());
	}
}
