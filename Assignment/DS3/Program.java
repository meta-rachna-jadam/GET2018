/**
 * This class is use to store program available in a college with maximum seats
 * of each program
 * 
 * @author Rachna Jadam
 *
 */
public class Program {
	private final ProgramTypes name;
	private final int maximumSeats;

	public Program(ProgramTypes name, int maximumSeets) {
		this.name = name;
		this.maximumSeats = maximumSeets;
	}

	public ProgramTypes getName() {
		return name;
	}

	public int getMaximumSeats() {
		return maximumSeats;
	}
}
