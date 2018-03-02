package binarytree;

import linkedlist.doubly.AppendDoublyLinkedList;
import util.tree.TreeNode;

public class SortedDLLtoBalancedBSTEfficient {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.right = node2;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;
		node5.right = node6;

		SortedDLLtoBalancedBSTEfficient.head = node1;

		TreeNode root = convertDLLtoBST(6);
		root.printInorder(root);
	}

	static TreeNode head = null;

	private static TreeNode convertDLLtoBST(int n) {
		if (n <= 0) {
			return null;
		}

		TreeNode left = convertDLLtoBST(n / 2);
		TreeNode root = head;
		root.left = left;
		head = head.right;
		root.right = convertDLLtoBST(n - (n / 2) - 1);

		return root;
	}

}
