import java.util.List;
/**
 * ShapeFactory class is Factory class for shape
 * @author User8
 *
 */
public class ShapeFactory {
	
	/**
	 * This method is use to create shape objects
	 * @param shapeType                 type of the shape
	 * @param startingOrCenterPoint     starting/center point of shape
	 * @param argumentList              arguments required for shape creation
	 * @return                          shape object        
	 */
    public static Shape createShape(ShapeType shapeType, Point startingOrCenterPoint, 
            List<Integer> argumentList) throws AssertionError{
        Shape shape = null;
        switch (shapeType) {
	        case CIRCLE:
	        	shape = new Circle(startingOrCenterPoint, argumentList.get(0));
	            break;
	        case RECTANGE:
	            shape = new Rectangle(startingOrCenterPoint, argumentList.get(0), argumentList.get(1));
	            break;
	        case SQUARE:
	            shape = new Square(startingOrCenterPoint, argumentList.get(0));
	            break;
	        case TRIANGLE:
	            shape = new Triangle(startingOrCenterPoint, argumentList.get(0),
	                    argumentList.get(1), argumentList.get(2), argumentList.get(3));
	            break;
	        case REGULARPOLYGON:
	        	shape = new RegularPolygon(startingOrCenterPoint, argumentList.get(0),
	                    argumentList.get(1));
	            break;
        }
        if((shape.getOrigin().getXPoint() < ShapeUtility.getLastCoordinateOfScreen().getXPoint()) &&
        		(shape.getOrigin().getYPoint() < ShapeUtility.getLastCoordinateOfScreen().getYPoint())){
        	throw new AssertionError("Shape can not be draw because it exceed the screen resolution"); 
        }
        return shape;
    }
}
