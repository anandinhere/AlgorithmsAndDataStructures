package binarytree;

import util.tree.TreeNode;

public class SortedDLLtoBalancedBSTEfficient {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		

		TreeNode.appendTreeList(node1, node2);
		TreeNode.appendTreeList(node1, node3);
		TreeNode.appendTreeList(node1, node4);
		TreeNode.appendTreeList(node1, node5);
		TreeNode.appendTreeList(node1, node6);
		
//		TreeNode node7 = new TreeNode(7);
//		TreeNode.appendTreeList(node1, node7);
		
//		TreeNode node8 = new TreeNode(8);
//		TreeNode.appendTreeList(node1, node8);
		
//		TreeNode node9 = new TreeNode(9);
//		TreeNode.appendTreeList(node1, node9);

		TreeNode.printDoublyList(node1);
		
		//node1.printInorder(node1); Wont work, as node's right child's left is pointing back to node.

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
		head = root.right;
		root.right = convertDLLtoBST(n - (n / 2) - 1);

		return root;
	}

}
