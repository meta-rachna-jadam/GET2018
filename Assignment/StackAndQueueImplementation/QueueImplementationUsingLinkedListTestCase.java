import static org.junit.Assert.*;

import org.junit.Test;


public class QueueImplementationUsingLinkedListTestCase {

	@Test
    public void testEnqueueAddElementInQueueReturnTrueIfAddSuccessful () {
        Queue<Integer> queueInstance = new QueueImplementationUsingLinkedList<Integer>();
        assertTrue(queueInstance.enqueue(10));
        assertTrue(queueInstance.enqueue(20));
    }
    
    @Test
    public void testDequeueRemoveElementFromQueueReturnTrueIfRemoveSuccessful () {
        Queue<Integer> queueInstance = new QueueImplementationUsingLinkedList<Integer>();
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertEquals(10,(int)queueInstance.dequeue());
        assertNotEquals(30, (int)queueInstance.dequeue());
    }
    
    @Test(expected = AssertionError.class)
    public void testDequeueRemoveElementFromEmptyQueueUnderflowCondition () {
        Queue<Integer> queueInstance = new QueueImplementationUsingLinkedList<Integer>();
        queueInstance.dequeue();
    }
    
    @Test
    public void testIsQueueFullReturnTrueIfQueueIsFull () {
        Queue<Integer> queueInstance = new QueueImplementationUsingLinkedList<Integer>();
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertFalse(queueInstance.isQueueFull());
    }
    
    @Test
    public void testIsQueueEmptyReturnTrueIfQueueIsEmpty () {
    	Queue<Integer> queueInstance = new QueueImplementationUsingLinkedList<Integer>();
    	assertTrue(queueInstance.isQueueEmpty());
        queueInstance.enqueue(10);
        queueInstance.enqueue(20);
        queueInstance.enqueue(30);
        assertFalse(queueInstance.isQueueEmpty());
    }

}
