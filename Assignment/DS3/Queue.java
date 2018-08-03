
public interface Queue {
    public static final int capacityOfQueue = 10;
    public boolean enqueue(int data) throws AssertionError;
    public int dequeue() throws AssertionError;
    public boolean isQueueFull();
    public boolean isQueueEmpty();
}
