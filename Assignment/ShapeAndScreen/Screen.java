import java.util.ArrayList;
import java.util.List;


public class Screen {
    private List<Shape> listOfShapes;
    public Screen() {
        listOfShapes = new ArrayList<Shape>();
    }
    
    public boolean addShapeOnScreen(ShapeType shapeType, Point startingOrCenterPoint, 
            List<Integer> argumentList){
        Shape shape = ShapeFactory.createShape(shapeType, startingOrCenterPoint, argumentList);
        if(shape != null){
            if(listOfShapes.add(shape)){
                return true;
            }
        }
        return false;
    }
    
    public boolean removeShapeFromScreen(Shape shape){
        if(shape != null){
            if(listOfShapes.remove(shape)){
                return true;
            }
        }
        return false;
    }
    
    /*public boolean removeSpecificShapeFromScreen(ShapeType shapeType){
        for(Shape shape : listOfShapes){
            if(shape.getShapeType() == shapeType){
                listOfShapes.remove(shape);
            }
        }
        return true;
    }*/
    
    public List<Shape> getListOfShapeObjectsEnclosingASpecifiedPoint(Point point){
        List<Shape>  listOfShapeObjectsEnclosingAPoint = new ArrayList<Shape>();
        for(Shape shape : listOfShapes){
            if(shape.isPointEnclosed(point)){
                listOfShapeObjectsEnclosingAPoint.add(shape);
            }
        }
        return listOfShapeObjectsEnclosingAPoint;
    }
    
    public List<Shape> getShapeInAscendingOrderBasedOnArrangementType
            (ArrangementBasedOnType arrangementBasedOnType){
        List<Shape> arrangedListOfShape = new ArrayList<Shape>();
        arrangedListOfShape = listOfShapes;
        
        return arrangedListOfShape;
    }
}
