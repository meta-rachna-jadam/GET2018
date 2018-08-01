import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.time.LocalDateTime;

/**
 * Utility class for shape
 * @author Rachna Jadam
 *
 */
public class ShapeUtility {
	
	/**
	 * This method is use to calculate distance between point1 and point2
	 * @param point1
	 * @param point2
	 * @return distance between point1 and point2
	 */
    public static double calculateDistance(Point point1, Point point2){
        double distance;
        distance = Math.sqrt(Math.pow((point1.getXPoint() - point2.getXPoint()), 2) + 
                (Math.pow((point1.getYPoint() - point2.getYPoint()), 2)));
        return distance;
    }
    
    /**
     * This method is use to get current date and time
     * @return current date and time
     */
    public static LocalDateTime getCurrentDateAndTime(){
        LocalDateTime currentTime  = LocalDateTime.now();
        return currentTime;
    }
    
    /**
     * This method is use to compare two shapes
     * @param shapeObject1
     * @param shapeObject2
     * @param comparisonType
     * @return 1 if shapeObject1 is greater then shapeObject2, otherwise 0
     */
	public static int compareTwoShape(Shape shapeObject1, Shape shapeObject2, CompareBasedOnType comparisonType) {
        int comparisionResult = 0;
        Point originOfScreen = new Point(0, 0);
        switch (comparisonType) {
		    case AREA:
		        comparisionResult = (shapeObject1.getArea() >  shapeObject2.getArea() ? 1 : 0);
		        break;
		    case ORIGIN_DISTANCE:
		        if((ShapeUtility.calculateDistance(originOfScreen, shapeObject1.getOrigin())) >
		                (ShapeUtility.calculateDistance(originOfScreen, shapeObject2.getOrigin()))){
		            comparisionResult = 1;
		        }
		        else{
		        	comparisionResult = 0;
		        }
		        break;
		    case PARAMETER:
		        comparisionResult = (shapeObject1.getparameter() >  shapeObject2.getparameter() ? 1 : 0);
		        break;
		    case TIMESTAMP:
		        comparisionResult = shapeObject1.getDateAndTimeOfShapeCreation().
		                compareTo(shapeObject2.getDateAndTimeOfShapeCreation());
		        break;
        }
        return  comparisionResult;
    }
	
	/**
	 * This method is use to convert degree in radian
	 * @param degree
	 * @return radian value for degree
	 */
	public static double convertDegreeToRadian(double degree){
	    return ((degree * Math.PI)/180);
	}
	
	public static Point getLastCoordinateOfScreen(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		return new Point(width, height);
	}
}
