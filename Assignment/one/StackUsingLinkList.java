import java.util.ArrayList;
import java.util.List;


public class StackUsingLinkList<T> {
	
	private List<T> stackList;
	public StackUsingLinkList()
	{
		stackList=new ArrayList<T>();
	}
	public void push(T obj) {
		stackList.add(obj);
	}
	public T pop() throws UnsupportedOperationException 
	{
		if(stackList.size()==0)
		{
			throw new UnsupportedOperationException();
		}
		return stackList.remove(stackList.size()-1);
		
	}
	public T top() throws UnsupportedOperationException 
	{
		if(stackList.size()==0)
		{
			throw new UnsupportedOperationException();
		}
		return stackList.get(stackList.size()-1);
		
	}
	public boolean isEmpty()
	{
		if(stackList.size()==0)
			return true;
		else
			return false;
	}

}
