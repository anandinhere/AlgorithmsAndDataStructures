package binarytree.problems;

import util.tree.TreeNode;
import java.lang.Math;

public class HeightOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		int height = getHeight(root);
		System.out.println(height);
	}

	private static int getHeight(TreeNode root) {

		if (root == null)
			return 0;
		if (root.isLeaf())
			return 1;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

	}
}
