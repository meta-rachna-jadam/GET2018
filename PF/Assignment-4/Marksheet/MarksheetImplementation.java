import java.util.InputMismatchException;
import java.util.Scanner;


public class MarksheetImplementation {
	public static void main(String arguments[]){
		Scanner scannerInstance = new Scanner(System.in);
		Marksheet marksheetInstance = new Marksheet();
		int option = 0;
		String studentName;
		float studentGrade;
		do{
			try{
				System.out.println("Press 1 to add student");
				System.out.println("Press 2 to get average of grades");
				System.out.println("Press 3 to get maximum grade");
				System.out.println("Press 4 to get minimum grade");
				System.out.println("Press 5 to get percentage of pass students");
				System.out.println("Press 6 to exit program");
				System.out.println("Please Choose any one option:-");
				option = scannerInstance.nextInt();
				switch (option) {
					case 1:
						System.out.println("Please enter name of the student");
						studentName = scannerInstance.next();
						System.out.println("Please enter grade of "+studentName);
						studentGrade = scannerInstance.nextFloat();
						while(studentGrade < 0 || studentGrade > 100){
							System.out.println("Please enter grade between 0 to 100. try again");
							studentGrade = scannerInstance.nextFloat();
						}
						marksheetInstance.addStudent(new Student(studentName, studentGrade));
						break;
					case 2:
						System.out.println("Average of grade = "+marksheetInstance.averageOfGrades());			
						break;
					case 3:
						System.out.println("Maximum grade = "+marksheetInstance.getMaximumGrade());			
						break;
					case 4:
						System.out.println("Minimum grade = "+marksheetInstance.getMinimumGrade());
						break;
					case 5:
						System.out.println("Persentage of pass student = "+marksheetInstance.getPercentageOfPassStudents()+"%");
						break;
					case 6:
						break;
					default:
						throw new IllegalArgumentException();
				}
			}catch(IllegalArgumentException illegalArgumentExceptionInstance){
				System.out.println("Choose correct option");
				break;
			}
			catch (InputMismatchException inputMismatchExceptionInstance) {
				System.out.println("Please enter correct value");
				break;
			}
			catch (Exception exceptionInstance) {
				System.out.println("Try Again!!");
				break;
			}
			
		}while(option != 6);
	}
}
