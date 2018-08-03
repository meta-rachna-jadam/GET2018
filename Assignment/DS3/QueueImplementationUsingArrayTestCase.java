import static org.junit.Assert.*;

import org.junit.Test;

public class QueueImplementationUsingArrayTestCase {

    @Test
    public void testEnqueueAddElementInQueueReturnTrueIfAddSuccessful () {
        Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(4);
        assertTrue(queueInstance.enqueue(10));
        assertTrue(queueInstance.enqueue(20));
    }
    
    @Test(expected = AssertionError.class)
    public void testEnqueueAddElementInAleradyFullQueueOverflowCondition () {
        Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(2);
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
    }
    
    @Test
    public void testDequeueRemoveElementFromQueueReturnTrueIfRemoveSuccessful () {
        Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(10);
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertEquals(10,(int)queueInstance.dequeue());
        assertNotEquals(30, (int)queueInstance.dequeue());
    }
    
    @Test(expected = AssertionError.class)
    public void testDequeueRemoveElementFromEmptyQueueUnderflowCondition () {
        Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(10);
        queueInstance.dequeue();
    }
    
    @Test
    public void testIsQueueFullReturnTrueIfQueueIsFull () {
        Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(10);
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertFalse(queueInstance.isQueueFull());
        queueInstance.enqueue(40);
        queueInstance.enqueue(50);
        queueInstance.enqueue(60);
        queueInstance.enqueue(70);
        queueInstance.enqueue(80);
        queueInstance.enqueue(90);
        queueInstance.enqueue(100);
        assertTrue(queueInstance.isQueueFull());
    }
    
    @Test
    public void testIsQueueEmptyReturnTrueIfQueueIsEmpty () {
    	Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(10);
    	assertTrue(queueInstance.isQueueEmpty());
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertFalse(queueInstance.isQueueEmpty());
    }
    
    @Test
    public void testDequeueForCircularQueueWhenFrontMoveAtTheStartingIndexOfArray () {
    	Queue<Integer> queueInstance = new QueueImplementationUsingArray<Integer>(3);
    	assertTrue(queueInstance.isQueueEmpty());
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        queueInstance.dequeue();
        assertEquals(20,(int)queueInstance.dequeue());
        assertEquals(30,(int)queueInstance.dequeue());
        queueInstance.enqueue(40);
        queueInstance.enqueue(50);
        assertEquals(40,(int)queueInstance.dequeue());
    }
}
