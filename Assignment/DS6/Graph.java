import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * This is use to create graph and perform different operation on graph 
 * @author Rachna Jadam
 *
 */
public class Graph implements UndirectedWeightGraph{

	private int totalVertex;
	private Vertex vertices[];
	private List<Edge> edgeList = new LinkedList<Edge>();
	
	public Graph(int totalVertex) {
	    this.totalVertex = totalVertex;
	    this.vertices = new Vertex[this.totalVertex];
		for(int index = 0; index < this.totalVertex; index++) {
			this.vertices[i] = new Vertex();
		}
	    
	}
	
	/**
	 * pair class for shortest path method
	 * @author Rachna Jadam
	 *
	 */
	class Pair{
		private int weight;
		private int vertex;
		
		Pair(int weight, int vertex){
			this.weight = weight;
			this.vertex = vertex;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public int getVertex() {
			return  this.vertex;
		}
	}
	
	/**
	 * Comparator for Sort By edge weight
	 * @author Rachna Jadam
	 *
	 */
	class sortPairByWeight implements Comparator<Pair>{

		public int compare(Pair pair1, Pair pair2) {
			return pair1.getWeight() - pair2.getWeight();
		}
		
	}
	
	/**
	 * Comparator for Sort By edge weight
	 * @author Rachna Jadam
	 *
	 */
	class sortEdgeByWeight implements Comparator<Edge>{

		public int compare(Edge edge1, Edge edge2) {
			return edge1.getEdgeWeight() - edge2.getEdgeWeight();
		}
		
	}
	
	/**
	 * This method add neighbor to vertex
	 * @param source        source
	 * @param destination   Neighbor vertex
	 * @param edgeWeight    Edge weight of vertex1 and vertex2
	 */
	public void addVertices(int source, int destination, int edgeWeight) {
		this.edgeList.add(new Edge(source, destination, edgeWeight));
		this.vertices[source].addNeighbour(destination, edgeWeight);
		this.vertices[destination].addNeighbour(source, edgeWeight);
	}
	
	/**
	 * depth First Search of graph
	 * @param source     Source vertex
	 * @return           List of visited vertices
	 */
	private Set<Integer> depthFirstSearch(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visitedVertex = new HashSet<Integer>();
		stack.push(source);
		int vertex;
		while(!stack.isEmpty()) {
			vertex = stack.pop();
			if(visitedVertex.contains(vertex)) {
				continue;
			}
			visitedVertex.add(vertex);
			for(Neighbour neighbour : this.vertices[vertex].getNeighbourList()) {
				stack.push(neighbour.getNeighbourVertex());
			}
		}
		return visitedVertex;
	}

	/**
	 * Check whether graph is connected or not
	 * @return   true if graph is connected, otherwise false
	 */
	public boolean isConnected() {
		return this.depthFirstSearch(0).size() == this.totalVertex;
	}

	/**
	 * Find all vertices which are reachable from given vertex
	 * @param vertex     vertex of a graph
	 * @return           List of reachable vertices from given vertex
	 */
	public int[] reachable(int vertex) {
		Set<Integer> visitedVertex = this.depthFirstSearch(vertex);
		int reachableList[] = new int[visitedVertex.size()];
		Iterator iterator = visitedVertex.iterator();
		int index = 0;
		while(iterator.hasNext()) {
			reachableList[index] = (Integer)iterator.next();
			index ++;
		}
		Arrays.sort(reachableList);
		return reachableList;
	}
	
	/**
	 * Find root of vertex in union-find set
	 * @param rootOf     Hash map of vertex with their roots
	 * @param vertex     vertex 
	 * @return           root of vertex
	 */
	private int root(HashMap<Integer, Integer> rootOf, int vertex) {
		while(rootOf.get(vertex) != vertex) {
			vertex = rootOf.get(vertex);
		}
		return vertex;
	}
	
	/**
	 * Check whether given vertex makes cycle or not
	 * @param rootOf        Hash map of vertex with their roots
	 * @param source        source 
	 * @param destination   destination
	 * @return              true if cycle present otherwise false
	 */
	private boolean isCycle(HashMap<Integer, Integer> rootOf, int source, int destination) {
		int root1 = root(rootOf, source);
		int root2 = root(rootOf, destination);
		if(root1 == root2) {
			return true;
		}
		rootOf.put(root1, root2);
		return false;
	}

	/**
	 * Get Minimum Spanning tree using kruskal algorithm
	 * @return   Spanning tree with vertices and weight
	 */
	public int[][] getMinimumSpanningTree() {
		Collections.sort(this.edgeList, new sortEdgeByWeight());
		int minimumSoanningTree[][] = new int[this.totalVertex-1][3];
		HashMap<Integer, Integer> rootOf = new HashMap<Integer, Integer>();
		for(int index = 0; index < this.totalVertex; index++) {
			rootOf.put(index, index);
		}
		int index = 0;
		for(Edge edge:this.edgeList) {
			if(index >= this.totalVertex-1) {
				break;
			}
			if(!isCycle(rootOf, edge.getSource(), edge.getDestination())) {
				minimumSoanningTree[index][0] = edge.getSource();
				minimumSoanningTree[index][1] = edge.getDestination();
				minimumSoanningTree[index][2] = edge.getEdgeWeight();
				index ++;
			}
		}
		return minimumSoanningTree;
	}

	/**
	 * Dijkstra algorithm implementation
	 * @param source    Source vertex
	 * @return          Distance of all vertices from source
	 */
	private int[] dijkstra(int source) {
		int distance[] = new int[this.totalVertex];
		for(int index = 0; index < this.totalVertex; index++) {
			distance[index] = Integer.MAX_VALUE;
		}
		Set<Integer> visited = new HashSet<Integer>();
		distance[source] = 0;
		PriorityQueue<Pair> priorityQueueInstance = new PriorityQueue<Pair>(this.totalVertex, new sortPairByWeight());
		priorityQueueInstance.add(new Pair(0, source));
		while(!priorityQueueInstance.isEmpty()) {
			Pair pair = priorityQueueInstance.peek();
			priorityQueueInstance.remove();
			if(visited.contains(pair.getVertex())) {
				continue;
			}
			visited.add(pair.getVertex());
			for(Neighbour neighbour : this.vertices[pair.getVertex()].getNeighbourList()) {
				if(distance[neighbour.getNeighbourVertex()] > distance[pair.getVertex()] + neighbour.getEdgeWeight()) {
					distance[neighbour.getNeighbourVertex()] = distance[pair.getVertex()] + neighbour.getEdgeWeight();
					priorityQueueInstance.add(new Pair(distance[neighbour.getNeighbourVertex()], neighbour.getNeighbourVertex()));
				}
			}
		}
		return distance;
	}
	
	/**
	 * Find shortest path distance between two vertex
	 * @param source        starting vertex
	 * @param destination   ending vertex
	 * @return              Shortest distance between source and destination
	 */
	public int shortestPath(int source, int destination) {
		int distance[] = this.dijkstra(source);
		return distance[destination];
	}
}

