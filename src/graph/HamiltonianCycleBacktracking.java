package graph;

import util.graph.Graph;
import util.graph.Vertex;

public class HamiltonianCycleBacktracking {

	static char path[];
	static Graph graph;

	public static void main(String[] args) {

		graph = new Graph(false);

		graph.addVertex(new Vertex("a"));
		graph.addVertex(new Vertex("b"));
		graph.addVertex(new Vertex("c"));
		graph.addVertex(new Vertex("d"));
		graph.addVertex(new Vertex("e"));

		graph.addEdge("a", "c", 1);
		graph.addEdge("a", "d", 1);
		graph.addEdge("a", "b", 1);
		graph.addEdge("b", "e", 1);

		path = new char[graph.getVertexKeys().size()];

		graph.printAdjacencyList();
		graph.printAdjacencyMatrix();
		path[0] = 'a';
		System.out.println("Hamiltonian cycle exists ? " + hamiltonianCycle(1));
		System.out
				.println("Hamiltonian Path Exists ? "
						+ (path[path.length - 1] >= 'a'
								&& path[path.length - 1] <= 'z' ? "true"
								: "false"));

		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}

	}

	private static boolean hamiltonianCycle(int pathIndex) {

		System.out.println("pathIndex " + pathIndex);
		if (pathIndex == path.length) {
			if (graph.edgeExists(String.valueOf(path[pathIndex - 1]),
					String.valueOf(path[0]))) {
				return true;
			} else
				return false;
		}

		for (int i = 1; i < path.length; i++) {
			path[pathIndex] = '/';
			if (addSafe((char) (i + 97), pathIndex)) {
				path[pathIndex] = (char) (i + 97);
				if (hamiltonianCycle(pathIndex + 1))
					return true;
				path[pathIndex] = '/';

			}
		}

		return false;

	}

	private static boolean addSafe(char c, int pathIndex) {

		if (graph.edgeExists(String.valueOf(c),
				String.valueOf(path[pathIndex - 1]))) {

			for (int i = 0; i < pathIndex; i++) {
				if (path[i] == c) {
					return false;
				}
			}

			return true;
		}

		return false;
	}
}
