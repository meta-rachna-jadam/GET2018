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
    
    /**
     * return shape type of the shape
     */
    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
    
    /**
     * return date and time of the shape at which it add onto the screen
     */
    @Override
    public LocalDateTime getDateAndTimeOfShapeCreation() {
        return dateAndTimeOfShapeCreation;
    }
    
    /**
     * return area of the Square
     */
    @Override
    public double getArea(){
        return (this.width * this.width);
    }
    
    /**
     * return parameter of Square
     */
    @Override
    public double getparameter(){
        return (4 * this.width);
    }
    
    /**
     * return origin point of the circle
     * the left corner of that edge will be considered as the origin
     */
    @Override
    public Point getOrigin(){
        return this.startingPoint;
    }
    
    /**
     * return true if point enclose in the shape, otherwise false 
     */
    @Override
    public boolean isPointEnclosed(Point point){
        if((point.getXPoint() <= this.startingPoint.getXPoint() + this.width) && 
                (point.getXPoint() >= this.startingPoint.getXPoint()) &&
                (point.getYPoint() >= this.startingPoint.getYPoint()) &&
                (point.getYPoint() <= this.startingPoint.getYPoint() + this.width)){
            return true;
        }
        return false;
    }
}
