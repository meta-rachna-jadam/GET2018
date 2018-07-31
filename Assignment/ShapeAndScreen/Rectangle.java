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

    public LocalDateTime getDateAndTimeOfShapeCreation() {
        return dateAndTimeOfShapeCreation;
    }
  
    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
    
    @Override
    public double getArea(){
        return (this.length * this.breadth);
    }
    
    @Override
    public double getPerimeter(){
        return (2 * (this.length + this.breadth));
    }
    
    @Override
    public Point getOrigin(){
        return this.startingPoint;
    }
    
    @Override
    public boolean isPointEnclosed(Point point){
        if((point.getXPoint() <= this.startingPoint.getXPoint() + this.length) && 
                (point.getYPoint() <= this.startingPoint.getYPoint() + this.breadth)){
            return true;
        }
        return false;
    }
}
