
public class StackUsingArray {
	
	private int array[];
	private int top=-1;
	public StackUsingArray(int size) {
		array=new int[size];
	}
	public StackUsingArray() {
		array=new int[5];
	}
	public void push(int number) throws StackException
	{
		if(top==array.length-1)
		{
			throw new StackException(2);
		}
		else
		{
			array[++top]=number;
		}
		
	}
	public int pop() throws StackException
	{
		if(top==-1)
		{
			throw new StackException(1);
		}
		else
		{
			return array[top--];
		}
		
	}
	public int top()
	{
		return array[top];
	}
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}

}
