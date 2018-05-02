package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

public class MinimumSpanningTreePrims {

	//Idea is to keep adding shortest available edge. currV is the vertex in nPQ at the end of that edge.
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

		Set<String> MSTSet = new HashSet<String>();
		PriorityQueue<Vertex> nPQ = new PriorityQueue<Vertex>(10,
				new MinimumSpanningTreePrims().new VertexComp());

		Vertex currV = g.getVertex("a");
		//MSTSet.add("a");
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

		currV = nPQ.poll();

		MinimumSpanningTreePrims.Edge[] edges = new MinimumSpanningTreePrims.Edge[vertices
				.size() - 1];
		edges[0] = new MinimumSpanningTreePrims().new Edge(currV.getKey(),
				currV.getParentKey(), currV.getTempWeight());

		int i = 1;

		while (!nPQ.isEmpty()) {
			currV.setVisited(true);
			String currK = currV.getKey();
			System.out.println(currK);
			//MSTSet.add(currK);
			// if (!g.getVertex(v).isVisited()) {
			adjNodes = g.getAdjacentVertexList(currK);
			for (Node n : adjNodes) {

				int edgeWeight = n.getWeight();
				String edgeTo = n.getKey();
				Vertex adjV = g.getVertex(edgeTo);
				if (adjV.isVisited()) {
					continue;
				}
				if (nPQ.contains(adjV)) {
					if (adjV.getTempWeight() > edgeWeight) {
						nPQ.remove(adjV);
						adjV.setTempWeight(edgeWeight);
						adjV.setParentKey(currV.getKey());
						nPQ.add(adjV);
					}
				} else {
					if (adjV.getTempWeight() > edgeWeight) {
						adjV.setTempWeight(edgeWeight);
						adjV.setParentKey(currV.getKey());
					}
					nPQ.add(adjV);
				}

			}

			currV = nPQ.poll();

			edges[i] = new MinimumSpanningTreePrims().new Edge(currV.getKey(),
					currV.getParentKey(), currV.getTempWeight());

			i++;

		}

		System.out.println(currV.getKey());
		printEdges(edges);

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
