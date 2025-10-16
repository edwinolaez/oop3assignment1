package shapes;

public class PentagonalPrism
{
    public PentagonalPrism(double height, double side)
    {
        super(height, side);
    }

    @Override
    public double calculateBaseArea()
    {
        return (5 * getSide() * getSide() * Math.tan(0.942478))/4;
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
