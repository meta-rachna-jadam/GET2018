
public class StackException extends Exception {
	
	private int exceptionNO=0;
	public StackException(int exNO)
	{
		exceptionNO=exNO;
	}
	public String toString()
	{
		if(exceptionNO==1)
		{
			return "Underflow Exception"; 
		}
		else if(exceptionNO==2)
		{
			return "Overflow Exception"; 
		}
		else
		{
			return "Undefine Exception"; 
		}
	}

}
