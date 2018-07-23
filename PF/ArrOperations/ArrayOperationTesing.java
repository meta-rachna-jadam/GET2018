import static org.junit.Assert.*;

import org.junit.Test;
public class ArrayOperationTesing {

    @Test
    public void clumpTesting() {
	    ArrOperation arrOperationInstace = new ArrOperation();
	    int count = arrOperationInstace.checkNumberOfClump(new int[]{1, 2, 2, 3, 4, 4});
	    assertEquals(2, count);
    }
	
    @Test(expected = AssertionError.class)
    public void fixXYTest() {
	    ArrOperation arrOperationInstace = new ArrOperation();
	    int array[] = arrOperationInstace.fixXy(new int[]{4,4,4,5,5}, 4, 5);
    }
    
    @Test
    public void fixXYTest1() {
        ArrOperation arrOperationInstace = new ArrOperation();
	    int array[] = arrOperationInstace.fixXy(new int[]{4,5}, 4, 5);
	    assertArrayEquals(new int[]{4,5}, array);
    }
    
    @Test
    public void largestMirrorTest() {
        ArrOperation arrOperationInstace = new ArrOperation();
	    int largestMirrorValue = arrOperationInstace.findLargestMirrorSection(new int[]{1,2,3,2,1,3,2,1});
	    assertEquals(5, largestMirrorValue);
    }
    
    @Test
    public void splitArrayTest2() {
        ArrOperation arrOperationInstace = new ArrOperation();
        int index = arrOperationInstace.getSplitIndex(new int[]{1, 1, 1, 2, 1});
        assertEquals(3, index);
        }
}
