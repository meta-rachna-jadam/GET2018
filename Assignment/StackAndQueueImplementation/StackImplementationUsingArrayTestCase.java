import static org.junit.Assert.*;

import org.junit.Test;


public class StackImplementationUsingArrayTestCase {
    
	@Test
    public void testPushAddElementInStackReturnTrueIfAddSuccessful () {
        Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(4);
        assertTrue(stackInstance.push(10));
        assertTrue(stackInstance.push(20));
    }
    
    @Test(expected = AssertionError.class)
    public void testPushAddElementInAleradyFullStackOverflowCondition () {
        Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        stackInstance.push(40);
        stackInstance.push(50);
        stackInstance.push(60);
        stackInstance.push(70);
        stackInstance.push(80);
        stackInstance.push(90);
        stackInstance.push(100);
        stackInstance.push(110);
    }
    
    @Test
    public void testPopRemoveElementFromStackReturnTrueIfRemoveSuccessful () {
        Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertEquals(30,(int)stackInstance.pop());
        assertNotEquals(10, (int)stackInstance.pop());
    }
    
    @Test(expected = AssertionError.class)
    public void testpopRemoveElementFromEmptyStackUnderflowCondition () {
        Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
        stackInstance.pop();
    }
    
    @Test
    public void testIsStackFullReturnTrueIfStackIsFull () {
        Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertFalse(stackInstance.isStackFull());
        stackInstance.push(40);
        stackInstance.push(50);
        stackInstance.push(60);
        stackInstance.push(70);
        stackInstance.push(80);
        stackInstance.push(90);
        stackInstance.push(100);
        assertTrue(stackInstance.isStackFull());
    }
    
    @Test
    public void testIsStackEmptyReturnTrueIfStackIsEmpty () {
    	Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
    	assertTrue(stackInstance.isStackEmpty());
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertFalse(stackInstance.isStackEmpty());
    }	
    
    @Test
    public void testPeekReturnTopElementOfStack() {
    	Stack<Integer> stackInstance = new StackImplementationUsingArray<Integer>(10);
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        assertEquals(30,(int)stackInstance.peek());
        assertNotEquals(10,(int)stackInstance.peek());
    }
}
