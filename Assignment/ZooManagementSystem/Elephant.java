public class Elephant extends Mammal{

	private static int id = 1;
	
	public Elephant(double weight, int age) {
		super("Elephant" + (id++), weight, age, 4, false, AnimalName.ELEPHANT);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		return  "Trumpet";
	}

}
