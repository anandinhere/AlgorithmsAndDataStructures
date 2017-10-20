package graph;

import java.util.Iterator;
import java.util.LinkedList;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

public class FindIfPathPresent2Vertex {
	public static void main(String[] args) {
		Graph graph = new Graph(true);
		graph.createGraph();

		System.out.println(isPathPresent(graph, "e", "e"));

	}

	private static boolean isPathPresent(Graph graph, String startKey,
			String toKey) {

		if (startKey.equals(toKey)) {
			return true;
		}

		LinkedList<Node> adjVList = graph.getAdjacentVertexList(startKey);
		graph.getVertex(startKey).setVisited(true);
		System.out.println(startKey + " Visited");
		Iterator<Node> keyIterator = adjVList.iterator();
		while (keyIterator.hasNext()) { // recurses back if keyIterator is empty
			Vertex curr = graph.getVertex(keyIterator.next().getKey());
			if (!curr.isVisited() && isPathPresent(graph, curr.getKey(), toKey)) {

				return true;
			}
		}
		return false;

	}
}
