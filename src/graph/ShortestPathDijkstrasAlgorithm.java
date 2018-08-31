package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

public class ShortestPathDijkstrasAlgorithm {
	
	//Time Complexity: The time complexity of the above code/algorithm looks O(V^2) as there are two nested while loops. 
	//If we take a closer look, we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS). 
	//The inner loop has decreaseKey() operation which takes O(LogV) time. So overall time complexity is O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV)
	
	//Note that  the above code uses Binary Heap for Priority Queue implementation. Time complexity can be reduced to 
	//O(E + VLogV) using Fibonacci Heap. The reason is, Fibonacci Heap takes O(1) time for decrease-key operation 
	//while Binary Heap takes O(Logn) time.
	
	//O(E + VLogV) - extract a Vertex in priority Queue is logV operation. decreaseKey is on edges so (E*1+V*LogV)
	/*
	 The complexity of Dijkstra's shortest path algorithm is:

	     O(|E| |decrease-key(Q)| + |V| |extract-min(Q)|)
	     
	     Below are amortized time complexities of Fibonacci Heap.

1) Find Min:      Θ(1)     [Same as both Binary and Binomial]
2) Delete Min:    O(Log n) [Θ(Log n) in both Binary and Binomial]
3) Insert:        Θ(1)     [Θ(Log n) in Binary and Θ(1) in Binomial]
4) Decrease-Key:  Θ(1)     [Θ(Log n) in both Binary and Binomial]
5) Merge:         Θ(1)     [Θ(m Log n) or Θ(m+n) in Binary and
                            Θ(Log n) in Binomial]
	 */


	public static void main(String[] args) {

		Graph g = new Graph();

		g.addEdge("a", "b", 7);
		g.addEdge("a", "c", 5);
		g.addEdge("b", "c", 9);
		g.addEdge("b", "e", 10);	
		g.addEdge("f", "c", 13);
		g.addEdge("f", "e", 2);
		g.addEdge("d", "c", 11);
		g.addEdge("d", "e", 14);

		g.printAdjacencyList();

		Set<String> vertices = g.getVertexKeys();

		PriorityQueue<Vertex> nPQ = new PriorityQueue<Vertex>(10,
				new ShortestPathDijkstrasAlgorithm().new VertexComp());

		Vertex currV = g.getVertex("a");
		System.out.println("a");
		LinkedList<Node> adjNodes = g.getAdjacentVertexList("a");
		currV.setVisited(true);
		currV.setTempWeight(0);

		for (Node n : adjNodes) {
			int edgeWeight = n.getWeight();
			String edgeTo = n.getKey();
			Vertex adjV = g.getVertex(edgeTo);
			adjV.setTempWeight(edgeWeight);
			adjV.setParentKey(currV.getKey());
			nPQ.add(adjV);
		}

		

		ShortestPathDijkstrasAlgorithm.Edge[] edges = new ShortestPathDijkstrasAlgorithm.Edge[vertices
				.size() - 1]; //creating edges array to traverse path
		

		int i = 0;

		while (!nPQ.isEmpty()) { //until all nodes traversed
			
			currV = nPQ.poll();
			edges[i] = new ShortestPathDijkstrasAlgorithm().new Edge(
					currV.getKey(), currV.getParentKey(), currV.getTempWeight());
			
			
			currV.setVisited(true);
			String currK = currV.getKey();

			if (currK == "f")
				break;
			System.out.println(currK);
			// if (!g.getVertex(v).isVisited()) {
			adjNodes = g.getAdjacentVertexList(currK);
			for (Node n : adjNodes) { //all adjacent nodes - in other words - edges

				int edgeWeight = n.getWeight();
				String edgeTo = n.getKey();
				Vertex adjV = g.getVertex(edgeTo);
				if (adjV.isVisited()) {
					continue;
				}
				if (nPQ.contains(adjV)) {
					if (adjV.getTempWeight() > (edgeWeight + currV
							.getTempWeight())) {
						//decreaseKey Operation
						nPQ.remove(adjV);
						adjV.setTempWeight(edgeWeight + currV.getTempWeight());
						adjV.setParentKey(currV.getKey());
						nPQ.add(adjV);
					}
				} else {
					if (adjV.getTempWeight() > edgeWeight+ currV.getTempWeight()) {
						adjV.setTempWeight(edgeWeight+ currV.getTempWeight());
						adjV.setParentKey(currV.getKey());
					}
					nPQ.add(adjV);
				}

			}

			/*currV = nPQ.poll();

			edges[i] = new ShortestPathDijkstrasAlgorithm().new Edge(
					currV.getKey(), currV.getParentKey(), currV.getTempWeight());
*/
			i++;

		}

		System.out.println(currV.getKey());
		printEdges(edges);

		printPath(currV, g);
		System.out.println("Shortest Distance Value " + currV.getTempWeight());

	}

	private static void printPath(Vertex currV, Graph g) {
		System.out.println(currV.getKey());
		if (currV.getParentKey() == null) {
			return;
		}
		printPath(g.getVertex(currV.getParentKey()), g);
	}

	private static void printEdges(Edge[] result) {
		for (Edge e : result) {
			System.out
					.println("(" + e.from + "," + e.to + "," + e.weight + ")");
		}

	}

	class Edge implements Comparable<Edge> {
		String from;
		String to;
		int weight;
		int key;

		public Edge(String from, String to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.key > o.key)
				return -1;
			else if (this.key < o.key)
				return 1;
			return 0;
		}

	}

	class VertexComp implements Comparator<Vertex> {

		@Override
		public int compare(Vertex o1, Vertex o2) {
			if (o1.getTempWeight() < o2.getTempWeight()) {
				return -1;
			}
			if (o1.getTempWeight() > o2.getTempWeight()) {
				return 1;
			}
			return 0;
		}

	}

}
