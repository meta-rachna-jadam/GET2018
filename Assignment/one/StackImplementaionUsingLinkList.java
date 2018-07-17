import java.util.Scanner;


public class StackImplementaionUsingLinkList {
	
	
	public static void main(String ar[]) {
	
		StackUsingLinkList<String> stack1=new StackUsingLinkList<String>();
		
		Scanner scanner=new Scanner(System.in);
		int choseOption=1;
		
		while(choseOption!=5)
		{
			System.out.println("Press 1 for Push\nPress 2 for Pop\nPress 3 for find Top\nPress 4 for Check that stack is empty or not\nPress 5 for exit");
			try
			{
				choseOption=scanner.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Please chose correct option");
			}
			switch (choseOption) {
				case 1:
					System.out.println("Please Enter one String");
					String inputString=scanner.next();
					stack1.push(inputString);
					break;
				case 2:
					try{
						stack1.pop();
						System.out.println("Pop Sucessfuly");
					}catch (UnsupportedOperationException exception) {
						System.out.println("Pop fail due to underflow exception");
					}
					catch (Exception e) {
						System.out.println("Pop fail");
					}
					break;
				case 3:
					try{
						String topElement=stack1.top();
						System.out.println("Top element is "+topElement);
					}catch (UnsupportedOperationException exception) {
						System.out.println("No Element in Stack");
					}
					catch (Exception e) {
						System.out.println("No Element in Stack");
					}
					break;
					
				case 4:
					if(stack1.isEmpty())
					{
						System.out.println("Stack is Empty");
					}
					else
					{
						System.out.println("Stack is not empty");
					}
					break;
				case 5:
				default:
					java.lang.System.exit(0);
				
			}
		}
		
		
		
		
	}
	
	
	
	
	
	

}
