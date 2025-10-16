package shapes;

public class SquarePrism extends Prism
{
    public SquarePrism(double height, double side)
    {
        super(height, side);
    }

    @Override
    public double calculateBaseArea()
    {
        return getSide() * getSide();
    }

    @Override
    public double calculateVolume()
    {
        return calculateBaseArea() * getHeight();
    }

    @Override
    public String toString()
    {
        return super.toString() + " Side: " + String.format("%.3f", getSide());
    }
}
