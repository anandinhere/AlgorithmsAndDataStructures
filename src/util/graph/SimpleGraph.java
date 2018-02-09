package util.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class SimpleGraph {

	int adjMatrix[][] = new int[20][20];
	HashMap<Integer, SimpleGraphNode> SimpleGraphNodeHashList = null;
	HashMap<Integer, LinkedList<AdjacentNode>> adjacencyHashList = null;
	boolean directedGraph = false;

	// private ArrayList<String>[] x = new ArrayList<String>[10];

	public SimpleGraph(boolean directedGraph) {
		this.directedGraph = directedGraph;
		SimpleGraphNodeHashList = new HashMap<Integer, SimpleGraphNode>();
		adjacencyHashList = new HashMap<Integer, LinkedList<AdjacentNode>>();
	}

	public SimpleGraph() {
		SimpleGraphNodeHashList = new HashMap<Integer, SimpleGraphNode>();
		adjacencyHashList = new HashMap<Integer, LinkedList<AdjacentNode>>();
	}

	public Set<Integer> getSimpleGraphNodeKeys() {
		return SimpleGraphNodeHashList.keySet();
	}

	public SimpleGraphNode getSimpleGraphNode(Integer key) {
		return SimpleGraphNodeHashList.get(key);
	}

	public int noOfSimpleGraphNode() {
		return SimpleGraphNodeHashList.keySet().size();
	}

	public LinkedList<AdjacentNode> getAdjacentSimpleGraphNodeList(int key) {
		return adjacencyHashList.get(key);
	}

	public void createGraph() {
		this.addNode(new SimpleGraphNode(1));
		this.addNode(new SimpleGraphNode(2));
		this.addNode(new SimpleGraphNode(3));
		this.addNode(new SimpleGraphNode(4));
		this.addNode(new SimpleGraphNode(5));
		this.addNode(new SimpleGraphNode(6));
		this.addNode(new SimpleGraphNode(7));
		this.addNode(new SimpleGraphNode(8));
		this.addNode(new SimpleGraphNode(9));
		this.addNode(new SimpleGraphNode(10));
		this.addNode(new SimpleGraphNode(11));
		this.addNode(new SimpleGraphNode(12));
		this.addNode(new SimpleGraphNode(13));
		this.addNode(new SimpleGraphNode(14));

		this.addEdge(1, 2, 1);
		this.addEdge(1, 3, 1);
		this.addEdge(1, 4, 1);
		this.addEdge(1, 5, 1);
		this.addEdge(5, 12, 1);
		this.addEdge(5, 13, 1);
		this.addEdge(5, 14, 1);
		this.addEdge(5, 4, 1);
		this.addEdge(6, 2, 1);
		this.addEdge(6, 7, 1);
		this.addEdge(2, 10, 1);
		this.addEdge(2, 11, 1);
		this.addEdge(3, 8, 1);
		this.addEdge(3, 7, 1);
		this.addEdge(4, 9, 1);

	}

	public void addNode(SimpleGraphNode SimpleGraphNode) {

		int key = SimpleGraphNode.getKey();

		SimpleGraphNodeHashList.put(key, SimpleGraphNode);
		adjacencyHashList.put(key, new LinkedList<AdjacentNode>());
	}

	public void addEdge(Integer from, Integer to, int weight) {
		if (!SimpleGraphNodeHashList.containsKey(from))
			addNode(new SimpleGraphNode(from));
		if (!SimpleGraphNodeHashList.containsKey(to))
			addNode(new SimpleGraphNode(to));

		LinkedList<AdjacentNode> edgeListFrom = adjacencyHashList.get(from);
		edgeListFrom.add(new AdjacentNode(to, weight));

		adjMatrix[from][to] = weight;

		if (directedGraph == false) {
			LinkedList<AdjacentNode> edgeListTo = adjacencyHashList.get(to);
			edgeListTo.add(new AdjacentNode(from, weight));

			adjMatrix[to][from] = weight;
		}
	}

	public boolean edgeExists(String from, String to) {

		if (adjMatrix[((int) from.charAt(0)) - 97][((int) to.charAt(0)) - 97] == 1)
			return true;
		return false;

	}

	public void printAdjacencyList() {

		System.out.println("***************Graph Adjacenct List****************");

		Iterator<Entry<Integer, LinkedList<AdjacentNode>>> mapIterator = adjacencyHashList.entrySet().iterator();

		while (mapIterator.hasNext()) {
			Entry<Integer, LinkedList<AdjacentNode>> mapKeyValue = (Entry<Integer, LinkedList<AdjacentNode>>) mapIterator
					.next();
			System.out.print("\n SimpleGraphNode : " + mapKeyValue.getKey() + "--->");
			for (AdjacentNode node : mapKeyValue.getValue()) {
				System.out.print(node.key + "(" + node.weight + ")  ");
			}
		}
		System.out.println("\n***************************************************");
	}

	public void printAdjacencyMatrix() {
		System.out.println("***************Graph Adjacenct Matrix****************");
		int noOfKeys = SimpleGraphNodeHashList.keySet().size();
		System.out.print("  ");
		for (int i = 0; i < noOfKeys; i++) {
			System.out.print((char) (i + 97) + "  ");
		}
		System.out.println();

		for (int i = 0; i < noOfKeys; i++) {
			for (int j = 0; j < noOfKeys; j++) {

				if (j == 0)
					System.out.print((char) (i + 97) + " " + adjMatrix[i][j] + "  ");
				else
					System.out.print(adjMatrix[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("***************************************************");
	}

	public static void main(String[] args) {

		System.out.println("****** M E N U *******");
		System.out.println("1. Add SimpleGraphNode");
		System.out.println("2. Add Edge");
		System.out.println("3. Exit");

		SimpleGraph graph = new SimpleGraph(false);

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
				System.out.println("Selected Option : Add SimpleGraphNode");
				int key = Integer.parseInt(scan.next());
				graph.addNode(new SimpleGraphNode(key));
				graph.printAdjacencyList();
				break;
			case "2":
				System.out.println("Selected Option : Add Edge");
				int from = Integer.parseInt(scan.next());
				int to = Integer.parseInt(scan.next());
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
		this.addNode(new SimpleGraphNode(1));
		this.addNode(new SimpleGraphNode(2));
		this.addNode(new SimpleGraphNode(3));
		this.addNode(new SimpleGraphNode(4));
		this.addNode(new SimpleGraphNode(5));

		this.addEdge(1, 2, 1);
		this.addEdge(3, 1, 1);
		this.addEdge(2, 4, 1);
		this.addEdge(4, 3, 1);
	}

}
