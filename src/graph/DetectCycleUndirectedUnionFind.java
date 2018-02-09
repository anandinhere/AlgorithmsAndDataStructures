package graph;

/**
 * 
 * @author Anand.Siloju
 * 
 *         Reference: https://en.wikipedia.org/wiki/Disjoint-set_data_structure
 *         (weighted-union heuristic) http://www.geeksforgeeks.org/union-find/
 * 
 */
public class DetectCycleUndirectedUnionFind {

	public static void main(String[] args) {
		Graph g = new Graph();

		int[] parent = { -1, -1, -1, -1 };

		for (Graph.Edge e : g.edges) {
			int x = find(parent, e.from);
			int y = find(parent, e.to);
			if (x != -1 && x == y) {
				System.out.println("True Cycle Exists");
				return;
			}
			union(parent, e.from, e.to);
			print(parent);

		}

	}

	private static void print(int[] parent) {
		for (int p : parent) {
			System.out.print(p + " ");
		}
		System.out.println();
	}

	private static void union(int[] parent, int x, int y) {
		if (parent[x] == -1 && parent[y] == -1) {
			parent[x] = x;
			parent[y] = x;
		} else if (parent[x] == -1) {
			parent[x] = parent[x];
		} else if (parent[y] == -1) {
			parent[y] = parent[x];
		} else if (parent[x] > y) {
			parent[x] = parent[y];
		} else if (parent[y] > x) {
			parent[y] = parent[x];
		}
	}

	private static int find(int[] parent, int v) {
		if (parent[v] == -1) {
			return -1;
		}

		if (parent[v] == v) {
			return v;
		}
		return find(parent, parent[v]);
	}
}

class Graph {
	Edge[] edges;

	class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

	}

	public Graph() {
		edges = new Edge[4];
		edges[3] = new Edge(0, 1);
		edges[0] = new Edge(1, 2);
		edges[1] = new Edge(2, 3);
		edges[2] = new Edge(3, 0);
	}

}
