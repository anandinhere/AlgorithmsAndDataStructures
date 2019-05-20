package graph;

import java.util.Arrays;

import graph.ShortestPathBellmanFord.Graph.Edge;

/**
 * @author anasil01
 * 
 *         Ref: http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-
 *         ford-algorithm/
 * 
 *         We have discussed Dijkstra�s algorithm for this problem. Dijksra�s
 *         algorithm is a Greedy algorithm and time complexity is O(VLogV) (with
 *         the use of Fibonacci heap). Dijkstra doesn�t work for Graphs with
 *         negative weight edges, Bellman-Ford works for such graphs.
 *         Bellman-Ford is also simpler than Dijkstra and suites well for
 *         distributed systems. But time complexity of Bellman-Ford is O(VE),
 *         which is more than Dijkstra.
 * 
 *
 */

@SuppressWarnings("LossyEncoding")
public class ShortestPathBellmanFord {

	static int[] parents = { -1, -1, -1, -1, -1, -1 };
	static ShortestPathBellmanFord.Graph.Edge result[] = new ShortestPathBellmanFord.Graph.Edge[5];

	public static void main(String[] args) {
		ShortestPathBellmanFord.Graph g = new ShortestPathBellmanFord().new Graph();

		int resultCount = 0;
		System.out.println("\nBefore sort ");
		printEdges(g.edges);
		Arrays.sort(g.edges);
		System.out.println("\nAfter sort ");
		printEdges(g.edges);

		for (ShortestPathBellmanFord.Graph.Edge e : g.edges) {
			int srcp = find(e.from);
			int srcf = find(e.to);

			if (srcp != srcf) {
				result[resultCount] = e;
				resultCount++;

				if (resultCount == parents.length - 1) {
					System.out.println("\nMST");
					printEdges(result);
					return;
				}
			}

			union(e.from, e.to);

			compress(e.from);
			compress(e.to);
		}
	}

	private static void printEdges(Edge[] result) {
		for (Edge e : result) {
			System.out
					.println("(" + e.from + "," + e.to + "," + e.weight + ")");
		}

	}

	private static void compress(int x) {
		if (parents[x] == -1)
			return;
		parents[x] = find(x);
	}

	private static void union(int from, int to) {
		parents[from] = to;
	}

	public static int find(int v) {

		if (parents[v] == -1)
			return v;

		else
			return find(parents[v]);

	}

	class Graph {
		Edge[] edges = { new Edge(0, 1, 3), new Edge(1, 3, 5),
				new Edge(3, 2, 2), new Edge(2, 5, 0), new Edge(2, 4, 1),
				new Edge(1, 2, 4), new Edge(0, 5, 8) };

		class Edge implements Comparable<Edge> {
			int from;
			int to;
			int weight;

			public Edge(int from, int to, int weight) {
				this.from = from;
				this.to = to;
				this.weight = weight;
			}

			@Override
			public int compareTo(Edge o) {
				if (this.weight > o.weight)
					return 1;
				else if (this.weight < o.weight)
					return -1;
				return 0;
			}

		}

		public Graph() {
			// edges[3] = new Edge(3, 1);
		}
	}

}
