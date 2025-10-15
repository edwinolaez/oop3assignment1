package shapes;

public abstract class Prism extends Shape
{
	//attribute
	private double side;
	
	//constructor
	public Prism(double height,double side)
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
		return calculateBaseArea()*getHeight();
	}
	
	@Override
	public String toString() {
		return super.toString() + " Side: " + String.format("%.3f", getSide());
	}
}
