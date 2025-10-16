package shapes;

public class OctagonalPrism
{
        public OctagonalPrism(double height, double side)
    {
        super(height, side);
    }

    @Override
    public double calculateBaseArea()
    {
        return 2 * getSide() * getSide() * (1 + Math.sqrt(2));
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
