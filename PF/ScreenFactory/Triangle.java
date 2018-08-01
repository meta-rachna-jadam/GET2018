import java.time.LocalDateTime;


public class Triangle implements Shape{
    private final int sideThree; //SideThree is base of triangle
    private final int height;
    private final Point startingPoint;
    private final int sideOne;
    private final int sideTwo;
    private final LocalDateTime dateAndTimeOfShapeCreation;
    private final ShapeType shapeType;
    
    public Triangle(Point startingPoint, int sideOne, int sideTwo, int sideThree, int height){
        this.sideThree = sideThree; 
        this.height = height;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.startingPoint = startingPoint;
        this.dateAndTimeOfShapeCreation = ShapeUtility.getCurrentDateAndTime();
        this.shapeType = ShapeType.TRIANGLE;
    }
    
    @Override
    /**
     * return shape type of the shape
     */
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
     * return area of the Triangle
     */
    @Override
    public double getArea() {
        return ((sideThree * height) / 2);
    }

    /**
     * return parameter of Triangle
     */
    @Override
    public double getparameter() {
        return (this.sideOne + this.sideTwo + this.sideThree);
    }

    /**
     * return origin point of the circle
     * the left corner of that edge will be considered as the origin
     */
    @Override
    public Point getOrigin() {
        return this.startingPoint;
    }

    /**
     * return true if point enclose in the shape, otherwise false 
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        Point trianglePoits[] = new Point[3];
        trianglePoits[0] = this.startingPoint;
        trianglePoits[1] = new Point(this.startingPoint.getXPoint() 
                + this.sideThree, this.startingPoint.getYPoint());
        trianglePoits[2] = new Point((int) (Math.sqrt((this.sideOne * this.sideOne) - 
                (this.height * this.height))),this.height);
        double area = calculateAreaOfTriangleByCornerPoints(trianglePoits[0], trianglePoits[1], point) +
        		calculateAreaOfTriangleByCornerPoints(trianglePoits[1], trianglePoits[2], point) +
                calculateAreaOfTriangleByCornerPoints(trianglePoits[0], trianglePoits[2], point);
        if(area == this.getArea()){
            return true;
        }
        return false;
    }
    
    private double calculateAreaOfTriangleByCornerPoints(Point point1, Point point2, Point point3){
        double sideOneLength = ShapeUtility.calculateDistance(point1, point2);
        double sideTwoLength = ShapeUtility.calculateDistance(point2, point3);
        double sideThreeLength = ShapeUtility.calculateDistance(point3, point1);
        double halfOfTheParameter = (sideOneLength + sideTwoLength + sideThreeLength)/2;
        double area = Math.sqrt((halfOfTheParameter) * (halfOfTheParameter - sideOneLength) 
                * (halfOfTheParameter - sideTwoLength) * (halfOfTheParameter - sideThreeLength));
        return area;
    }
}
