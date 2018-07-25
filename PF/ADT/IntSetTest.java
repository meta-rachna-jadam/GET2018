import static org.junit.Assert.*;

import org.junit.Test;


public class IntSetTest {

    @Test
    public void testIsMemberMethod() {
        IntSet integerSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,95,85,35});
        assertTrue(integerSet.isMember(95));
        assertFalse(integerSet.isMember(99));
    }

    @Test
    public void testSizeMethod() {
        IntSet integerSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,95,85,35});
        assertEquals(18, integerSet.size());
        assertNotEquals(20, integerSet.size());
    }
    
    @Test
    public void testIsSubSetMethod() {
        IntSet integerSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,95,85,35});
        assertTrue(integerSet.isSubSet(new IntSet(new int[]{1,2,4,5})));
        assertFalse(integerSet.isSubSet(new IntSet(new int[]{1,2,4,55})));
    }
    
    @Test
    public void testGetComplementMethod() {
    	IntSet integerSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,95,85,35});
    	assertNotSame(new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,95,85,35}), integerSet.getComplement());
    }
    
}
