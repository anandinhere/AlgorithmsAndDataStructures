package graph;

import java.util.LinkedList;
import java.util.Queue;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

/**
 * 
 * @author anasil01
 * 
 *         Start with one node. Poll it, mark it Visited and add its adjacent
 *         nodes. Repeat until Queue is empty.
 * 
 *         Marking nodes as Visited is important as there may be cycles in the
 *         graph.
 * 
 *         Traversal is not possible if any nodes are unreachable from starting
 *         node. To achieve complete traversal call breadthFirstSearch() for
 *         each unvisited key.
 *         
 *         http://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/
 * 
 */

public class BreadthFirstSearch {
	public static void main(String[] args) {
		Graph graph = new Graph(true);
		graph.createGraph();

		graph.addEdge("n", "e", 1);
		graph.addEdge("e", "a", 1);

		graph.printAdjacencyList();

		for (String key : graph.getVertexKeys()) {
			if (!graph.getVertex(key).isVisited()) {

				System.out.println("BFS for Key : " + key);

				breadthFirstSearch(graph, key);
			}
		}

		Graph graph1 = new Graph(true);
		Queue<Vertex> vQueue = new LinkedList<Vertex>();
		Vertex startV = graph1.getVertex("f");
		vQueue.add(startV);
		breadthFirstSearchRec(vQueue, graph1);

	}

	private static void breadthFirstSearchRec(Queue<Vertex> vQueue, Graph graph1) {

		Vertex qHead = vQueue.poll();

		if (!vQueue.isEmpty()) {
			qHead.setVisited(true);
			System.out.println(qHead.getKey() + " Visited****");
		}

		if (!vQueue.isEmpty()) {
			qHead = vQueue.poll();
			if (!qHead.isVisited()) {

				System.out.println(qHead.getKey() + " Visited****");
				LinkedList<Node> adjVList = graph1.getAdjacentVertexList(qHead
						.getKey());

				for (Node adjKey : adjVList) {
					vQueue.add(graph1.getVertex(adjKey.getKey()));
					System.out.println(adjKey.getKey() + " Added");
				}

				breadthFirstSearchRec(vQueue, graph1);
			}
		}

	}

	private static void breadthFirstSearch(Graph graph, String startKey) {

		Queue<Vertex> vQueue = new LinkedList<Vertex>();

		Vertex startV = graph.getVertex(startKey);

		vQueue.add(startV);

		while (!vQueue.isEmpty()) {

			Vertex qHead = vQueue.poll();

			if (qHead.isVisited()) {
				continue;
			}

			qHead.setVisited(true);
			System.out.println(qHead.getKey() + " Visited****");
			LinkedList<Node> adjVList = graph.getAdjacentVertexList(qHead
					.getKey());

			for (Node adjKey : adjVList) {
				vQueue.add(graph.getVertex(adjKey.getKey()));
				System.out.println(adjKey.getKey() + " Added");
			}

		}

	}
}
