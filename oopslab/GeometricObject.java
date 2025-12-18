public abstract class GeometricObject {

    private String color;
    private boolean filled;

    // Default constructor
    public GeometricObject() {
        this("white", false);
    }

    // Parameterized constructor
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();
}
