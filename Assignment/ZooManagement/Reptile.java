public class Reptile extends Animal{
	
	private final boolean isPoisonous;
	private final String bloodType;
	
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
