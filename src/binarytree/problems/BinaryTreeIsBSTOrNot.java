package binarytree.problems;

import util.tree.TreeNode;

public class BinaryTreeIsBSTOrNot {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBST();

		boolean isBst = checkIfBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(isBst);
	}

	//keeping track of MIN and MAX
	private static boolean checkIfBst(TreeNode root, int min, int max) {

		if (root == null)
			return true;

		if (root.value < min || root.value > max)
			return false;

		return (checkIfBst(root.left, min, root.value) && checkIfBst(root.right,
				root.value, max));

	}
}
