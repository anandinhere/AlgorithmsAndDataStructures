package graph;

import java.util.Iterator;
import java.util.LinkedList;

import util.graph.Graph;
import util.graph.Node;
import util.graph.Vertex;

/**
 * 
 * @author anasil01 Idea is to check if the child is in recursive stack. If
 *         there is a child which is already visited and is recursed, then there
 *         is cycle.
 * 
 *         Concept: There is a cycle in a graph only if there is a back edge
 *         present in the graph. A back edge is an edge that is from a node to
 *         itself (selfloop) or one of its ancestor in the tree produced by DFS.
 */

public class DetectCycleDirectedGraph {
	public static void main(String[] args) {
		Graph graph = new Graph(true);
		graph.createCycleGraph();
		graph.printAdjacencyList();

		System.out.println(checkCycle(graph, "a"));
	}

	private static boolean checkCycle(Graph graph, String startKey) {

		LinkedList<Node> adjVList = graph.getAdjacentVertexList(startKey);
		graph.getVertex(startKey).setVisited(true);
		graph.getVertex(startKey).setInRecurseStack(true);
		System.out.println(startKey + " Visited");
		Iterator<Node> keyIterator = adjVList.iterator();
		while (keyIterator.hasNext()) { // recurses back if keyIterator is empty
			Vertex curr = graph.getVertex(keyIterator.next().getKey());
			if (!curr.isVisited() && checkCycle(graph, curr.getKey())) {
				System.out.println("return true");
				return true;
			} else if (curr.isInRecurseStack()) {
				System.out.println("return true");
				return true;
			}
		}

		graph.getVertex(startKey).setInRecurseStack(false);
		System.out.println("return false");
		return false;
	}
}
