package binarytree.problems;

import java.util.Collections;
import java.util.LinkedList;

import util.tree.TreeNode;

public class SmallestNode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBST();

		TreeNode min = getMin(root);
		System.out.println(min.value);
	}

	private static TreeNode getMin(TreeNode root) {

		if (root == null)
			return null;

		if (root.isLeaf())
			return root;

		return min(root, getMin(root.left), getMin(root.right));

	}

	private static TreeNode min(TreeNode root, TreeNode left, TreeNode right) {

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root != null) {
			list.add(root);
		}
		if (left != null) {
			list.add(left);
		}
		if (right != null) {
			list.add(right);
		}

		Collections.sort(list);
		return list.getFirst();

	}
}
