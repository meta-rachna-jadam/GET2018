/**
 * The Animal class is use to represent general properties of animal
 * @author Rachna jadam
 */
public class Animal {
	private static int tempId = 0;
	private int id;
    private final String name;
    private double weight;
    private int age;
    private final int numberOfLegs;
    private final AnimalFamily category;
    private final AnimalName animalType;
	
    /**
     * This constructor initializes the animal via multiple properties
     * @param name             Name of the animal. It should be unique
     * @param weight           Weight of animal in kilograms
     * @param age              Age of animal in years
     * @param numberOfLegs     Number of legs of animal
     * @param category         Category of animal on the basis of their properties
     * @param animalType       Type of animal, like Lion
     */
    public Animal (String name, double weight, int age, int numberOfLegs, AnimalFamily category, AnimalName animalType)
    {
    	this.id = ++tempId;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.numberOfLegs = numberOfLegs;
        this.category = category;
        this.animalType = animalType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public AnimalName getAnimalType() {
        return animalType;
    }

    public AnimalFamily getCategory() {
        return category;
    }
	
    public String getInfo(){
        return "Id: "+id+
                "\nName: "+name+
                "\nCategory: "+category+
                "\nType: "+animalType+
                "\nWeight: "+weight+
                "\nAge: "+age+
                "\nNumber of legs: "+numberOfLegs;
    }
}
