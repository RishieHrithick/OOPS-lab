public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

    private double side;

    // Default constructor
    public Octagon() {
        this(0);
    }

    // Constructor with side
    public Octagon(double side) {
        super("gray", true); // default color and filled state
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public Octagon clone() {
        try {
            return (Octagon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported!");
        }
    }

    @Override
    public int compareTo(Octagon other) {
        return Double.compare(this.getArea(), other.getArea());
    }
}

