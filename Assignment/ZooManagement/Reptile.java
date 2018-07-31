/**
 * Reptile is use to add Reptile animals in Zoo
 * @author Rachna Jadam
 */
public class Reptile extends Animal{
    private final boolean isPoisonous;
    private final String bloodType;
	
    /**
     * This initializes the Reptile properties 
     * @param name               Name of the reptile
     * @param weight             Weight of the reptile
     * @param age                Age is the reptile
     * @param numberOfLegs       Number of legs of reptile
     * @param isPoisonous        true if reptile is Poisonous, otherwise false 
     * @param bloodType          cold or warm blooded
     * @param animlType          Type of the reptile
     */
    public Reptile(String name, double weight, int age, int numberOfLegs,
            boolean isPoisonous, String bloodType, AnimalName animlType) {
        super(name, weight, age, numberOfLegs, AnimalFamily.REPTILE, animlType);
        this.isPoisonous = isPoisonous;
        this.bloodType = bloodType;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public String getBloodType() {
        return bloodType;
    }
}
