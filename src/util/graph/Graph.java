package util.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Graph {

	int adjMatrix[][] = new int[20][20];
	HashMap<String, Vertex> vertexHashList = null;
	HashMap<String, LinkedList<Node>> adjacencyHashList = null;
	boolean directedGraph = false;

	// private ArrayList<String>[] x = new ArrayList<String>[10];

	public Graph(boolean directedGraph) {
		this.directedGraph = directedGraph;
		vertexHashList = new HashMap<String, Vertex>();
		adjacencyHashList = new HashMap<String, LinkedList<Node>>();
	}

	public Graph() {
		vertexHashList = new HashMap<String, Vertex>();
		adjacencyHashList = new HashMap<String, LinkedList<Node>>();
	}

	public Set<String> getVertexKeys() {
		return vertexHashList.keySet();
	}

	public Vertex getVertex(String key) {
		return vertexHashList.get(key);
	}

	public int noOfVertex() {
		return vertexHashList.keySet().size();
	}

	public LinkedList<Node> getAdjacentVertexList(String key) {
		return adjacencyHashList.get(key);
	}

	public void createGraph() {
		this.addVertex(new Vertex("a"));
		this.addVertex(new Vertex("b"));
		this.addVertex(new Vertex("c"));
		this.addVertex(new Vertex("d"));
		this.addVertex(new Vertex("e"));
		this.addVertex(new Vertex("f"));
		this.addVertex(new Vertex("g"));
		this.addVertex(new Vertex("h"));
		this.addVertex(new Vertex("i"));
		this.addVertex(new Vertex("j"));
		this.addVertex(new Vertex("k"));
		this.addVertex(new Vertex("l"));
		this.addVertex(new Vertex("m"));
		this.addVertex(new Vertex("n"));

		this.addEdge("a", "b", 1);
		this.addEdge("a", "c", 1);
		this.addEdge("a", "d", 1);
		this.addEdge("a", "e", 1);
		this.addEdge("e", "l", 1);
		this.addEdge("e", "m", 1);
		this.addEdge("e", "n", 1);
		this.addEdge("e", "d", 1);
		this.addEdge("f", "b", 1);
		this.addEdge("f", "g", 1);
		this.addEdge("b", "j", 1);
		this.addEdge("b", "k", 1);
		this.addEdge("c", "h", 1);
		this.addEdge("c", "g", 1);
		this.addEdge("d", "i", 1);

	}

	public void addVertex(Vertex vertex) {

		String key = vertex.getKey();

		vertexHashList.put(key, vertex);
		adjacencyHashList.put(key, new LinkedList<Node>());
	}

	public void addEdge(String from, String to, int weight) {
		if (!vertexHashList.containsKey(from))
			addVertex(new Vertex(from));
		if (!vertexHashList.containsKey(to))
			addVertex(new Vertex(to));

		LinkedList<Node> edgeListFrom = adjacencyHashList.get(from);
		edgeListFrom.add(new Node(to, weight));

		adjMatrix[((int) from.charAt(0)) - 97][((int) to.charAt(0)) - 97] = weight;

		if (directedGraph == false) {
			LinkedList<Node> edgeListTo = adjacencyHashList.get(to);
			edgeListTo.add(new Node(from, weight));

			adjMatrix[((int) to.charAt(0)) - 97][((int) from.charAt(0)) - 97] = weight;
		}
	}

	public boolean edgeExists(String from, String to) {

		if (adjMatrix[((int) from.charAt(0)) - 97][((int) to.charAt(0)) - 97] == 1)
			return true;
		return false;

	}

	public void printAdjacencyList() {

		System.out
				.println("***************Graph Adjacenct List****************");

		Iterator<Entry<String, LinkedList<Node>>> mapIterator = adjacencyHashList
				.entrySet().iterator();

		while (mapIterator.hasNext()) {
			Entry<String, LinkedList<Node>> mapKeyValue = (Entry<String, LinkedList<Node>>) mapIterator
					.next();
			System.out.print("\n Vertex : " + mapKeyValue.getKey() + "--->");
			for (Node node : mapKeyValue.getValue()) {
				System.out.print(node.key + "(" + node.weight + ")  ");
			}
		}
		System.out
				.println("\n***************************************************");
	}

	public void printAdjacencyMatrix() {
		System.out
				.println("***************Graph Adjacenct Matrix****************");
		int noOfKeys = vertexHashList.keySet().size();
		System.out.print("  ");
		for (int i = 0; i < noOfKeys; i++) {
			System.out.print((char) (i + 97) + "  ");
		}
		System.out.println();

		for (int i = 0; i < noOfKeys; i++) {
			for (int j = 0; j < noOfKeys; j++) {

				if (j == 0)
					System.out.print((char) (i + 97) + " " + adjMatrix[i][j]
							+ "  ");
				else
					System.out.print(adjMatrix[i][j] + "  ");
			}
			System.out.println();
		}
		System.out
				.println("***************************************************");
	}

	public static void main(String[] args) {

		System.out.println("****** M E N U *******");
		System.out.println("1. Add Vertex");
		System.out.println("2. Add Edge");
		System.out.println("3. Exit");

		Graph graph = new Graph(false);

		graph.createGraph();
		graph.printAdjacencyList();
		graph.printAdjacencyMatrix();

		String userChoice = null;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Select Option");
			userChoice = scan.next();

			switch (userChoice) {

			case "1":
				System.out.println("Selected Option : Add Vertex");
				String key = scan.next();
				graph.addVertex(new Vertex(key));
				graph.printAdjacencyList();
				break;
			case "2":
				System.out.println("Selected Option : Add Edge");
				String from = scan.next();
				String to = scan.next();
				graph.addEdge(from, to, 1);
				graph.printAdjacencyList();
				break;
			case "3":
				graph.printAdjacencyList();
				break;
			default:
			}
		} while (!userChoice.equals("3"));
		scan.close();
	}

	public void createCycleGraph() {
		// TODO Auto-generated method stub
		this.addVertex(new Vertex("a"));
		this.addVertex(new Vertex("b"));
		this.addVertex(new Vertex("c"));
		this.addVertex(new Vertex("d"));
		this.addVertex(new Vertex("e"));

		this.addEdge("a", "b", 1);
		this.addEdge("c", "a", 1);
		this.addEdge("b", "d", 1);
		this.addEdge("d", "c", 1);
	}

}
