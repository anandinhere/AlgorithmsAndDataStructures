package graph;


/*
 * /**
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
 *
 * 1. Find parent of x and y (find and find)
 * 2. Set parent of y to x (union (find find parent-update)
 * 3. If both parents same, print loop exists.
 */
public class DetectCycleUndirectedUnionFindAttempt2 {

	public static void main(String[] args) {
		Graph1 g = new Graph1();
		int[] parent = { -1, -1, -1, -1 };
		for (Graph1.Edge e : g.edges) {

			int x = find(parent, e.from);
			int y = find(parent, e.to);

			if (x == y) {
				
				System.out.println("true");
				return;
			}
			union(parent, x, y);
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
		int xpar = find(parent, x);
		int ypar = find(parent, y);

		parent[ypar] = xpar;
	}

	private static int find(int[] parent, int v) {

		if (parent[v] == -1)
			return v;

		return find(parent, parent[v]);
	}
}

class Graph1 {
	Edge[] edges;

	class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

	}

	public Graph1() {
		edges = new Edge[4];
		edges[0] = new Edge(0, 1);
		edges[1] = new Edge(2, 1);
		edges[2] = new Edge(2, 3);
		edges[3] = new Edge(3, 1);
	}
}