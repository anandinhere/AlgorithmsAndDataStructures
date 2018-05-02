package util.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode implements Comparable<TreeNode> {

	public TreeNode right;
	public TreeNode left;
	public int printPosition;
	public int value;
	public boolean black = true;

	static class Height {
		int h;
	}

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode(int val) {
		this.value = val;
	}

	public boolean isLeaf() {
		if (this.left == null && this.right == null)
			return true;

		return false;
	}

	public TreeNode search(TreeNode root, int key) {

		if (root == null || root.value == key) {
			return root;
		}

		if (root.value < key)
			return search(root.left, key);
		return search(root.right, key);

	}

	public void printInorder(TreeNode r) {

		if (r == null) {
			return;

		}
		printInorder(r.left);
		System.out.print(r.value + " ");
		printInorder(r.right);
		if (r == this) {
			System.out.println();
		}
	}

	public TreeNode insert(TreeNode root, int key) {

		if (root == null) {
			return new TreeNode(key);
		}

		if (root.value < key)
			root.left = insert(root.left, key);
		root.right = insert(root.right, key);
		return root;

	}

	public static TreeNode append(TreeNode nodeA, TreeNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;

		TreeNode tailA = nodeA.left;
		TreeNode tailB = nodeB.left;

		tailA.right = nodeB;
		nodeB.left = tailA;

		tailB.right = nodeA;
		nodeA.left = tailB;

		return nodeA;
	}

	public TreeNode getBasicTree() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);

		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		return node;

	}

	public TreeNode getBST() {
		int[] nodes = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = makeBST(nodes, 0, nodes.length - 1);
		return root;
	}

	public void printLevelOrder() {

		int height = getHeight(this);

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(this);

		this.printPosition = 2 << height;

		while (!q1.isEmpty() || !q2.isEmpty()) {
			System.out.println();
			while (!q1.isEmpty()) {
				TreeNode node = q1.poll();

				// for (int i = 0; i < node.printPosition; i++) {
				// System.out.print(" ");
				// }
				System.out.print(node.value);
				// System.out.println();

				if (node.left != null) {
					node.left.printPosition = node.printPosition / 2;
					q2.add(node.left);
				}

				if (node.right != null) {
					node.right.printPosition = node.printPosition
							+ node.printPosition / 2;
					q2.add(node.right);
				}

			}
			System.out.println();

			while (!q2.isEmpty()) {
				TreeNode node = q2.poll();
				// for (int i = 0; i < node.printPosition; i++) {
				// System.out.print(" ");
				// }
				System.out.print(node.value);
				// System.out.println();
				if (node.left != null) {
					node.left.printPosition = node.printPosition / 2;
					q1.add(node.left);
				}

				if (node.right != null) {
					node.right.printPosition = node.printPosition
							+ node.printPosition / 2;
					q1.add(node.right);
				}

			}
			System.out.println();

		}

	}

	public int getHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

	}

	private TreeNode makeBST(int[] nodes, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		TreeNode root = new TreeNode(nodes[mid]);

		root.left = makeBST(nodes, start, mid - 1);
		root.right = makeBST(nodes, mid + 1, end);

		return root;
	}

	public static TreeNode appendTreeList(TreeNode nodeA, TreeNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;

		TreeNode nodeACopy = nodeA;
		TreeNode tailA = null;

		while (nodeA.right != null) {
			nodeA = nodeA.right;
		}
		tailA = nodeA;

		tailA.right = nodeB;
		nodeB.left = tailA;

		return nodeACopy;
	}

	public static void printDoublyList(TreeNode head) {

		if (head == null) {
			System.out.println("END OF LIST \n \n ");
			return;
		}

		if (head.left != null)
			System.out.print("prev:" + head.left.value + "  ");
		else
			System.out.print("prev:" + "null" + "  ");

		System.out.print("curr:" + head.value + "  ");

		if (head.right != null)
			System.out.print("right:" + head.right.value + "  ");
		else
			System.out.print("right:" + "null" + "  ");

		System.out.println();

		printDoublyList(head.right);

	}

	public static void printCircularList(TreeNode head, TreeNode tail) {

		if (head == null) {
			System.out.println("END OF LIST");
			return;
		}
		if (head.left != null)
			System.out.print("prev:" + head.left.value + "  ");
		else
			System.out.print("prev:" + "null" + "  ");

		System.out.print("curr:" + head.value + "  ");

		if (head.right != null)
			System.out.print("right:" + head.right.value + "  ");
		else
			System.out.print("right:" + "null" + "  ");

		System.out.println();

		if (head != tail)
			printCircularList(head.right, tail);

	}

	@Override
	public int compareTo(TreeNode that) {
		if (this.value < that.value)
			return -1;
		else
			return 1;

	}

}
