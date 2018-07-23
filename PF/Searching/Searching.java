
public class Searching {
    public int linearSearch(int array[], int startIndex, int arrayLength, int valueToBeFind){
        if(startIndex >= arrayLength){
            return -1;
        }
        else{
            if(array[startIndex] == valueToBeFind){
                return startIndex;
            }
            else{
                return linearSearch(array, startIndex+1, arrayLength, valueToBeFind);
            }
        }
    }
    
    public int binarySearch(int array[], int startIndex, int lastIndex, int valueToBeFind){
        if(startIndex > lastIndex){
            return -1;
        }
        else{
            int middleIndex = (startIndex + lastIndex)/2;
            if(array[middleIndex] == valueToBeFind){
                return middleIndex;
            }
            else if(array[middleIndex] < valueToBeFind){
                return binarySearch(array, middleIndex+1, lastIndex, valueToBeFind);
            }
            else{
                return binarySearch(array, startIndex, middleIndex-1, valueToBeFind);
            }
        }
    }
}
