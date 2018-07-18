import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstComeFirstServeScheduling implements Scheduling{
	
	private int arrivalTime[];
	private int burstTime[];
	private int processNumber[]; 
	
	public  FirstComeFirstServeScheduling() throws InputMismatchException
	{
		System.out.println("Please enter number of process");
		Scanner scanner=new Scanner(System.in);
		int numberOfProcess=scanner.nextInt();
		arrivalTime=new int[numberOfProcess];
		burstTime=new int[numberOfProcess];
		processNumber=new int[numberOfProcess];
		for(int i=0;i<numberOfProcess;i++){
			processNumber[i]=i+1;
			System.out.println("Please enter arrival time of process "+processNumber[i]+":- ");
			arrivalTime[i]=scanner.nextInt();
			System.out.println("Please enter burst time of process "+processNumber[i]+":- ");
			burstTime[i]=scanner.nextInt();
		}
	}
	
	public int getTotalNumberOfProcess() {
		return processNumber.length;
	}
	
	/**
	 * This method sort process according to their arrival time 
	 * @param numberOfProcess is total number of process
	 * @return no value return
	 */
	@Override
	public void sortProcess(int numberOfProcess)
	{
		for(int i=0;i<numberOfProcess;i++){
			for(int j=1;j<numberOfProcess-(i+1);j++){
				if(arrivalTime[j]>arrivalTime[j+1]){
					int temp;
					temp=arrivalTime[j];
					arrivalTime[j]=arrivalTime[j+1];
					arrivalTime[j+1]=temp;
					
					temp=burstTime[j];
					burstTime[j]=burstTime[j+1];
					burstTime[j+1]=temp;
				}
			}
		}	
	}
	
	@Override
	public int calculateCompletionTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		sortProcess(processNumber.length);
		if(arrivalTime[processNumberValue-1]==0 && processNumberValue==processNumber[0]){
			return burstTime[processNumberValue-1];
		}
		else if(processNumberValue==processNumber[0]){
			return arrivalTime[processNumberValue-1]+burstTime[processNumberValue-1];
		}
		else{
			if(arrivalTime[processNumberValue-1]>calculateCompletionTime(processNumberValue-1)){
				return (arrivalTime[processNumberValue-1]+burstTime[processNumberValue-1]);
			}
			else{
				return (calculateCompletionTime(processNumberValue-1)+burstTime[processNumberValue-1]);
			}	
		}
	}
	
	@Override
	public int calculateWaitingTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		//waiting time=turn around time - burst time
		return (calculateTurnAroundTime(processNumberValue)-burstTime[processNumberValue-1]);
	}
	
    @Override
	public int calculateTurnAroundTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		//turn around time = completion time - arrival time
		return (calculateCompletionTime(processNumberValue)-arrivalTime[processNumberValue-1]);
	}
	
	@Override
	public double calculateAverageWaitingTime(){
		double totalWaitingTime=0;
		for(int i=0;i<processNumber.length;){
			totalWaitingTime+=calculateWaitingTime(++i);
		}
		return totalWaitingTime/processNumber.length;
	}
	
	@Override
	public int calculateMaxWaitingTime(){
	
		int waitingTime[]=new int[processNumber.length];
		for(int i=0;i<processNumber.length;){
			waitingTime[i]=calculateWaitingTime(++i);
		}
		int max=getMax(waitingTime);
		return max;
	}
	
	public int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
}
