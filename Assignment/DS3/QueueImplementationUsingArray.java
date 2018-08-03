/**
 * Queue implementation using array
 * @author Rachna Jadam
 * 
 */
public class QueueImplementationUsingArray<T> implements Queue<T> {
    private Object[] queueArray;
    private int front;
    private int rear;
    private int currentSize;
    
    public QueueImplementationUsingArray(int capacityOfQueue) {
        queueArray = new Object[capacityOfQueue];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }
    
    /**
     * this method adds element at the end (rear) of the queue.
     * @param data  data that you want to insert in queue
     */
    @Override
    public boolean enqueue(T data) throws AssertionError {
    	if (data == null) {
    	    throw new AssertionError("Data should not be null");
    	}
    	if (isQueueFull()) {
            throw new AssertionError("Overflow ! Unable to add element in Queue");
        }
        if (++rear >= queueArray.length && currentSize != queueArray.length) {
            rear = 0;
        }
        queueArray[rear] = data;
        currentSize++;
        return true;
    }
    
    /**
     * this method removes an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public Object dequeue() throws AssertionError {
    	if (isQueueEmpty()) {
            throw new AssertionError("Underflow ! Unable to remove element from Queue");
        }else {
            if (front++ > queueArray.length-1) {
                front = 0;
            } 
            currentSize--;
        }
        if (front == 0 && rear == queueArray.length-1) {
            return queueArray[queueArray.length - 1];
        }
        if (front == 0 && rear != queueArray.length-1) {
            return queueArray[0];
        }
    	return queueArray[front - 1];
    }
    
    /**
     * This method checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isQueueFull() {
    	return (currentSize == queueArray.length); 
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
