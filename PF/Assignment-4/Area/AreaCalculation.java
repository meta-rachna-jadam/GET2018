import java.util.InputMismatchException;
import java.util.Scanner;


public class AreaCalculation {
	public static void main(String arguments[]){
		Scanner scannerInstance = new Scanner(System.in);
		Area areaInstance = new Area();
		int option = 0;
		double width = 0;
		double height = 0;
		double radius;
		do{
			try{
				System.out.println("Press 1 to calculate area of Triangle");
				System.out.println("Press 2 to calculate area of rectangle");
				System.out.println("Press 3 to calculate area of square");
				System.out.println("Press 4 to calculate area of circle");
				System.out.println("Press 5 to exit program");
				System.out.println("Please Choose any one option:-");
				option = scannerInstance.nextInt();
				switch (option) {
					case 1:
						System.out.println("Please Enter base of triangle: ");
						width = scannerInstance.nextInt();
						System.out.println("Please Enter height of triangle: ");
						height = scannerInstance.nextInt();
						System.out.println("Area of triangle is "+areaInstance.areaOfTriangle(width, height));					
						break;
					case 2:
						System.out.println("Please Enter width of rectangle: ");
						width = scannerInstance.nextInt();
						System.out.println("Please Enter height of rectangle: ");
						height = scannerInstance.nextInt();
						System.out.println("Area of rectangle is "+areaInstance.areaOfRectangle(width, height));					
						break;
					case 3:
						System.out.println("Please Enter width of square: ");
						width = scannerInstance.nextInt();
						System.out.println("Area of square is "+areaInstance.areaOfSquare(width));					
						break;
					case 4:
						System.out.println("Please Enter radius of circle: ");
						radius = scannerInstance.nextInt();
						System.out.println("Area of circle is "+areaInstance.areaOfCircle(radius));					
						break;
					case 5:
						break;
					default:
						throw new IllegalArgumentException();
				}
			}catch(ArithmeticException arithmeticExceptionInstance){
				System.out.println("Enter positive values");
				break;
			}
			catch(IllegalArgumentException illegalArgumentExceptionInstance){
				System.out.println("Choose correct option");
				break;
			}
			catch (InputMismatchException inputMismatchExceptionInstance) {
				System.out.println("Please enter numeric value");
				break;
			}
			catch (Exception exceptionInstance) {
				System.out.println("Try Again!!");
				break;
			}
			
		}while(option != 5);
	}
}
