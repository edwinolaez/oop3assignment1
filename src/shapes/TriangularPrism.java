package shapes;

public class TriangularPrism extends Prism
{
    public TriangularPrism(double height, double side)
    {
        super(height, side);
    }

    @Override
    public double calculateBaseArea()
    {
        return 1/2 * getSide() * getSide();
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
