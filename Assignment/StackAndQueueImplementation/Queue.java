
public interface Queue<A> {
    public boolean enqueue(A data) throws AssertionError;
    public A dequeue() throws AssertionError;
    public boolean isQueueFull();
    public boolean isQueueEmpty();
}
