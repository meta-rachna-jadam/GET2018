import static org.junit.Assert.*;

import org.junit.Test;


public class StackImplementationUsingLinkedListTestCase {
	
	@Test
    public void testPushAddElementInStackReturnTrueIfAddSuccessful () {
        Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
        assertTrue(stackInstance.push(10));
        assertTrue(stackInstance.push(20));
    }
    
    @Test
    public void testPopRemoveElementFromStackReturnTrueIfRemoveSuccessful () {
        Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertEquals(30,(int)stackInstance.pop());
        assertNotEquals(10, (int)stackInstance.pop());
    }
    
    @Test(expected = AssertionError.class)
    public void testpopRemoveElementFromEmptyStackUnderflowCondition () {
        Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
        stackInstance.pop();
    }
    
    @Test
    public void testIsStackFullReturnTrueIfStackIsFull () {
        Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertFalse(stackInstance.isStackFull());
    }
    
    @Test
    public void testIsStackEmptyReturnTrueIfStackIsEmpty () {
    	Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
    	assertTrue(stackInstance.isStackEmpty());
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertFalse(stackInstance.isStackEmpty());
    }	
    
    @Test
    public void testPeekReturnTopElementOfStack(){
    	Stack<Integer> stackInstance = new StackImplementationUsingLinkedList<Integer>();
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertEquals(30,(int)stackInstance.peek());
        assertNotEquals(10,(int)stackInstance.peek());
    }

}
