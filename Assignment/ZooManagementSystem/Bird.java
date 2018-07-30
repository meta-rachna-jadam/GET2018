public class Bird extends Animal{

	private final boolean isAbleToFly;
	private String wingsColor;
	
	public Bird(String name, double weight, int age, int numberOfLegs, 
			boolean isAbleToFly, String wingsColor, AnimalName animalType) {
		
		super(name, weight, age, numberOfLegs, AnimalFamily.BIRD, animalType);
		
		this.isAbleToFly = isAbleToFly;
		this.wingsColor = wingsColor;
	}	
	
	public String getWingsColor() {
		return this.wingsColor;
	}

	public void setWingsSpan(String wingsColor) {
		this.wingsColor = wingsColor;
	}

	public boolean isAbleToFly() {
		return isAbleToFly;
	}

}
