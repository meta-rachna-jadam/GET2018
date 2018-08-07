
public interface Queue {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 0;
    public boolean enqueue(int data,int priority) throws AssertionError;
    public int dequeue() throws AssertionError;
    public boolean isQueueFull();
    public boolean isQueueEmpty();
}
