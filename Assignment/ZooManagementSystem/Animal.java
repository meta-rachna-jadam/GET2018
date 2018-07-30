public class Animal {

	private static int temporaryId = 0;
	private int id;
	private final String name;
	private double weight;
	private int age;
	private final int numberOfLegs;
	private final AnimalFamily category;
	private final AnimalName animalType;
	private int animalCountInZoo = 0;
	
	public Animal (String name, double weight, int age, int numberOfLegs, AnimalFamily category, AnimalName animalType)
	{
		this.id = ++temporaryId;
		animalCountInZoo++;
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.numberOfLegs = numberOfLegs;
		this.category = category;
		this.animalType = animalType;
	}
	
	public int getId(){
	    return this.id;
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
        return "\nName: "+name+
        		"\nAnimal category: "+category+
                "\n Type: "+animalType+
                "\nWeight: "+weight+
                "\nAge: "+age+
                "\nNumber of legs: "+numberOfLegs;
    }
    
    public boolean removeAnimal(){
        if(animalCountInZoo == 0){
            return false;
        }
        else {
		    animalCountInZoo--;
		    return true;
        }
    }
}
