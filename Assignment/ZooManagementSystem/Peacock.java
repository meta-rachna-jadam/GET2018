public class Peacock extends Bird{

static int id = 1;
	
	public Peacock(double weight, int age, String wingsColor) {
		
		super("Peacock" + (id++), weight, age, 2, true, wingsColor, AnimalName.PEACOCK);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		return "Scream";
	}

}
