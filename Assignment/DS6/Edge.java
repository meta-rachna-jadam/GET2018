/**
 * Represent edge of graph
 * @author Rachna Jadam
 *
 */
public class Edge {

	private int source;
	private int destination;
	private int edgeWeight;
	
	Edge(int source, int destination, int edgeWeight){
		this.source = source;
		this.destination = destination;
		this.edgeWeight = edgeWeight;
	}
	
	public int getSource() {
		return this.source;
	}
	
	public int getDestination() {
		return this.destination;
	}
	
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}