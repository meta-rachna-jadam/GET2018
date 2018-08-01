import java.time.LocalDateTime;


public class RegularPolygon implements Shape {
	private Point startingPoint;
    private int sideLength;
    private int totalSides;
    private final LocalDateTime dateAndTimeOfShapeCreation;
    private final ShapeType shapeType;
    
    public RegularPolygon(Point startingPoint, int sideLength, int totalSides){
        this.startingPoint = startingPoint;
        this.sideLength = sideLength;
        this.totalSides = totalSides;
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
     * return area of the Regular Polygon
     */
    @Override
    public double getArea(){
    	double apothem = (this.sideLength) / (2 * Math.tan(ShapeUtility.convertDegreeToRadian((180 / totalSides)))); 
        return ((this.getparameter() * apothem) / 2);
    }
    
    /**
     * return parameter of Regular Polygon
     */
    @Override
    public double getparameter(){
        return (this.totalSides * this.sideLength);
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
        return false;
    }
}
