import java.time.LocalDateTime;

public class Circle implements Shape{
    private final Point centerPoint;
    private final double radius;
    private final LocalDateTime dateAndTimeOfShapeCreation;
    private final ShapeType shapeType;
    
    public Circle(Point centerPoint, double radius){
        this.centerPoint = centerPoint;
        this.radius = radius;
        this.dateAndTimeOfShapeCreation = ShapeUtility.getCurrentDateAndTime();
        this.shapeType = ShapeType.CIRCLE;
    }
    
    /**
     * return area of the circle
     */
    @Override
    public double getArea(){
        return (Math.PI * this.radius * this.radius);
    }
    
    /**
     * return parameter of circle
     */
    @Override
    public double getparameter(){
        return (2 * Math.PI * this.radius);
    }
    
    /**
     * return origin point of the circle
     * the origin will considered to be a point on the circle that lies on the line
     *  connecting the center of the circle to the origin of the screen.
     */
    @Override
    public Point getOrigin(){
    	double slope = getSlope();
    	double distance = getDistanceBetweenOriginAndCircleOrigin();
    	int xPoint = (int) Math.round( Math.sqrt((distance * distance) / ((slope * slope) + 1)));
    	int yPoint = (int)  Math.round(slope * xPoint); 
    	return new Point(xPoint, yPoint);
    }
    
    /**
     * return true if point enclose in the shape, otherwise false 
     */
    @Override
    public boolean isPointEnclosed(Point point) throws AssertionError{
        if(point == null){
            throw new AssertionError("Point value is null");
        }
        double distanceBetweenPointAndCenter = ShapeUtility.calculateDistance(this.centerPoint, point);
        //System.out.println("distance = "+distanceBetweenPointAndCenter);
        if(distanceBetweenPointAndCenter <= radius){
            return true;
        }
        return false;
    }
    
    /**
     * this method is use to get distance between origin of the screen and origin of the circle
     * @return distance between origin of the screen and origin of the circle
     */
    private double getDistanceBetweenOriginAndCircleOrigin(){
        double distance;
        distance = Math.sqrt((this.centerPoint.getXPoint() * this.centerPoint.getXPoint()) + 
                (this.centerPoint.getYPoint() * this.centerPoint.getYPoint()));
        distance = distance - radius;
        return distance;
    }
    
    /**
     * This method is use to get slope of the line passing from origin of the screen and center of the circle
     * @return slope of the line passing from origin of the screen and center of the circle
     */
    private double getSlope(){
        double slope;
        slope = (this.centerPoint.getYPoint() / this.centerPoint.getXPoint());
        return slope;
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
}
