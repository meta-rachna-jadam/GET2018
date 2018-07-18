import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalcMain {

	public static void main(String ar[])
	{
		Scanner scanner=new Scanner(System.in);
		HexCalc hexCalcInstance=new HexCalc();
		int option = 0;
		do{
			try
			{
				System.out.println("\n\nChoose any one option\n");
				System.out.println("Press 1 to convert decimal number into hexadecimal number");
				System.out.println("Press 2 to convert hexadecimal number into decimal number");
				System.out.println("Press 3 to perform hexadeimal number addition");
				System.out.println("Press 4 to perform hexadeimal number subtraction");
				System.out.println("Press 5 to perform hexadeimal number multiplication");
				System.out.println("Press 6 to perform hexadeimal number division");
				System.out.println("Press 7 to check hexadecimal numbers are equal or not");
				System.out.println("Press 8 to check which hexadecimal numbers is greater");
				System.out.println("Press 9 to check which hexadecimal numbers is less");
				System.out.println("Press 10 to exit program\n");
				option=scanner.nextInt();
				int decimalNumber;
				String hexadecimalValue1,hexadecimalValue2;
				switch (option){
					case 1:
						System.out.println("Enter one number in decimal");
						decimalNumber=scanner.nextInt();
						System.out.println("Hexadecimal conversion of "+decimalNumber+" is "+hexCalcInstance.convertDecimalToBase(decimalNumber));
						break;
					case 2:
						System.out.println("Enter one number in hexadecimal");
						hexadecimalValue1=scanner.next();
						System.out.println("Decimal conversion of "+hexadecimalValue1+" is "+hexCalcInstance.convertBaseToDecimal(hexadecimalValue1));
						break;
					case 3:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						System.out.println(hexadecimalValue1+" + "+hexadecimalValue2+" = "+hexCalcInstance.add(hexadecimalValue1, hexadecimalValue2));
						break;
					case 4:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						System.out.println(hexadecimalValue1+" + "+hexadecimalValue2+" = "+hexCalcInstance.subtract(hexadecimalValue1, hexadecimalValue2));
						break;
					case 5:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						System.out.println(hexadecimalValue1+" + "+hexadecimalValue2+" = "+hexCalcInstance.multiply(hexadecimalValue1, hexadecimalValue2));
						break;
					case 6:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						System.out.println(hexadecimalValue1+" + "+hexadecimalValue2+" = "+hexCalcInstance.divide(hexadecimalValue1, hexadecimalValue2));
						break;
					case 7:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						boolean isEqual=hexCalcInstance.isEquals(hexadecimalValue1, hexadecimalValue2);
						if(isEqual){
							System.out.println(hexadecimalValue1+" is equal to "+hexadecimalValue2);
						}
						else{
							System.out.println(hexadecimalValue1+" is not equal to "+hexadecimalValue2);
						}
						break;
					case 8:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						boolean isGreater=hexCalcInstance.isEquals(hexadecimalValue1, hexadecimalValue2);
						if(isGreater){
							System.out.println(hexadecimalValue1+" is greter then "+hexadecimalValue2);
						}
						else{
							System.out.println(hexadecimalValue1+" is less then to "+hexadecimalValue2);
						}
						break;
					case 9:
						System.out.println("Enter two number in hexadecimal");
						hexadecimalValue1=scanner.next();
						hexadecimalValue2=scanner.next();
						boolean islesser=hexCalcInstance.isLess(hexadecimalValue1, hexadecimalValue2);
						if(!islesser){
							System.out.println(hexadecimalValue1+" is greter then "+hexadecimalValue2);
						}
						else{
							System.out.println(hexadecimalValue1+" is less then to "+hexadecimalValue2);
						}
						break;
					case 10:
						break;
					default:
						System.exit(0);;
				}
			}catch(InputMismatchException inputMismatchExceptionInstance){
				System.out.println("please enter numeric value");
			}
			catch(Exception exceptionInstance){
				System.out.println("please enter valid inputs");
			}
		}while(option!=10);	
    }
}
