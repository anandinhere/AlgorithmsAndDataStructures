package graph;

import java.util.Arrays;

import graph.MinimumSpanningTreeKruskals.Graph.Edge;

public class MinimumSpanningTreeKruskals {

	static int[] parents = { -1, -1, -1, -1, -1, -1 };
	static MinimumSpanningTreeKruskals.Graph.Edge result[] = new MinimumSpanningTreeKruskals.Graph.Edge[5];

	public static void main(String[] args) {
		MinimumSpanningTreeKruskals.Graph g = new MinimumSpanningTreeKruskals().new Graph();

		int resultCount = 0;
		System.out.println("\nBefore sort ");
		printEdges(g.edges);
		Arrays.sort(g.edges);
		System.out.println("\nAfter sort ");
		printEdges(g.edges);

		for (MinimumSpanningTreeKruskals.Graph.Edge e : g.edges) {
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
