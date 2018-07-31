import java.util.List;

public class ShapeFactory {
    public static Shape createShape(ShapeType shapeType, Point startingOrCenterPoint, 
            List<Integer> argumentList){
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
        }
        return shape;
    }
}
