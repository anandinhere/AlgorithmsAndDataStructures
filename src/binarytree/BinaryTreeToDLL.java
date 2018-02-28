package binarytree;

import util.tree.TreeNode;

public class BinaryTreeToDLL {
	
	//First thoughts - make circular doubly linked list and convert it to simple dll.
	
	/*
	 * 			1
	 * 		2		3
	 *    4   5    6  7
	 */

	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();

		TreeNode head = makeDLL(root);

		TreeNode temp = head;
		while (true) {
			printDoublyNode(temp);
			temp = temp.right;
			if (temp == head)
				break;
		}
		System.out.println("**************");

	}

	private static TreeNode makeDLL(TreeNode root) {
		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			root.left = root;
			root.right = root;

			return root;
		}

		TreeNode leftHead = makeDLL(root.left);
		TreeNode rightHead = makeDLL(root.right);

		root.left = root;
		root.right = root;

		leftHead = append(leftHead, root);
		leftHead = append(leftHead, rightHead);

		return leftHead;
	}

	public static void printDoublyNode(TreeNode head) {
		if (head == null) {
			System.out.println("null");
			return;
		}

		if (head.left != null)
			System.out.print("prev:" + head.left.key + "  ");
		else
			System.out.print("prev:" + "null" + "  ");

		System.out.print("curr:" + head.key + "  ");

		if (head.right != null)
			System.out.print("right:" + head.right.key + "  ");
		else
			System.out.print("right:" + "null" + "  ");

		System.out.println();

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
