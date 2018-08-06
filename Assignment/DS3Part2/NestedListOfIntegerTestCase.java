import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NestedListOfIntegerTestCase {

	NestedListOfInteger nestedListInstance;
    @Before
    public void beforeMethodToInitializeVariablesWhichAreUsedInOtherMetho() {
    	nestedListInstance = new  NestedListOfInteger();
 	    nestedListInstance.createParentNode(10);
 	    nestedListInstance.createParentNode(20);
 	    nestedListInstance.createParentNode(30);
 	    nestedListInstance.createParentNode(40);
 	    nestedListInstance.createParentNode(50);
 	    nestedListInstance.createChildNode(0, 11);
 	    nestedListInstance.createChildNode(0, 12);
 	    nestedListInstance.createChildNode(0, 13);
 	    nestedListInstance.createChildNode(0, 14);
 	    nestedListInstance.createChildNode(1, 21);
 	    nestedListInstance.createChildNode(1, 22);
 	    nestedListInstance.createChildNode(2, 31);
 	    nestedListInstance.createChildNode(2, 32);
 	    nestedListInstance.createChildNode(3, 41);
 	    nestedListInstance.createChildNode(3, 42);
 	    nestedListInstance.createChildNode(4, 51);
 	    nestedListInstance.createChildNode(4, 52);
    }
    
	@Test
	public void testGetDataOfParentReturnDataOfRootListAtSpecificIndexWithRightIndex() {
		assertEquals(50, nestedListInstance.getDataOfParent(4));
		assertEquals(30, nestedListInstance.getDataOfParent(2));
	}
	
	@Test(expected = AssertionError.class)
	public void testGetDataOfParentReturnDataOfRootListAtSpecificIndexWithWrongIndex() {
		nestedListInstance.getDataOfParent(9);	
	}
	
	@Test
	public void testGetSizeOfChildReturnSizeOfChildListPresentAtSpecificIndexOfRootList() {
		assertEquals(4, nestedListInstance.getSizeOfChild(0));
	}
	
	@Test
	public void testSizeOfParentReturnSizeOfRootList() {
		assertEquals(5, nestedListInstance.size());
	}
	
	@Test
	public void testGetSumReturnSumOfEachElementPresentInNestedList() {
		System.out.println(nestedListInstance.getSum());
		assertEquals(492, nestedListInstance.getSum());
	}
	
	@Test
	public void testGetLargestElementFromAllNestedList() {
		assertEquals(52, nestedListInstance.getLargestElement());
	}
	
	@Test
	public void testSearchASpecificElementInNestedListItReturnTrueIfElementFound() {
		assertTrue(nestedListInstance.search(50));
		assertFalse(nestedListInstance.search(99));
	}

}
