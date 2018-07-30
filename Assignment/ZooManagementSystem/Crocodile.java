public class Crocodile extends Reptile{

	static int id = 1;
	
	public Crocodile(double weight, int age) {
		
		super("Crocodile" + (id++), weight, age, 4, false, "warm", AnimalName.CROCODILE);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		return "Hiss";
	}

}
