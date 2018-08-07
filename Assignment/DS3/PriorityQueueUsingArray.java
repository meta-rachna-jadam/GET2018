/**
 * Queue implementation using array
 * @author Rachna Jadam
 * 
 */
public class PriorityQueueUsingArray implements Queue {
    public Node[] queueArray;
    private int front;
    private int rear;
    private int currentSize;
    
    public PriorityQueueUsingArray(int capacityOfQueue) {
        queueArray = new Node[capacityOfQueue];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }
    
    /**
     * this method adds element according to its priority in queue.
     * @param data  data that you want to insert in queue
     * @param priority priority of the element
     */
    @Override
    public boolean enqueue(int data, int priority) throws AssertionError {
    	int index;
    	
    	if (priority < MIN_PRIORITY || priority > MAX_PRIORITY) {
    		throw new AssertionError("Priority is not in range. Priority range: ("+MIN_PRIORITY+", "+MAX_PRIORITY+")");
    	}
    	if (isQueueFull()) {
            throw new AssertionError("Overflow ! Unable to add element in Queue");
        }
    	rear++;
    	for (index = front; index < rear; index++) {
    		if (queueArray[index].getPriority() >= priority){
    			continue;
    		}
    		break;
    	}
    	if (index == rear) {
            queueArray[index] = new Node(data, priority);
    	} else {
    		int indexFromLast;
    		for (indexFromLast = rear-1; indexFromLast >= index; indexFromLast--){
    			queueArray[indexFromLast + 1] = queueArray[indexFromLast];
    		}
    		queueArray[index] = new Node(data, priority);
    	}
    	currentSize++;
        return true;
    }
    
    /**
     * this method removes an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public int dequeue() throws AssertionError {
    	if (isQueueEmpty()) {
            throw new AssertionError("Underflow ! Unable to remove element from Queue");
        }else {
        	System.out.println("front "+queueArray[front].getData()+"   "+front);
            front++;
        }
    	currentSize--;
    	return queueArray[front - 1].getData();
    }
    
    /**
     * This method checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isQueueFull() {
    	return (currentSize == queueArray.length || front == queueArray.length); 
    }
    
    /**
     * This method checks whether the queue is empty or not
     * @return boolean true if queue is empty, otherwise false
     */
    @Override
    public boolean isQueueEmpty() {
    	return (currentSize == 0);
    }
}
