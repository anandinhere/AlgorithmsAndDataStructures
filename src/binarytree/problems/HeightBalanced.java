package binarytree.problems;

import util.tree.TreeNode;

public class HeightBalanced {

	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();
		root.left.left.left = new TreeNode(9);
		//root.left.left.left.left = new TreeNode(9);
		//root.left.left.left.left.left = new TreeNode(9);
		root.printLevelOrder();
		// root.printInorder(root);
		Height h = new Height();
		boolean check = checkHeightBalanced(root, h);
		System.out.println(check);
		// System.out.println(d);
	}

	private static boolean checkHeightBalanced(TreeNode root, Height h) {

		if (root == null) {
			return true;
		}
		h.h++;
		if (root.isLeaf()) {
			return true;
		}

		Height left = new Height();
		Height right = new Height();

		boolean leftCheck = checkHeightBalanced(root.left, left);
		boolean rightCheck = checkHeightBalanced(root.right, right);

		h.h = Math.max(left.h, right.h) + 1;

		return Math.abs(left.h - right.h) <= 1 && leftCheck && rightCheck;

	}
}

// class Height {
// int h;
// }
