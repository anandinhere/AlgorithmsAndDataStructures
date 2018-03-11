package binarytree;

import util.tree.TreeNode;

public class LeastCommonAncestor {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBST();

		//root.printLevelOrder();

		System.out.println(root.getHeight(root));

		TreeNode lca = getLCA(root, 7, 6);
		System.out.println("\n" + lca.value);

	}

	private static TreeNode getLCA(TreeNode root, int i, int j) {

		if (root.value > i && root.value < j) {
			return root;
		}

		if (root.value == i || root.value == j)
			return root;

		if (root.value > i && root.value > j) {
			return getLCA(root.left, i, j);
		} else
			return getLCA(root.right, i, j);

	}
}
