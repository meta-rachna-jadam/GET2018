import java.util.InputMismatchException;

/*
 * This interface is use when we apply any of the scheduling algorithm 
 */
public interface Scheduling {
	public void sortProcess(int numberOfProcess) throws InputMismatchException;
	public int calculateCompletionTime(int processIdValue) throws ArrayIndexOutOfBoundsException;
	public int calculateWaitingTime(int processIdValue) throws ArrayIndexOutOfBoundsException;
	public int calculateTurnAroundTime(int processIdValue) throws ArrayIndexOutOfBoundsException;
	public double calculateAverageWaitingTime();
	public int calculateMaxWaitingTime();

}
