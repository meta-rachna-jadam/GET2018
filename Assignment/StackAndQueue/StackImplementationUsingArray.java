/**
 * Stack implementation using array
 * @author Rachna Jadam
 *
 */
public class StackImplementationUsingArray<T> implements Stack<T> {
    private Object stackArray[];
    private int top;
 
    public StackImplementationUsingArray() {
        this.stackArray = new Object[Stack.capacityOfStack];
        this.top = -1;
    }
    
    /**
     * this method adds element at the top of the stack.
     * @param data  data that you want to insert in stack
     */
    @Override
    public boolean push(T pushedElement) throws AssertionError {
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
        if(top == -1){
            return true;
        }
        return false;
    }
 
    /**
     * This method checks whether the stack is full or not
     * @return boolean true if stack is full, otherwise false
     */
    @Override
    public boolean isStackFull() {
        if(top == Stack.capacityOfStack - 1){
            return true;
        }
        return false;
    }
}
