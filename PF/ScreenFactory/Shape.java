import java.time.LocalDateTime;


public interface Shape{
    public double getArea();
    public double getparameter();
    public Point getOrigin();
    public boolean isPointEnclosed(Point point);
    public ShapeType getShapeType();
    public LocalDateTime getDateAndTimeOfShapeCreation();
}
