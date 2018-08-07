import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PriorityQueueTestCase {
	
	PriorityQueueUsingArray priorityQueue;
	@Before
	public void Initialize() {
		priorityQueue = new PriorityQueueUsingArray(5);
	}

	@Test
	public void testAIsQueueEmptyReturnTrueTfQueueIsEmpty() {
		assertTrue(priorityQueue.isQueueEmpty());
	}
	
	@Test(expected = AssertionError.class)
	public void testBDequeueUseToDeleteElementFromEmptyQueue() {
		priorityQueue.dequeue();
	}
	
	@Test
	public void testCEnqueueUseToInsertElementInQueueReturnTrueIfAddSuccessfully() {
		assertTrue(priorityQueue.enqueue(10, 5));
		assertTrue(priorityQueue.enqueue(4, 3));
		assertTrue(priorityQueue.enqueue(30, 2));
		
	}
	
	@Test
	public void testDDequeueUseToRemoveElementFromQueueReturnRemovedElement() {
		assertEquals(10, priorityQueue.dequeue());
		assertTrue(priorityQueue.enqueue(43, 9));
		assertTrue(priorityQueue.enqueue(68, 1));
		assertEquals(43, priorityQueue.dequeue());
		assertEquals(4, priorityQueue.dequeue());
		assertEquals(30, priorityQueue.dequeue());
		assertEquals(68, priorityQueue.dequeue());
	}
	
	@Test(expected = AssertionError.class)
	public void testEEnqueueUseToInsertElementWhenQueueIsFull() {
		priorityQueue.enqueue(10, 7);
	}
	
	@Test
	public void testFIsQueueFullReturnTrueTfQueueFull() {
		assertTrue(priorityQueue.isQueueFull());
	}

}
