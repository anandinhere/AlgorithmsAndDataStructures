package binarytree.problems;

import util.tree.TreeNode;

public class Diameter {

	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();
		root.printLevelOrder();
		// root.printInorder(root);
		Height h = new Height();
		int d = findDiamater(root, h);
		System.out.println(h.h);
		System.out.println(d);
	}

	private static int findDiamater(TreeNode root, Height h) {

		if (root == null) {
			return 0;
		}
		h.h++;
		if (root.isLeaf()) {
			return 1;
		}

		Height left = new Height();
		Height right = new Height();

		int leftD = findDiamater(root.left, left);
		int rightD = findDiamater(root.right, right);

		h.h = Math.max(left.h, right.h) + 1;

		return Math.max(Math.max(leftD, rightD), left.h + right.h + 1);

	}
}
class Height {
	int h;
}

 
