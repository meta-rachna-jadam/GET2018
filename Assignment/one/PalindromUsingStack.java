import java.util.Scanner;
import java.util.Stack;

public class PalindromUsingStack {
	
public static void main(String ar[]) {
		
		System.out.println("Enter any String");
		Scanner scanner=new Scanner(System.in);
		String inputText=scanner.next();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<inputText.length()/2;i++)
		{
			stack.push(inputText.charAt(i));
		}
		int popStart=inputText.length()/2;
		if((inputText.length()%2)!=0)
		{
			popStart+=1;
		}
		
		for(int i=popStart;i<inputText.length();i++)
		{
			if(inputText.charAt(i)!=stack.pop())
			{
				break;
			}
			
		}
		if(stack.isEmpty())
		{
			System.out.println(inputText+" is a palindrom string");
		}
		else
		{
			System.out.println(inputText+" is not a palindrom string");
		}
		

	}
}
