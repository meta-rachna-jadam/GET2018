
public interface Shape {
    public double getArea();
    public double getPerimeter();
    public Point getOrigin();
    public boolean isPointEnclosed(Point point);
    public ShapeType getShapeType();
}
