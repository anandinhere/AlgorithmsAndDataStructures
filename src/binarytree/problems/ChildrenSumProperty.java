package binarytree.problems;

import util.tree.TreeNode;

public class ChildrenSumProperty {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);

		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);

		System.out.println(checkChildrenSum(root));
	}

	private static boolean checkChildrenSum(TreeNode root) {

		if (root == null)
			return true;
		if (root.isLeaf())
			return true;

		int left = root.left != null ? root.left.value : 0;
		int right = root.right != null ? root.right.value : 0;

		return ((root.value == left + right) && checkChildrenSum(root.left) && checkChildrenSum(root.right));
	}
}
