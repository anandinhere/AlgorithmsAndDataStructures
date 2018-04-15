package binarytree.problems;

import util.tree.TreeNode;

public class MirrorTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();
		mirrorTree(root);
		root.printLevelOrder();
	}

	private static void mirrorTree(TreeNode root) {

		if (root == null)
			return;
		if (root.isLeaf())
			return;
		TreeNode temp = root.left;

		root.left = root.right;
		root.right = temp;

		mirrorTree(root.left);
		mirrorTree(root.right);
		// return root;
	}
}
