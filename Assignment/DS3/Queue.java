
public interface Queue<A> {
    public boolean enqueue(A data) throws AssertionError;
    public Object dequeue() throws AssertionError;
    public boolean isQueueFull();
    public boolean isQueueEmpty();
}
