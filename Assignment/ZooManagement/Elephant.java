/**
 * Elephant is use to add Elephant
 * @author Rachna Jadam
 */
public class Elephant extends Mammal{
    private static int id = 1;
	
    /**
     * This constructor initializes the Elephant properties and calls its super to add it into Mammal
     * @param weight
     * @param age
     */
    public Elephant(double weight, int age) {
        super("Elephant" + (id++), weight, age, 4, false, AnimalName.ELEPHANT);
    }
}
