/**
 * Stack implementation using linked list
 * @author Rachna Jadam
 *
 */
public class StackImplementationUsingLinkedList<T> implements Stack<T> {
	private Node top;
	
    private class Node {
        T data;
        Node next;
    }
    
    public StackImplementationUsingLinkedList(){
        top = null;
    }
	
    /**
     * this method adds element at the top of the stack.
     * @param data  data that you want to insert in stack
     * @exception throw when stack is full and you want to add element in stack
     */
	@Override
    public boolean push(T pushedElement) throws AssertionError{
		if(isStackFull()){
		    throw new AssertionError("Overflow ! Unable to add element in Stack");
		}
        Node previousTop = top;
        top = new Node();
        top.data = pushedElement;
        top.next = previousTop;
        return true;
    }
	
	/**
     * this method removes an element from the top of the stack
     * @return data value which is remove from stack
     * @exception throw when stack is empty and you want to remove element from stack
     */
	@Override
    public T pop() throws AssertionError{
	    if (isStackEmpty()) {
	        throw new AssertionError("Underflow ! Unable to remove element from Stack");
		}
	    T data = top.data;
	    top = top.next;
	    return data;
    }
	
	/**
     * This method checks whether the stack is full or not
     * @return boolean true if stack is full, otherwise false
     */ 
	@Override
    public boolean isStackFull(){
        return false;
    }
	
    /**
     * This method checks whether the stack is empty or not
     * @return boolean true if stack is empty, otherwise false
     */
	@Override
    public boolean isStackEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }
	
	/**
     * This method return the top element of the stack
     */
	@Override
    public T peek(){
        return top.data;
    }
}
