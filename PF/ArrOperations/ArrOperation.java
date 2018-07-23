
public class ArrOperation {
	
    /**
     * It calculate number of clump, Clump in an array is a series of 2 or more adjacent elements of the same value.
     * @param array is an integer array
     * @return number of clump in input array
     */
    public int checkNumberOfClump(int array[]){
        int countClump = 0;
        boolean isAppearFirstTime = true;
        for(int index = 0; index < array.length-1; index++){
            if(isAppearFirstTime && (array[index] == array[index+1])){
                isAppearFirstTime = false;
                countClump++;
            }
            else if(array[index] != array[index+1]){
                isAppearFirstTime = true;
            }
        }
        return countClump;
    }

    /**
     * It convert an array into another array in which X is immediately followed by a Y. Without move X within array, but every other number may move.
     * @param inputArray integer array
     * @param x position of x is never change
     * @param x position of is immediately followed by y
     * @return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y
     * @throws AssertionError If array is empty or there are unequal numbers of X and Y in input array or two adjacents X values are there or 
     * X occurs at the last index of array.
     */
    public int[] fixXy(int[] inputArray, int x, int y) throws AssertionError{
        if(inputArray.length == 0){
    	    throw new AssertionError("Array is empty");
        }
        else if(inputArray[inputArray.length-1] == x) {
	        throw new AssertionError("Not possible because  X occurs at the last index of array");
	    }
        else if(!isNumberOfXYEqual(inputArray, x, y)) {
            throw new AssertionError("Not possible besause there are unequal numbers of X and Y in input array");
	    }
        else{
            int[] outputArray = inputArray;
            int indexOfY;
            for(int index = 0; index < outputArray.length; index++)
            {
                if(outputArray[index] == x){
                    index++;
                    if(outputArray[index] == x){
                        throw new AssertionError("Not possible because two adjacents X values present in array");
                    }
                    else if(outputArray[index] == y){
                        continue;
                    }
                    else {
					    indexOfY = findIndexOfY(inputArray,x,y);
					    if(indexOfY == -1){
					        throw new AssertionError("Not possible besause there are unequal numbers of X and Y in input array");
					    }
					    else{
					        int temp;
					        temp = outputArray[index];
					        outputArray[index] = outputArray[indexOfY];
					        outputArray[indexOfY] = temp;
					    }
				    }
                }
            }
            return outputArray;
        }
    }
    
    private int findIndexOfY(int[] inputArray, int x, int y){
        int indexOfY = -1;
        for(int index = 0; index < inputArray.length; index++){
            if(inputArray[index] == y){
                if(index == 0){
                    indexOfY = 0;
                    break;
                }
                else if(inputArray[index-1] != x){
                    indexOfY = index;
                    break;
                }
            }
        }
        return indexOfY;
    }
    
    private boolean isNumberOfXYEqual(int[] inputArray,int x, int y){
        int countX = 0;
        int countY = 0;
        for(int index = 0; index < inputArray.length; index++){
            if(inputArray[index] == x){
                countX++;
            }
            else if(inputArray[index] == y){
                countY++;
            }
            else{
                continue;
            }
        }
        if(countX == countY){
            return true;
        }
        else {
		    return false;
        }
    }

    /**
     * Mirror section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order
     * @param inputArray integer array
     * @return number of mirror section available in array
     */
    public int findLargestMirrorSection(int[] inputArray){
        int largestMirrorPossible = 0;
        int temperaryLargestMirrorPossible = 0;
        int stratIndexFromStart,lastIndex;
        for(int index = 0; index < inputArray.length; index++)
        {
            for( int indexFromLast = inputArray.length-1; indexFromLast >= 0; indexFromLast--){
                stratIndexFromStart = index;
                lastIndex = indexFromLast;
                temperaryLargestMirrorPossible = 0;
                while(stratIndexFromStart < inputArray.length && lastIndex >= 0 && inputArray[stratIndexFromStart] == inputArray[lastIndex]){
                    stratIndexFromStart++;
                    lastIndex--;
                    temperaryLargestMirrorPossible++;
                }
                if(largestMirrorPossible < temperaryLargestMirrorPossible){
                    largestMirrorPossible = temperaryLargestMirrorPossible;
                } 
            }
        }
        return largestMirrorPossible;
    }

    /**
     * split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side
     * @param array integer array
     * @return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the 
     * sum of the numbers on the other side else return -1
     */
    public int getSplitIndex(int[] array){
        for(int index = 0; index < array.length; index++){
            if(calculateSum(array,0,index) == calculateSum(array, index+1,array.length-1)){
                return index+1;
            }
        }
        return -1;
    }
    
    private int calculateSum(int array[], int startIndex, int endIndex){
        int sum=0;
        for(int index = startIndex; index <= endIndex; index++){
            sum +=  array[index];
        }
        return sum;
    }
}
