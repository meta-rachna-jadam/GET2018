/**
 * Parrot is use to add Parrot
 * @author Rachna Jadam
 */
public class Parrot extends Bird{
    static int id = 1;
	
    /**
     * This intializes Parrot and calls its super to add it into Bird
     * @param weight      weight of the parrot in kg
     * @param age         age of the parrot 
     * @param wingsColor  wings color of the parrot
     */
    public Parrot(double weight, int age, String wingsColor) {	
        super("Parrot" + (id++), weight, age, 2, true, wingsColor, AnimalName.PARROT);
    }
}
