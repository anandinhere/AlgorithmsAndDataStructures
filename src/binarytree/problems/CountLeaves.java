package binarytree.problems;

import util.tree.TreeNode;

public class CountLeaves {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		System.out.println(countLeaves(root));
	}

	private static int countLeaves(TreeNode root) {

		if (root == null)
			return 0;
		if (root.isLeaf())
			return 1;

		return countLeaves(root.left) + countLeaves(root.right);

	}
}
