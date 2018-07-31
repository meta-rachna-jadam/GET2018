/**
 * Lion is use to add Lion
 * @author Rachna Jadam
 */
public class Lion extends Mammal{
private static int id = 1;
	
    /**
     * This initializes Lion 
     * @param weight    Weight of the lion
     * @param age       age of the lion
     */
    public Lion(double weight, int age) {
        super("Lion" + (id++), weight, age, 4, false, AnimalName.LION);
    }
}
