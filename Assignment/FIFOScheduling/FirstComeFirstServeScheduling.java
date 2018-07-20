import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstComeFirstServeScheduling implements Scheduling{
	
	private int arrivalTimeAndBurstTime[][];
	public  FirstComeFirstServeScheduling() throws InputMismatchException
	{
		System.out.println("Please enter number of process");
		Scanner scanner=new Scanner(System.in);
		int numberOfProcess=scanner.nextInt();
		arrivalTimeAndBurstTime=new int[numberOfProcess][numberOfProcess];
		
		for(int rowIndex = 0; rowIndex < numberOfProcess; rowIndex++){
			 
			System.out.println("Please enter arrival time of process "+(rowIndex+1)+":- ");
			arrivalTimeAndBurstTime[rowIndex][0]=scanner.nextInt();
			while((rowIndex != 0) && (arrivalTimeAndBurstTime[rowIndex][0] < arrivalTimeAndBurstTime[rowIndex-1][0])) {
				System.out.println("Please enter arrival time greater then or equal to "+arrivalTimeAndBurstTime[rowIndex-1][0]+":- ");
				arrivalTimeAndBurstTime[rowIndex][0]=scanner.nextInt();
			}
			
			System.out.println("Please enter burst time of process "+(rowIndex+1)+":- ");
			arrivalTimeAndBurstTime[rowIndex][1]=scanner.nextInt();
		}
	}
	
	public int getTotalNumberOfProcess() {
		return arrivalTimeAndBurstTime.length;
	}
	
	/**
	 * This method sort process according to their arrival time 
	 * @param numberOfProcess is total number of process
	 * @return no value return
	 */
	/*@Override
	public void sortProcess(int numberOfProcess)
	{
		for(int i=0;i<numberOfProcess;i++){
			for(int j=1;j<numberOfProcess-(i+1);j++){
				if(arrivalTimeAndBurstTime[j][0]>arrivalTimeAndBurstTime[j+1][0]){
					int temp;
					temp=arrivalTimeAndBurstTime[j][0];
					arrivalTimeAndBurstTime[j][0]=arrivalTimeAndBurstTime[j+1][0];
					arrivalTimeAndBurstTime[j+1][0]=temp;
					
					temp=arrivalTimeAndBurstTime[j][1];
					arrivalTimeAndBurstTime[j][1]=arrivalTimeAndBurstTime[j+1][1];
					arrivalTimeAndBurstTime[j+1][1]=temp;
				}
			}
		}	
	}*/
	//we take sorted array on the bases of arrival time use when array is no sorted
	
	@Override
	public int calculateCompletionTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		//sortProcess(arrivalTimeAndBurstTime.length);
		//we take sorted array on the bases of arrival time use when array is no sorted
		if((arrivalTimeAndBurstTime[processNumberValue-1][0] == 0) && (processNumberValue == 1)){
			return arrivalTimeAndBurstTime[processNumberValue-1][1];
		}
		else if(processNumberValue == 1){
			return arrivalTimeAndBurstTime[processNumberValue-1][0]+arrivalTimeAndBurstTime[processNumberValue-1][1];
		}
		else{
			if(arrivalTimeAndBurstTime[processNumberValue-1][0]>calculateCompletionTime(processNumberValue-1)){
				return (arrivalTimeAndBurstTime[processNumberValue-1][0]+arrivalTimeAndBurstTime[processNumberValue-1][1]);
			}
			else{
				return (calculateCompletionTime(processNumberValue-1)+arrivalTimeAndBurstTime[processNumberValue-1][1]);
			}	
		}
	}
	
	@Override
	public int calculateWaitingTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		//waiting time=turn around time - burst time
		return (calculateTurnAroundTime(processNumberValue)-arrivalTimeAndBurstTime[processNumberValue-1][1]);
	}
	
    @Override
	public int calculateTurnAroundTime(int processNumberValue) throws ArrayIndexOutOfBoundsException{
		//turn around time = completion time - arrival time
		return (calculateCompletionTime(processNumberValue)-arrivalTimeAndBurstTime[processNumberValue-1][0]);
	}
	
	@Override
	public double calculateAverageWaitingTime(){
		double totalWaitingTime=0;
		for(int processNumber = 0; processNumber < arrivalTimeAndBurstTime.length; ){
			totalWaitingTime+=calculateWaitingTime(++processNumber);
		}
		return totalWaitingTime/arrivalTimeAndBurstTime.length;
	}
	
	@Override
	public int calculateMaxWaitingTime(){
	
		int waitingTime[]=new int[arrivalTimeAndBurstTime.length];
		for(int processNumber = 0; processNumber < arrivalTimeAndBurstTime.length;){
			waitingTime[processNumber]=calculateWaitingTime(++processNumber);
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
