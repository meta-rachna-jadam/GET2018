
import java.util.ArrayList;
import java.util.List;

/**
 * Implement class Match such that-
 * A cricket team is playing against Virat Kohli and we want him to score as
 * low as possible. Virat scores max runs of the bowler who has minimum balls
 * left to bowl.
 * 
 * @author Rachna Jadam 
 */
public class Match {
	private int totalBowl;
	private List<Bowler> bowlers = new ArrayList<Bowler>();

	/**
	 * To add bowler's
	 * @param bowl
	 * @param name
	 * @throws AssertionError when we try to insert bowler with null name or zero bowls
	 */
	public void addBowler(int bowl, String name) throws AssertionError {
		bowlers.add(new Bowler(bowl, name));
	}

	/**
	 * To calculate total bowl 
	 */
	public void totalBowl() {
		for (Bowler bowler : bowlers) {
			totalBowl += bowler.getBowl();
		}
	}

	/**
	 * To make virat score as low as possible
	 * @return Bowler's order such that virat score's minimum
	 * @throws AssertionError when we try to insert bowler with null name or zero bowls
	 */
	public List<Bowler> viratMinimumRun() throws AssertionError {
		List<Bowler> bowlerOrder = new ArrayList<Bowler>();
		while (totalBowl != 0) {

			//provide index in list of bowlers which has maximum balls
			int bolwerIndex = getMaxBowlBolwer();
			String bowler = bowlers.get(bolwerIndex).getBowler();
			int orderSize = bowlerOrder.size();
			if (orderSize == 0 || !bowler.equals(bowlerOrder.get(orderSize - 1).getBowler())) {
				bowlerOrder.add(new Bowler(1, bowler));
			} else {
				bowlerOrder.get(bowlerOrder.size() - 1).setBowl(
						bowlerOrder.get(bowlerOrder.size() - 1).getBowl() + 1);
			}
			bowlers.get(bolwerIndex).setBowl(
					bowlers.get(bolwerIndex).getBowl() - 1);
			totalBowl--;
		}
		return bowlerOrder;
	}

	/**
	 * To get the index of bowler which have maximum balls
	 * @return index of bowler in list bowler's
	 */
	private int getMaxBowlBolwer() {
		int numberOfBowlers = bowlers.size();
		int maxBowls = bowlers.get(0).getBowl();
		int indexOfBowlerHasMaxBall = 0;
		for (int index = 0; index < numberOfBowlers; index++) {
			if (bowlers.get(index).getBowl() > maxBowls) {
				maxBowls = bowlers.get(index).getBowl();
				indexOfBowlerHasMaxBall = index;
			}
		}
		return indexOfBowlerHasMaxBall;
	}
}
