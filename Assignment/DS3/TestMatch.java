import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * To test Match class method which give order or bowler's
 * so virat can perform minimum
 * @author Rachna Jadam
 * Creation Date: 7/8/2018
 */
public class TestMatch {

	Match match = null;
	
	@Before
	public void Initialize() {
		match = new Match();
		match.addBowler(8, "Rachna");
		match.addBowler(3, "yash");
		match.addBowler(1, "rajat");
	}
	
	@Test
	public void testOneViratMinimumRunItReturnListOfBowlersInOrderInWhichTheyBowl() {
		match.totalBowl();
		List<Bowler> names = match.viratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(6, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "rajat"));
		for(int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBowl(), result.get(i).getBowl());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test
	public void testTwoViratMinimumRunItReturnListOfBowlersInOrderInWhichTheyBowl() {
		match.addBowler(4, "Raj");
		match.totalBowl();
		List<Bowler> names = match.viratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(5, "Rachna"));
		result.add(new Bowler(1, "Raj"));
		result.add(new Bowler(1, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "Raj"));
		result.add(new Bowler(1, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "Raj"));
		result.add(new Bowler(1, "Rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "rajat"));
		result.add(new Bowler(1, "Raj"));
		for(int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBowl(), result.get(i).getBowl());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}
	
	@Test (expected = AssertionError.class)
	public void testAddBowlerWithZeroBall() {
		match.addBowler(0, "rajat");
	}
	
	@Test (expected = AssertionError.class)
	public void addBowlerWithNullNameException() {
		match.addBowler(1, null);
	}
}
