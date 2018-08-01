import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Screen class is use to manage screen
 * @author Rachna Jadam
 *
 */
public class Screen {
	private List<Shape> listOfShape;
    public Screen() {
        listOfShape = new ArrayList<Shape>();
    }
    
    /**
     * This method is use to add a shape on the screen
     * @param shapeType                 Type of the shape. Shape list is given in the ShapeType enum
     * @param startingOrCenterPoint     starting point for square, rectangle, triangle and regular polygon and
     *                                  center point for circle
     * @param argumentList              argumentList contain arguments of shape other then staring or center point
     * @return                          true if add successfully, false otherwise
     */
    public boolean addShapeOnScreen(ShapeType shapeType, Point startingOrCenterPoint, 
            List<Integer> argumentList){
        Shape shape = null;
		try {
			shape = ShapeFactory.createShape(shapeType, startingOrCenterPoint, argumentList);
			if(shape != null){
	            if(listOfShape.add(shape)){
	                return true;
	            }
	        }
		} catch (AssertionError assertionError) {
			return false;
		}
        return false;
    }
    
    /**
     * Add Shape on the screen
     * @param shape the shape that you want to add on screen
     * @return true if add successfully, false otherwise
     */
    public boolean addShapeOnScreen(Shape shape){
        if(shape != null){
            if(listOfShape.add(shape)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Remove shape from screen
     * @param shape the shape that you want to remove from screen
     * @return true if remove successfully, false otherwise
     */
    public boolean removeShapeFromScreen(Shape shape){
        if(shape != null){
            if(listOfShape.remove(shape)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Remove all shape of a specific type
     * @param shapeType Type of the shape that you want to remove 
     * ShapeType is a enum which store all possible shape type
     * @return true if remove successfully, false otherwise
     */
    public boolean removeSpecificShapeFromScreen(ShapeType shapeType){
        for(Shape shape : listOfShape){
            if(shape.getShapeType() == shapeType){
                listOfShape.remove(shape);
            }
        }
        return true;
    }
    
    /**
     * This method is use to get list of shapes which enclose given point
     * @param point is coordinate of point for which you check this method
     * @return list of shape which enclose given point
     */
    public List<Shape> getListOfShapeObjectsEnclosingASpecifiedPoint(Point point){
        List<Shape>  listOfShapeObjectsEnclosingAPoint = new ArrayList<Shape>();
        for(Shape shape : listOfShape){
            if(shape.isPointEnclosed(point)){
                listOfShapeObjectsEnclosingAPoint.add(shape);
            }
        }
        return listOfShapeObjectsEnclosingAPoint;
    }
    
    /**
     * Method to get list of shape arranged in ascending order based on CompareBasedOnType
     * @param compareBasedOnType CompareBasedOnType is a enum 
     * which contain all possible type on which we compare shapes
     * @return list of shape in ascending order of compareBasedOnType
     */
    public List<Shape> getShapeInAscendingOrderBasedOnArrangementType(CompareBasedOnType compareBasedOnType){
        List<Shape> orderedListOfShape = new ArrayList<Shape>(listOfShape);
        for(int pass = 0; pass < orderedListOfShape.size(); pass++){  
            for(int index = 1; index < (orderedListOfShape.size()-pass); index++){
                if((ShapeUtility.compareTwoShape(orderedListOfShape.get(index - 1),
                        orderedListOfShape.get(index), compareBasedOnType)) == 1){
                        Collections.swap(orderedListOfShape, (index - 1), index);
                 }      
            }  
        }
        return orderedListOfShape;
    }
    
    /**
     * Method use to get list of all shapes on the screen
     * @return list of all shape present on screen
     */
    public List<Shape> getListOfAllShapesOnScreen(){
        return new ArrayList<Shape>(listOfShape);
    }
}
