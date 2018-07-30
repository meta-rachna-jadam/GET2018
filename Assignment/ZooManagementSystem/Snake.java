public class Snake extends Reptile{

	static int id = 1;
	
	public Snake(double weight, int age) {
		
		super("Snake" + (id++), weight, age, 0, true, "cold", AnimalName.SNAKE);
		// TODO Auto-generated constructor stub
	}

	public String getSound(){
		return "Hiss";
	}
}
