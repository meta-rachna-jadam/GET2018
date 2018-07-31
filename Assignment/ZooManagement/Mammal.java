/**
 * Mammals is use to add mammals in zoo
 * @author Rachna Jadam
 */
public class Mammal extends Animal{
    private final boolean hasFurs;
	
    /**
     * This intializes the Mammals properties 
     * @param name              Name of the mammal
     * @param weight            Weight of the mammal
     * @param age               Age of the mammal
     * @param numberOfLegs      Numbers of legs of mammal
     * @param hasFurs           True if mammal has furs, otherwise false
     * @param animalType        Type of mammal in zoo
     */
    public Mammal(String name, double weight, int age, int numberOfLegs,
            boolean hasFurs, AnimalName animalType) {
        super(name, weight, age, numberOfLegs, AnimalFamily.MAMMAL, animalType);
        this.hasFurs = hasFurs;
    }

    public boolean isHasFurs() {
        return hasFurs;
    }
}
