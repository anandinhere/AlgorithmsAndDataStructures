package util.tree;

public class TreeNode {

	public TreeNode right;
	public TreeNode left;
	public int key;
	public boolean black = true;

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode(int val) {
		this.key = val;
	}

	public TreeNode search(TreeNode root, int key) {

		if (root == null || root.key == key) {
			return root;
		}

		if (root.key < key)
			return search(root.left, key);
		return search(root.right, key);

	}

	public void printInorder(TreeNode r) {

		if (r == null) {
			return;
		}
		printInorder(r.left);
		System.out.println(r.key);
		printInorder(r.right);
	}

	public TreeNode insert(TreeNode root, int key) {

		if (root == null) {
			return new TreeNode(key);
		}

		if (root.key < key)
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
		
		
		/*node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);

		
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);*/

		return node;

	}

}
