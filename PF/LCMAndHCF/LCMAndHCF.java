
public class LCMAndHCF {
    public int findLCM(int value1, int value2){
        if(value1 == 0){
            return value2;
        }
        else if(value2 == 0){
            return value1;
        }
        else{
           return ((value1 * value2)/findHCF(value1, value2)); 
        }
    }
    
    public int findHCF(int value1, int value2){
        if(value2 == 0){
            return value1;
        }
        else{
           return findHCF(value2, value1 % value2); 
        }
    }
}
