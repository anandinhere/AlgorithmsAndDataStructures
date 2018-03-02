package binarytree;

import util.tree.TreeNode;

public class TheGreatTreeListRecursionProblem {

	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();
		root.printInorder(root);
		System.out.println();

		TreeNode head = makeList(root);

		TreeNode.printCircularList(head, head.left);

	}

	private static TreeNode makeList(TreeNode root) {
		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			root.left = root;
			root.right = root;

			return root;
		}

		TreeNode leftHead = makeList(root.left);
		TreeNode rightHead = makeList(root.right);

		root.left = root;
		root.right = root;

		leftHead = append(leftHead, root);
		leftHead = append(leftHead, rightHead);

		return leftHead;
	}

	public static TreeNode append(TreeNode nodeA, TreeNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;

		TreeNode tailA = nodeA.left;
		TreeNode tailB = nodeB.left;

		tailA.right = nodeB;
		nodeB.left = tailA;

		tailB.right = nodeA;
		nodeA.left = tailB;

		return nodeA;
	}

}
