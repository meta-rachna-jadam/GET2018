import java.util.Arrays;

public final class IntSet {
	
    private int set[];
    public IntSet(int arraySize){
    	set = new int[1000];
    }
    public IntSet(int setArray[]) {
        set = setArray;
    }
    public boolean isMember(int x){
        for(int index = 0; index < set.length; index++){
            if(set[index] == x){
        	    return true;
        	}
        }
        return false;
    }
    
    public int size() {
        return set.length;
    }
    
    public boolean isSubSet(IntSet s) {
        int setIndex,subSetIndex;
        for(subSetIndex = 0; subSetIndex < s.set.length; subSetIndex++){
            for(setIndex = 0; setIndex < this.set.length; setIndex++){
                if(s.set[subSetIndex] == this.set[setIndex]){
                    break;
                }
            }
            if(setIndex == this.set.length){
                return false;
            }
        }
        return true;
    }
   
    public IntSet getComplement(){
        IntSet returnSet = new IntSet(1000 - this.set.length);
        int setIndex;
        int value;
        int index = 0;
        for(value = 1; value <=1000; value++){
            for(setIndex = 0; setIndex < this.set.length; setIndex++){
                if(value == this.set[setIndex]){
                    break;
                }
            }
            if(setIndex == this.set.length){
                returnSet.set[index] = value;
                index++;
            }
        }
        return returnSet;
    }
    
    public IntSet union(IntSet s1, IntSet s2){
    	Arrays.sort(s1.set);
    	Arrays.sort(s2.set);
    	int setOneIndex;
    	int setTwoIndex;
    	int index = 0;
    	IntSet returnSet = new IntSet(s1.set.length + s2.set.length);
        for(setOneIndex = 0, setTwoIndex = 0; setOneIndex < s1.set.length && setTwoIndex < s2.set.length ; ){
            if(s1.set[setOneIndex] < s2.set[setTwoIndex]){
        	    returnSet.set[index] = s1.set[setOneIndex];
        	    index++;
        	    setOneIndex++;
            }
            else if(s1.set[setOneIndex] > s2.set[setTwoIndex]){
        	    returnSet.set[index] = s2.set[setTwoIndex];
        	    index++;
        	    setTwoIndex++;
            }
            else{
        	    returnSet.set[index] = s1.set[setOneIndex];
        	    index++;
        	    setOneIndex++;
        	    setTwoIndex++;
            }
        }
        while(setOneIndex < s1.set.length){
            returnSet.set[index] = s1.set[setOneIndex];
            index++;
            setOneIndex++;
        }
        while(setTwoIndex < s2.set.length){
            returnSet.set[index] = s2.set[setTwoIndex];
            index++;
            setTwoIndex++;
        }
        return returnSet;
    }
}
