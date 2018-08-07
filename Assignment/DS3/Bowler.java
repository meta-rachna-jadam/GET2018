/**
 * This class describe about properties of bowler
 * @author Rachna Jadam
 */
public class Bowler {
	int bowl;
	String name;
	
	public Bowler(int bowl, String name) throws AssertionError {
		if(bowl == 0) {
			throw new AssertionError("Bowler not allowed with zero bowl");
		}
		
		if(name == null) {
			throw new AssertionError("Bowler name can'nt be null");
		}
		this.bowl = bowl;
		this.name = name;
	}
	
	public void setBowl(int bowl) {
		if(bowl >= 0) {
			this.bowl = bowl;
		}
	}
	
	public int getBowl() {
		return bowl;
	}
	
	public String getBowler() {
		return name;
	}
}
