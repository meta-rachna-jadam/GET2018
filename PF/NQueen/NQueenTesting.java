import static org.junit.Assert.*;

import org.junit.Test;


public class NQueenTesting {

	@Test
	public void test() {
		NQueen nQueenInstance = new NQueen();
		int[][] board = nQueenInstance.solveNQueen(4);
		assertArrayEquals(new int[][]{{0,0,1,0},{1,0,0,0},{0,0,0,1},{0,1,0,0}}, board);
	}
	@Test
	public void test1() {
		NQueen nQueenInstance = new NQueen();
		int[][] board = nQueenInstance.solveNQueen(3);
		assertArrayEquals(null, board);
	}

}
