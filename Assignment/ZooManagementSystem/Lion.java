
public class Lion extends Mammal{

private static int id = 1;
	
	public Lion(double weight, int age) {
		super("Lion" + (id++), weight, age, 4, false, AnimalName.LION);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		return "Roar";
	}

}
