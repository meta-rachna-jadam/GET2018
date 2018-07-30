public class Mammal extends Animal{
	
	private final boolean hasFurs;
	
	public Mammal(String name, double weight, int age, int numberOfLegs, 
			 boolean hasFurs, AnimalName animalType) {
		
		super(name, weight, age, numberOfLegs, AnimalFamily.MAMMAL, animalType);
		
		this.hasFurs = hasFurs;
	}

	public boolean isHasFurs() {
		return hasFurs;
	}
}
