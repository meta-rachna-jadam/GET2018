
public class Bowler implements Comparable<Bowler> {
    
	private int ball;
	private String name;
	
	public Bowler(int ball, String name) throws AssertionError {
		if(ball == 0) {
			throw new AssertionError("Bowler not allowed with zero bowl");
		}
		
		if(name == null) {
			throw new AssertionError("Bowler name can'nt be null");
		}
		this.ball = ball;
		this.name = name;
	}
	
	public void setBalls(int ball) {
		if(ball >= 0) {
			this.ball = ball;
		}
	}
	
	public int getBalls() {
		return ball;
	}
	
	public String getBowler() {
		return name;
	}

	@Override
	public int compareTo(Bowler bowler) {
		return (bowler.ball - this.ball);
	}
}
