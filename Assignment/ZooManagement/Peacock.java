/**
 * Peacock is use to add Peacock in zoo
 * @author Rachna Jadam
 */
public class Peacock extends Bird{
    static int id = 1;
	
    /**
     * This initializes Peacock 
     * @param weight
     * @param age
     * @param wingsColor
     */
    public Peacock(double weight, int age, String wingsColor) {	
        super("Peacock" + (id++), weight, age, 2, true, wingsColor, AnimalName.PEACOCK);
    }
}
