package binarytree.views;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import util.tree.TreeNode;

public class BottomView {

	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();

		printTopView(root);

	}

	private static void printTopView(TreeNode root) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map = new TreeMap<Integer, Integer>();

		printVerticalOrderWithQueue(root, map);

	}

	private static void printVerticalOrderWithQueue(TreeNode root, TreeMap<Integer, Integer> h) {

		Queue<TreeVert> q = new LinkedList<TreeVert>();

		q.add(new TreeVert(0, root.value, root));

		while (!q.isEmpty()) {

			TreeVert t = q.poll();

//			if (h.containsKey(t.dist)) {
//				// h.get(t.dist).add(t.value);
//			} else {
//				h.put(t.dist, t.value);
//			}
			
			//keep overwriting upper level values
			h.put(t.dist, t.value);

			if (t.node.left != null) {
				q.add(new TreeVert(t.dist - 1, t.node.left.value, t.node.left));
			}

			if (t.node.right != null) {
				q.add(new TreeVert(t.dist + 1, t.node.right.value, t.node.right));
			}

		}

		for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
			System.out.print(entry.getKey() + "  -   ");

			System.out.print(entry.getValue());

			System.out.println();
		}

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
