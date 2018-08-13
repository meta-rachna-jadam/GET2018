import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GraphTests {

	Graph graphInstanceWhichIsConnectedGraph;
	Graph graphInstanceWhichIsUnconnectedGraph;
	@Before
	public void initialization() {
		graphInstanceWhichIsConnectedGraph = new Graph(8);
		graphInstanceWhichIsConnectedGraph.addVertices(0, 1, 2);
		graphInstanceWhichIsConnectedGraph.addVertices(0, 3, 5);
		graphInstanceWhichIsConnectedGraph.addVertices(1, 2, 6);
		graphInstanceWhichIsConnectedGraph.addVertices(1, 3, 3);
		graphInstanceWhichIsConnectedGraph.addVertices(2, 3, 2);
		graphInstanceWhichIsConnectedGraph.addVertices(2, 4, 7);
		graphInstanceWhichIsConnectedGraph.addVertices(3, 4, 9);
		graphInstanceWhichIsConnectedGraph.addVertices(4, 5, 9);
		graphInstanceWhichIsConnectedGraph.addVertices(4, 6, 4);
		graphInstanceWhichIsConnectedGraph.addVertices(5, 6, 5);
		graphInstanceWhichIsConnectedGraph.addVertices(5, 7, 8);
		
		graphInstanceWhichIsUnconnectedGraph = new Graph(8);
		graphInstanceWhichIsUnconnectedGraph.addVertices(0, 1, 2);
		graphInstanceWhichIsUnconnectedGraph.addVertices(0, 3, 5);
		graphInstanceWhichIsUnconnectedGraph.addVertices(1, 2, 6);
		graphInstanceWhichIsUnconnectedGraph.addVertices(1, 3, 3);
		graphInstanceWhichIsUnconnectedGraph.addVertices(2, 3, 2);
		graphInstanceWhichIsUnconnectedGraph.addVertices(2, 4, 7);
		graphInstanceWhichIsUnconnectedGraph.addVertices(3, 4, 9);
		graphInstanceWhichIsUnconnectedGraph.addVertices(4, 5, 9);
		graphInstanceWhichIsUnconnectedGraph.addVertices(4, 6, 4);
		graphInstanceWhichIsUnconnectedGraph.addVertices(5, 6, 5);
	}
	
	@Test
	public void testGetMinimumSpanningTreeReturn2DArrayOfsourceDestinationAndWeightOfEdgeInMinimumSpaningTree() {
	    int expectedOutput[][] = {{0, 1, 2}, {2, 3, 2}, {1, 3, 3}, {4, 6, 4}, {5, 6, 5}, {2, 4, 7}, {5, 7, 8}};
	    int actualOutput[][] = graphInstanceWhichIsConnectedGraph.getMinimumSpanningTree();
	    assertArrayEquals(expectedOutput[0], actualOutput[0]);
	    assertArrayEquals(expectedOutput[1], actualOutput[1]);
	    assertArrayEquals(expectedOutput[2], actualOutput[2]);
	    assertArrayEquals(expectedOutput[3], actualOutput[3]);
	    assertArrayEquals(expectedOutput[4], actualOutput[4]);
	    assertArrayEquals(expectedOutput[5], actualOutput[5]);
	    assertArrayEquals(expectedOutput[6], actualOutput[6]);
		
	}
	
	@Test
	public void testIsConnectedReturnTrueIfGraphIsConnectedGraph() {
		assertTrue(graphInstanceWhichIsConnectedGraph.isConnected());
	}
	
	@Test
	public void testIsConnectedReturnFalseIfGraphIsNotConnectedGraph() {
		assertFalse(graphInstanceWhichIsUnconnectedGraph.isConnected());
	}
	
	@Test
	public void testReachableToFindTheReachableVerticesToASpecificVertex() {
		int expectedOutputForConnectedGraph[] = {0, 1, 2, 3, 4, 5, 6, 7};
		assertArrayEquals(expectedOutputForConnectedGraph, graphInstanceWhichIsConnectedGraph.reachable(5));
		int expectedOutputForUnconnectedGraph[] = {0, 1, 2, 3, 4, 5, 6};
		assertArrayEquals(expectedOutputForUnconnectedGraph, graphInstanceWhichIsUnconnectedGraph.reachable(5));
	}
	
	@Test
	public void testShortestPathReturnShortestDistenceBetweenSourceAndDestinationNode() {
		assertEquals(7, graphInstanceWhichIsConnectedGraph.shortestPath(0, 2));
		assertEquals(11, graphInstanceWhichIsConnectedGraph.shortestPath(6, 2));
	}

}
