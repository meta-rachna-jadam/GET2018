/**
 * This Bird class represent all bird type animals
 * @author Rachna Jadam
 */
public class Bird extends Animal{
    private final boolean isAbleToFly;
    private String wingsColor;
	
    /**
     * The constructor initializes the Birds in the Zoo 
     * @param name               Name of the bird
     * @param weight             Weight of the bird
     * @param age                Age of the bird
     * @param numberOfLegs       Number of legs of bird
     * @param isAbleToFly        true if bird can fly, otherwise false
     * @param wingsColor         Wings color of bird  
     * @param animalType         Type of bird
     */
    public Bird(String name, double weight, int age, int numberOfLegs,
            boolean isAbleToFly, String wingsColor, AnimalName animalType) {
        super(name, weight, age, numberOfLegs, AnimalFamily.BIRD, animalType);
        this.isAbleToFly = isAbleToFly;
        this.wingsColor = wingsColor;
    }	
	
    public String getWingsColor() {
        return wingsColor;
    }

    public void setWingsColor(String wingsColor) {
        this.wingsColor = wingsColor;
    }

    public boolean isAbleToFly() {
        return isAbleToFly;
    }
}
