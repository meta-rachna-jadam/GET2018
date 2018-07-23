import static org.junit.Assert.*;

import org.junit.Test;


public class TestingOfSearching {

	 @Test
	    public void linearSearchingTest() {
		    Searching searchingInstance = new Searching();
		    int index = searchingInstance.linearSearch(new int[]{4,4,4,5,5},0, 5, 5);
		    assertEquals(3, index);
	    }
	 
	 @Test
	    public void binarySearchingTest() {
		    Searching searchingInstance = new Searching();
		    int index = searchingInstance.linearSearch(new int[]{4,2,6,5,5},0, 5, 6);
		    assertEquals(2, index);
	    }

}
