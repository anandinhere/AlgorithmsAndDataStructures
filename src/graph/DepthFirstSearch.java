package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

/**
 * 
 * @author anasil01
 * 
 *         Start with one node. Pop it, mark it Visited and push its adjacent
 *         nodes. Repeat until stack is empty.
 * 
 *         Marking nodes as Visited is important as there may be cycles in the
 *         graph.
 * 
 *         Traversal is not possible if any nodes are unreachable from starting
 *         node. To achieve complete traversal call depthFirstSearch() for each
 *         unvisited key.
 * 
 */

public class DepthFirstSearch {
	public static void main(String[] args) {
		Graph graph = new Graph(true);
		graph.createGraph();
		graph.addEdge("n", "e", 1);
		graph.addEdge("e", "a", 1);
		graph.printAdjacencyList();

		recursiveDFS(graph, "f");

		for (String key : graph.getVertexKeys()) {
			if (!graph.getVertex(key).isVisited()) {

				System.out.println("DFS for Key : " + key);

				depthFirstSearch(graph, key);
			}
		}
	}

	private static void recursiveDFS(Graph graph, String startKey) {

		LinkedList<Node> adjVList = graph.getAdjacentVertexList(startKey);
		graph.getVertex(startKey).setVisited(true);
		System.out.println(startKey + " Visited");
		Iterator<Node> keyIterator = adjVList.iterator();
		while (keyIterator.hasNext()) { // recurses back if keyIterator is empty
			Vertex curr = graph.getVertex(keyIterator.next().getKey());
			if (!curr.isVisited())

				recursiveDFS(graph, curr.getKey());
		}

	}

	private static void depthFirstSearch(Graph graph, String startKey) {

		Stack<Vertex> vStack = new Stack<>();

		Vertex startV = graph.getVertex(startKey);

		vStack.push(startV);

		while (!vStack.isEmpty()) {

			Vertex topV = vStack.pop();

			if (topV.isVisited()) {
				continue;
			}

			topV.setVisited(true);
			System.out.println(topV.getKey() + " Visited****");
			LinkedList<Node> adjVList = graph.getAdjacentVertexList(topV
					.getKey());

			for (Node adjKey : adjVList) {
				vStack.push(graph.getVertex(adjKey.getKey()));
				System.out.println(adjKey.getKey() + " Pushed");
			}

		}

	}
}