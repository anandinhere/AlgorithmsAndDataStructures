package graph;

public class DetectCycleUndirectedUnionFindPathCompression {

	static int edges[][] = { { 0, 3 }, { 1, 3 }, { 1, 2 }, { 2, 3 } };

	static Node[] nodes = { new Node(0, -1), new Node(1, -1), new Node(2, -1),
			new Node(3, -1) };

	public static void main(String[] args) {
		DetectCycleUndirectedUnionFindPathCompression.Graph g = new DetectCycleUndirectedUnionFindPathCompression().new Graph();
		for (DetectCycleUndirectedUnionFindPathCompression.Graph.Edge e : g.edges) {
			int srcp = find(e.from);
			int srcf = find(e.to);

			if (srcp == srcf) {
				System.out.println("Cycle present");
				return;
			}

			union(e.from, e.to);

			compress(e.from);
			compress(e.to);
		}
	}

	private static void compress(int x) {
		if (nodes[x].parent == -1)
			return;
		nodes[x].parent = find(x);
	}

	private static void union(int from, int to) {
		nodes[from].parent = to;
	}

	public static int find(int v) {

		if (nodes[v].parent == -1)
			return nodes[v].vertex;

		else
			return find(nodes[v].parent);

	}

	class Graph {
		Edge[] edges = { new Edge(0, 1), new Edge(1, 2), new Edge(2, 3) };

		class Edge {
			int from;
			int to;

			public Edge(int from, int to) {
				this.from = from;
				this.to = to;
			}

		}

		public Graph() {
			// edges[3] = new Edge(3, 1);
		}
	}

}

class Node {
	int vertex;
	int parent = -1;

	public Node(int v, int p) {
		vertex = v;
		parent = p;
	}
}
