/**
 * Stack implementation using array
 * @author Rachna Jadam
 *
 */
public class StackImplementationUsingArray<T> implements Stack<T> {
    private Object stackArray[];
    private int top;
 
    public StackImplementationUsingArray(int capacityOfStack) {
        this.stackArray = new Object[capacityOfStack];
        this.top = -1;
    }
    
    /**
     * this method adds element at the top of the stack.
     * @param data  data that you want to insert in stack
     */
    @Override
    public boolean push(T pushedElement) throws AssertionError {
        if (pushedElement == null) {
            throw new AssertionError("Push element can not be null");
        }
	    if (isStackFull()) {
	        throw new AssertionError("Overflow ! Unable to add element in Stack");
	    }
	    top++;
	    stackArray[top] = pushedElement;
        return true;		
    }
 
    /**
     * this method removes an element from the top of the stack
     * @return data value which is remove from stack
     */
    @Override
    public T pop() throws AssertionError {
        if (isStackEmpty()) {
            throw new AssertionError("Underflow ! Unable to remove element from stack");
        }
        int returnedTop = top;
        top--;
        return (T) stackArray[returnedTop];
    }
 
    /**
     * This method return the top element of the stack
     */
    @Override
    public T peek() {
        return (T) stackArray[top];
    }
 
    /**
     * This method checks whether the stack is empty or not
     * @return boolean true if stack is empty, otherwise false
     */
    @Override
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method checks whether the stack is full or not
     * @return boolean true if stack is full, otherwise false
     */
    @Override
    public boolean isStackFull() {
        return (top == stackArray.length - 1);
    }
}
