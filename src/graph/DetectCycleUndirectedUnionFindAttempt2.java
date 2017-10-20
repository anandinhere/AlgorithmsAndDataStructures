package graph;

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
			print(parent);
			union(parent, x, y);
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
		edges[1] = new Edge(1, 2);
		edges[2] = new Edge(2, 3);
		edges[3] = new Edge(3, 1);
	}
}