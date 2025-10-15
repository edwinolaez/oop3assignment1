package shapes;

public class Pyramid extends Shape
{
	//attribute
	private double side;
	
	//constructor 
	public Pyramid(double side, double height)
	{
		super(height);
		this.side = side;
	}
	//getter
	public double getSide()
	{
		return side;
	}
	
	@Override
	public double calculateVolume()
	{
		return 1/3 * calculateBaseArea() * getHeight();
	}
	
	@Override
	public double calculateBaseArea()
	{
		return side * side;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Side: " + String.format("%.3f", getSide());
	}
}
