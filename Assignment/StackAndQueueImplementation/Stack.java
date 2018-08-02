
public interface Stack<T>  {
    public boolean push(T pushedElement) throws AssertionError;
    public T pop() throws AssertionError;
    public boolean isStackFull();
    public boolean isStackEmpty();
    public T peek();
}
