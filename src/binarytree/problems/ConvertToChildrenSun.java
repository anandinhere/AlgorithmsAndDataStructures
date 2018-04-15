package binarytree.problems;

import util.tree.TreeNode;

public class ConvertToChildrenSun {
	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();

		root.printLevelOrder();
		convert(root);

		root.printLevelOrder();
	}

	private static void convert(TreeNode root) {

		if (root == null)
			return;

		if (root.isLeaf())
			return;

		convert(root.left);
		convert(root.right);

		int left = root.left != null ? root.left.value : 0;
		int right = root.right != null ? root.right.value : 0;

		int diff = left + right - root.value;

		if (diff >= 0) {
			root.value = root.value + diff;
		} else if (diff < 0) {
			increment(root, Math.abs(diff));
		}

	}

	private static void increment(TreeNode root, int diff) {

		if (root.left != null) {
			root.left.value += diff;
			increment(root.left, diff);
		} else if (root.right != null) {
			root.right.value += diff;
			increment(root.right, diff);
		}

	}
}
