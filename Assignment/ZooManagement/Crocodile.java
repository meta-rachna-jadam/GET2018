/**
 * The Crocodile class is use to add reptile
 * @author Rachna Jadam
 */
public class Crocodile extends Reptile{
    static int id = 1;
	
    /**
     * It initializes the crocodile properties and calls its super to add it into Reptile
     * @param weight
     * @param age
     */
    public Crocodile(double weight, int age) {
        super("Crocodile" + (id++), weight, age, 4, false, "warm", AnimalName.CROCODILE);
	}
}
