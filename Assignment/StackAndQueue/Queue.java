
public interface Queue<T> {
    public static final int capacityOfQueue = 10;
    public boolean enqueue(T data) throws AssertionError;
    public T dequeue() throws AssertionError;
    public boolean isQueueFull();
    public boolean isQueueEmpty();
}
