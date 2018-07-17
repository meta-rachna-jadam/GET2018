import java.util.Scanner;


public class MyStack {
	
	public static void main(String ar[]) {
		
		StackUsingArray stack1 = null;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter number of elements in stack");
		try
		{
			int numberOfElements=scanner.nextInt();
			stack1=new StackUsingArray(numberOfElements);
		}
		catch(Exception e)
		{
			System.out.println("Please Enter valid number");
		}
			
		int option=0;
		while (option!=4) {
			try
			{
				System.out.println("Press 1 for Push Operation");
				System.out.println("Press 2 for Pop Operation");
				System.out.println("Press 3 or else for Exit Operation");
				option=scanner.nextInt();
					switch (option) {
					case 1:
						System.out.println("Enter element for stack");
						int element=scanner.nextInt();
						stack1.push(element);
						System.out.println("Push Sucessfuly");
						break;
					case 2:
						stack1.pop();
						System.out.println("Pop Sucessfuly");
						break;
	
					case 3:
					default:
						java.lang.System.exit(0);
					}
			}
			catch(StackException e)
			{
				System.out.println(e.toString());
			}
			catch(Exception ex)
			{
				System.out.println("Exception Occoure - "+ex.toString());
			}
		}
	}
}