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
    
    public QueueImplementationUsingArray() {
        queueArray = new Object[Queue.capacityOfQueue];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }
    
    /**
     * this method adds element at the end (rear) of the queue.
     * @param data  data that you want to insert in queue
     */
    @Override
    public boolean enqueue(T data) throws AssertionError{
    	if (isQueueFull()) {
            throw new AssertionError("Overflow ! Unable to add element in Queue");
        }
        rear++;
        if(rear >= queueArray.length && currentSize != queueArray.length){
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
    public T dequeue() throws AssertionError{
    	if (isQueueEmpty()) {
            throw new AssertionError("Underflow ! Unable to remove element from Queue");
        } 
        else {
            front++;
            if(front > queueArray.length-1){
                front = 0;
            } 
            currentSize--;
        }
    	return (T) queueArray[front - 1];
    }
    
    /**
     * This method checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isQueueFull(){
    	if (currentSize == queueArray.length){
            return true;
        }
        return false;
    }
    
    /**
     * This method checks whether the queue is empty or not
     * @return boolean true if queue is empty, otherwise false
     */
    @Override
    public boolean isQueueEmpty(){
    	if (currentSize == 0){
            return true;
        }
        return false;
    }
}
