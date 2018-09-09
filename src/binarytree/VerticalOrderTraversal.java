package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import util.tree.TreeNode;

public class VerticalOrderTraversal {
	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();

		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();

//		printVerticalOrder(root, 0, map);
//
//		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//			System.out.print(entry.getKey() + "  -   ");
//			for (Integer i : entry.getValue()) {
//				System.out.print(i);
//			}
//			System.out.println();
//		}

		map = new TreeMap<Integer, List<Integer>>();
		printVerticalOrderWithQueue(root, map);

	}

	private static void printVerticalOrderWithQueue(TreeNode root, TreeMap<Integer, List<Integer>> h) {

		Queue<TreeVert> q = new LinkedList<TreeVert>();

		q.add(new TreeVert(0, root.value, root));

		while (!q.isEmpty()) {

			TreeVert t = q.poll();

			if (h.containsKey(t.dist)) {
				h.get(t.dist).add(t.value);
			} else {
				h.put(t.dist, new LinkedList<>());
				h.get(t.dist).add(t.value);
			}

			if (t.node.left != null) {
				q.add(new TreeVert(t.dist - 1, t.node.left.value, t.node.left));
			}

			if (t.node.right != null) {
				q.add(new TreeVert(t.dist + 1, t.node.right.value, t.node.right));
			}

		}

		for (Map.Entry<Integer, List<Integer>> entry : h.entrySet()) {
			System.out.print(entry.getKey() + "  -   ");
			for (Integer i : entry.getValue()) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

	// O(n ^ 2) when min and max is found. And tried to print from min to max.
	private static void printVerticalOrder(TreeNode root, int dist, HashMap<Integer, List<Integer>> h) {

		if (root == null) {
			return;
		}

		if (h.containsKey(dist)) {
			h.get(dist).add(root.value);
		} else {
			h.put(dist, new LinkedList<>());
			h.get(dist).add(root.value);
		}

		System.out.println("dist " + dist + "  val " + root.value);

		printVerticalOrder(root.left, dist - 1, h);
		printVerticalOrder(root.right, dist + 1, h);

	}

	static class TreeVert {

		TreeNode node;
		int dist;

		public TreeVert(int dist, int value, TreeNode n) {
			super();
			this.dist = dist;
			this.value = value;
			this.node = n;
		}

		int value;

	}
}
