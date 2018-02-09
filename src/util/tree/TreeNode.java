package util.tree;

public class TreeNode {

	TreeNode right;
	TreeNode left;
	int value;
	boolean black = true;
	
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

	public TreeNode insert(TreeNode root, int key) {

		if (root == null) {
			return new TreeNode(key);
		}

		if (root.value < key)
			root.left = insert(root.left, key);
		root.right = insert(root.right, key);
		return root;

	}

	public TreeNode getBasicTree() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.left.left = new TreeNode(5);
		
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		
		return node;

	}

}
