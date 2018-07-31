import java.time.LocalDateTime;

public class Square implements Shape{
    private Point startingPoint;
    private int width;
    private final LocalDateTime dateAndTimeOfShapeCreation;
    private final ShapeType shapeType;
    public Square(Point startingPoint, int width){
        this.startingPoint = startingPoint;
        this.width = width;
        this.dateAndTimeOfShapeCreation = ShapeUtility.getCurrentDateAndTime();
        this.shapeType = ShapeType.SQUARE;
    }
    
    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
    
    public LocalDateTime getDateAndTimeOfShapeCreation() {
        return dateAndTimeOfShapeCreation;
    }
    
    @Override
    public double getArea(){
        return (this.width * this.width);
    }
    
    @Override
    public double getPerimeter(){
        return (4 * this.width);
    }
    
    @Override
    public Point getOrigin(){
        return this.startingPoint;
    }
    
    @Override
    public boolean isPointEnclosed(Point point){
        if((point.getXPoint() <= this.startingPoint.getXPoint() + this.width) && 
                (point.getYPoint() <= this.startingPoint.getYPoint() + this.width)){
            return true;
        }
        return false;
    }
}
