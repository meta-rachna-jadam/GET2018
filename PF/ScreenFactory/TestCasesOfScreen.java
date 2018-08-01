import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCasesOfScreen {

    @Test  
    public void testAddShapeOnScreenWhichAddShapeOnScreenReturnTrueIfAddsuccessfully() {
        Screen screenInstance = new Screen();
        List<Integer> argumentList = new ArrayList<Integer>();
        argumentList.add(10);
        assertTrue(screenInstance.addShapeOnScreen(ShapeType.CIRCLE, new Point(10,10), argumentList));
        assertTrue(screenInstance.addShapeOnScreen(ShapeType.SQUARE, new Point(10,10), argumentList));	
    }
    
    @Test  
    public void testRemoveShapeFromScreenWhichRemoveShapeFromScreenReturnTrueIfRemovesuccessfully() {
        Screen screenInstance = new Screen();
        List<Integer> argumentList = new ArrayList<Integer>();
        argumentList.add(10);
        Shape shapeInstanceForCircle = ShapeFactory.createShape(ShapeType.CIRCLE, 
                new Point(10,10), argumentList);
        screenInstance.addShapeOnScreen(shapeInstanceForCircle);
        assertTrue(screenInstance.removeShapeFromScreen(shapeInstanceForCircle));	
    }
    
    @Test  
    public void testRemoveSpecificShapeFromScreenWhichRemoveShapeFromScreenReturnTrueIfRemovesuccessfully() {
        Screen screenInstance = new Screen();
        List<Integer> argumentList = new ArrayList<Integer>();
        argumentList.add(10);
        assertTrue(screenInstance.addShapeOnScreen(ShapeType.CIRCLE, new Point(10,10), argumentList));
        assertTrue(screenInstance.addShapeOnScreen(ShapeType.SQUARE, new Point(10,10), argumentList));	
        assertTrue(screenInstance.removeSpecificShapeFromScreen(ShapeType.CIRCLE));	
        assertEquals(1, screenInstance.getListOfAllShapesOnScreen().size());
        assertTrue(screenInstance.getListOfAllShapesOnScreen().get(0) instanceof Square);
    }
    
    @Test
    public void testGetListOfShapeObjectsEnclosingASpecifiedPointReturnListOfShape(){
    	Screen screenInstance = new Screen();
        List<Integer> argumentList = new ArrayList<Integer>();
        argumentList.add(10);
        Shape shapeInstaceForCircle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(10,10), argumentList);
        Shape shapeInstaceForSquare = ShapeFactory.createShape(ShapeType.SQUARE, new Point(10,10), argumentList);
        screenInstance.addShapeOnScreen(shapeInstaceForCircle);
        screenInstance.addShapeOnScreen(shapeInstaceForSquare);
        List<Shape> listOfShape = screenInstance.getListOfShapeObjectsEnclosingASpecifiedPoint(new Point(20, 20));
        Object[] expectedShapeArray =  {shapeInstaceForSquare};
        Object[] actualsShapeArray = listOfShape.toArray();
        assertArrayEquals(expectedShapeArray, actualsShapeArray);  		
    }
    
    @Test
    public void testGetShapeInAscendingOrderBasedOnArrangementTypeReturnListOfShapeInOrder(){
    	Screen screenInstance = new Screen();
        List<Integer> argumentList = new ArrayList<Integer>();
        argumentList.add(10);
        Shape shapeInstaceForCircle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(10,10), argumentList);
        Shape shapeInstaceForSquare = ShapeFactory.createShape(ShapeType.SQUARE, new Point(10,10), argumentList);
        screenInstance.addShapeOnScreen(shapeInstaceForCircle);
        screenInstance.addShapeOnScreen(shapeInstaceForSquare);
        List<Shape> listOfShape = screenInstance.
                getShapeInAscendingOrderBasedOnArrangementType(CompareBasedOnType.AREA);
        Object[] expectedShapeArray =  {shapeInstaceForSquare,shapeInstaceForCircle};
        Object[] actualsShapeArray = listOfShape.toArray();
        assertArrayEquals(expectedShapeArray, actualsShapeArray);  
        listOfShape = screenInstance.
                getShapeInAscendingOrderBasedOnArrangementType(CompareBasedOnType.PARAMETER);
        actualsShapeArray = listOfShape.toArray();
        assertArrayEquals(expectedShapeArray, actualsShapeArray);  
        listOfShape = screenInstance.
                getShapeInAscendingOrderBasedOnArrangementType(CompareBasedOnType.ORIGIN_DISTANCE);
        actualsShapeArray = listOfShape.toArray();
        Object[] expectedShapeArray1 =  {shapeInstaceForCircle, shapeInstaceForSquare};
        assertArrayEquals(expectedShapeArray1, actualsShapeArray);  
        listOfShape = screenInstance.
                getShapeInAscendingOrderBasedOnArrangementType(CompareBasedOnType.TIMESTAMP);
        actualsShapeArray = listOfShape.toArray();
        assertArrayEquals(expectedShapeArray1, actualsShapeArray);  
        
    }

}
