import java.time.LocalDateTime;

public class Rectangle implements Shape{
	private final Point startingPoint;
    private final int breadth;
    private final int  length;
    private final ShapeType shapeType;
    private final LocalDateTime dateAndTimeOfShapeCreation;
    
    public Rectangle(Point startingPoint, int breadth, int length){
        this.startingPoint = startingPoint;
        this.breadth = breadth;
        this.length = length;
        this.dateAndTimeOfShapeCreation = ShapeUtility.getCurrentDateAndTime();
        this.shapeType = ShapeType.RECTANGE;
    }

    /**
     * return date and time of the shape at which it add onto the screen
     */
    @Override
    public LocalDateTime getDateAndTimeOfShapeCreation() {
        return dateAndTimeOfShapeCreation;
    }
  
    /**
     * return shape type of the shape
     */
    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
    
    /**
     * return area of the Rectangle 
     */
    @Override
    public double getArea(){
        return (this.length * this.breadth);
    }
    
    /**
     * return parameter of Rectangle
     */
    @Override
    public double getparameter(){
        return (2 * (this.length + this.breadth));
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
        if((point.getXPoint() <= this.startingPoint.getXPoint() + this.length) && 
        		(point.getXPoint() >= this.startingPoint.getXPoint()) &&
                (point.getYPoint() >= this.startingPoint.getYPoint()) &&
                (point.getYPoint() <= this.startingPoint.getYPoint() + this.breadth)){
            return true;
        }
        return false;
    }

}
