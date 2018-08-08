import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Match {

	private int totalBowl;
	private Queue<Bowler> bowlers = new PriorityQueue<Bowler>();

	/**
	 * To add bowler's
	 * @param bowl
	 * @param name
	 * @throws MatchException
	 */
	public void addBowler(int bowl, String name) throws AssertionError {
		bowlers.add(new Bowler(bowl, name));
	}

	/**
	 * To calculate total bowl bowler's need to perform
	 */
	public void totalBowl() {
		for (Bowler bowler : bowlers) {
			totalBowl += bowler.getBalls();
		}
	}

	/**
	 * To make virat score as low as possible
	 * @return Bowler's order such that virat score's minimum
	 * @throws MatchException
	 */
	public List<Bowler> viratMinimumRun() throws AssertionError {
		List<Bowler> bowlerOrder = new ArrayList<Bowler>();
		while (totalBowl != 0) {

			Bowler bowler = bowlers.remove();
			String name = bowler.getBowler();
			int balls = bowler.getBalls();
			
			int orderSize = bowlerOrder.size();
			if (orderSize == 0 || !(name.equals(bowlerOrder.get(orderSize - 1).getBowler()))) {
				bowlerOrder.add(new Bowler(1, name));
			} else {
				bowlerOrder.get(bowlerOrder.size() - 1).setBalls(
						bowlerOrder.get(bowlerOrder.size() - 1).getBalls() + 1);
			}
			if(balls - 1 != 0) {
				bowlers.add(new Bowler(balls -1, name));
			}
			totalBowl--;
		}
		return bowlerOrder;
	}

	/**
	 * To get the index of bowler which have maximum balls
	 * @return index of bowler in list bowler's
	 *//*
	private int getMaxBowlBolwer() {
		int numberOfBowlers = bowlers.size();
		if (bowlers.size() == 0) {

		}

		int maxBowls = bowlers.get(0).getBowl();
		int index = 0;
		for (int i = 0; i < numberOfBowlers; i++) {
			int bowls = bowlers.get(i).getBowl();
			if (bowls > maxBowls) {
				maxBowls = bowls;
				index = i;
			}
		}
		return index;
	}*/
}
