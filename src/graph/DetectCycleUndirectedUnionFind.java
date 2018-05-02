package graph;

/**
 * 
 * @author Anand.Siloju
 * 
 *         Reference: https://en.wikipedia.org/wiki/Disjoint-set_data_structure
 *         (weighted-union heuristic) http://www.geeksforgeeks.org/union-find/
 *         
 *         Note that the implementation of union() and find() is naive and takes O(n) time in worst case. 
 *         These methods can be improved to O(Logn) using Union by Rank or Height. We will soon be discussing 
 *         Union by Rank in a separate post
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

	
	/**
	 * 
	 * @param parent
	 * @param x
	 * @param y
	 * 
	 * //If these are 2 new vertices, then their parents are themselves.
	 * If one of them already has a parent, give the parent to orphan
	 * if both have a parent, bigger of the 2 parents will win.
	 */
	private static void union(int[] parent, int x, int y) {
		if (parent[x] == -1 && parent[y] == -1) {
			parent[x] = x;
			parent[y] = x;
		} else if (parent[x] == -1) {
			parent[x] = parent[y];
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
