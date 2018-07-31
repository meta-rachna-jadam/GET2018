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
    
    @Override
    public double getArea(){
        return (Math.PI * this.radius * this.radius);
    }
    
    @Override
    public double getPerimeter(){
        return (2 * Math.PI * this.radius);
    }
    
    @Override
    public Point getOrigin(){
    	double slope = getSlope();
    	double distance = getDistanceBetweenOrigonAndCircleOrigon();
    	int xPoint = (int) Math.round( Math.sqrt((distance * distance) / ((slope * slope) + 1)));
    	int yPoint = (int)  Math.round(slope * xPoint); 
    	return new Point(xPoint, yPoint);
    }
    
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
    
    private double getDistanceBetweenOrigonAndCircleOrigon(){
        double distance;
        distance = Math.sqrt((this.centerPoint.getXPoint() * this.centerPoint.getXPoint()) + 
                (this.centerPoint.getYPoint() * this.centerPoint.getYPoint()));
        distance = distance - radius;
        return distance;
    }
    
    private double getSlope(){
        double slope;
        slope = (this.centerPoint.getYPoint() / this.centerPoint.getXPoint());
        return slope;
    }

    public LocalDateTime getDateAndTimeOfShapeCreation() {
        return dateAndTimeOfShapeCreation;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }
}
