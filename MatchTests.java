import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MatchTests {

Match match = null;
	
	@Before
	public void Initialize() throws AssertionError {
		match = new Match();
		match.addBowler(8, "rachna");
		match.addBowler(3, "yash");
		match.addBowler(1, "sonu");
	}
	
	@Test
	public void testViratMinimumRunItReturnListOfBowlersInOrderInWhichTheyBowl() throws AssertionError {
		
		
		match.totalBowl();
		List<Bowler> names = match.viratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(5, "rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "rachna"));
		result.add(new Bowler(1, "yash"));
		result.add(new Bowler(1, "rachna"));
		result.add(new Bowler(1, "sonu"));
		for(int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBalls(), result.get(i).getBalls());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test (expected = AssertionError.class)
	public void testAddBowlerWithZeroBall() {
		match.addBowler(0, "sonu");
	}
	
	@Test (expected = AssertionError.class)
	public void testAddBowlerWithNullName() throws AssertionError {
		match.addBowler(10, null);
	}
}
