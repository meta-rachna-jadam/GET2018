
public class Parrot extends Bird{

	static int id = 1;
	
	public Parrot(double weight, int age, String wingsColor) {
		
		super("Parrot" + (id++), weight, age, 2, true, wingsColor, AnimalName.PARROT);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		return "Squawk";
	}

}
