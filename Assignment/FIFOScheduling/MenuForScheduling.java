import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuForScheduling {
	public static void main(String[] argList){
		Scanner scanner=new Scanner(System.in);
		int option = 0;
		FirstComeFirstServeScheduling FIFOSheduling1 = null;
		try{
			FIFOSheduling1=new FirstComeFirstServeScheduling();
			do{
		        int totalNumberOfProcess=FIFOSheduling1.getTotalNumberOfProcess();
				System.out.println("\n\nChoose any one option\n");
				System.out.println("Press 1 to calculate completion time");
				System.out.println("Press 2 to calculate waiting time");
				System.out.println("Press 3 to calculate turn around time");
				System.out.println("Press 4 to calculate average waiting time");
				System.out.println("Press 5 to calculate maximum waiting time");
				System.out.println("Press 6 to exit program\n");
				option=scanner.nextInt();
				int processNumber;
				switch (option) {
					case 1:
						System.out.println("Enter process number for which you want to calculate compliton time (1-"+totalNumberOfProcess+")");
						processNumber=scanner.nextInt();
						if(processNumber>0 && processNumber<=totalNumberOfProcess){
							System.out.println("Completion Time of process "+processNumber+" is "+FIFOSheduling1.calculateCompletionTime(processNumber));
						}
						else{
							System.out.println("Process number should be in its given range");
						}
						break;
					case 2:
						System.out.println("Enter process number for which you want to calculate waiting time (1-"+totalNumberOfProcess+")");
						processNumber=scanner.nextInt();
						if(processNumber>0 && processNumber<=totalNumberOfProcess){
							System.out.println("Waiting Time of process "+processNumber+" is "+FIFOSheduling1.calculateWaitingTime(processNumber));
						}
						else{
							System.out.println("Process number should be in its given range");
						}
						break;
					case 3:
						System.out.println("Enter process number for which you want to calculate turn around time (1-"+totalNumberOfProcess+")");
						processNumber=scanner.nextInt();
						if(processNumber>0 && processNumber<=totalNumberOfProcess){
							System.out.println("Turn Around Time of process "+processNumber+" is "+FIFOSheduling1.calculateTurnAroundTime(processNumber));
						}
						else{
							System.out.println("Process number should be in its given range");
						}
						break;
					case 4:
						System.out.println("Average waiting Time  is "+FIFOSheduling1.calculateAverageWaitingTime());
						break;
					case 5:
						System.out.println("Maximum waiting Time  is "+FIFOSheduling1.calculateMaxWaitingTime());
						break;
					case 10:
						break;
					default:
						System.out.println("Please chose correct option");
						break;
				}
			}while(option!=10);
		}catch (NumberFormatException numberFormatExceptionInstance) {
			System.out.println("Please enter numeric value");
		}
		catch (InputMismatchException inputMismatchExceptionInstance) {
			System.out.println("Please enter numeric value");
		}
		catch(Exception ex){
			System.out.println("please enter valid inputs");
		}
	}
}
