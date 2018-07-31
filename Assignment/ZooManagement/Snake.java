/**
 * Snake is use to add Snake
 * @author Rachna Jadam
 */
public class Snake extends Reptile{
    static int id = 1;
	
    /**
     * This initializes Snake and calls its super to add it into Reptile
     * @param weight
     * @param age
     */
    public Snake(double weight, int age) {
        super("Snake" + (id++), weight, age, 0, true, "cold", AnimalName.SNAKE);
    }
}
