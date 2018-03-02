package util.tree;

public class TreeNode {

	public TreeNode right;
	public TreeNode left;
	public int value;
	public boolean black = true;

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode(int val) {
		this.value = val;
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

		/*
		 * node.left.left = new TreeNode(4); node.left.right = new TreeNode(5);
		 * 
		 * 
		 * node.right.left = new TreeNode(6); node.right.right = new TreeNode(7);
		 */

		return node;

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

}
