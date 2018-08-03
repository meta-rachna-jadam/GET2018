
public class QueueImplementationUsingLinkedList implements Queue {
    private Node front;
    private Node rear; 
    private int currentSize;
	
    private class Node
    { 
        int data;
        Node next;
    }
    
    public QueueImplementationUsingLinkedList(){
        this.front = new Node();
        this.rear = null;
        this.currentSize = 0;
    }
	
    /**
     * this method adds element at the end (rear) of the queue.
     * @param data  data that you want to insert in queue
     */
    @Override
    public boolean enqueue(int data) throws AssertionError{
    	if(isQueueFull()){
    	    throw new AssertionError("Overflow ! Unable to add element in Queue");
    	}
    	Node previousRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isQueueEmpty()){
            front = rear;
        }
        else {
        	previousRear.next = rear;
        }
        currentSize++;
        return true;
    }
    
    /**
     * this method removes an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public int dequeue() throws AssertionError{
    	if(isQueueEmpty()){
    		rear = null;
    	    throw new AssertionError("Underflow ! Unable to remove element from Queue");
    	}
    	int data = front.data;
        front = front.next;
        currentSize--;
        return data;
    }
    
    /**
     * This method checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isQueueFull(){
        return false;
    }
    
    /**
     * This method checks whether the queue is empty or not
     * @return boolean true if queue is empty, otherwise false
     */
    @Override
    public boolean isQueueEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }
}
