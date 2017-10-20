package util.tree;

public class TreeNode {

	TreeNode right;
	TreeNode left;
	int value;
	boolean black = true;

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
		
		
		
		return left;

	}

}
