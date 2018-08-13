import java.util.LinkedList;
import java.util.List;

public class Vertex {

	private List<Neighbour> neighbours = new LinkedList<Neighbour>();
	
	Vertex(){
}
	
	/**
	 * Add neighbor vertex with their edge weight
	 * @param vertex      neighbor vertex
	 * @param edgeWeight  edge weight of neighbor vertex
	 */
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}
	
	/**
	 * 
	 * @return - List of neighbors
	 */
	public List<Neighbour> getNeighbourList(){
		return this.neighbours;
	}
}