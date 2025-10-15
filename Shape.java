package shapes;

public abstract class Shape implements Comparable<Shape>
{
	//attribute 
	private double height;
	
	//constructor
	public Shape(double height) 
	{
		this.height =height;
	}
	//getter 
	public double getHeight()
	{
		return height;
	}
	
	@Override
	public int compareTo(Shape that)
	{
		if(this.height < that.height)return -1;
		if(this.height > that.height)return 1;
		return 0;
	}
	
	public abstract double calculateVolume();
	public abstract double calculateBaseArea();
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "Height: " + String.format("%.3f", getHeight());
	}
}
