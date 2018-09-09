package binarytree;

import java.util.Stack;

import util.tree.TreeNode;

public class PreOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		root.printPreOrder(root);

		Stack<TreeNode> s = new Stack<TreeNode>();

		printPreorder(root, s);

	}

	private static void printPreorder(TreeNode root, Stack<TreeNode> s) {

		TreeNode curr = root;
		s.push(curr);

		while (!s.isEmpty()) {

			curr = s.pop();
			System.out.print(curr.value + " ");

			if (curr.right != null) {
				s.push(curr.right);
			}

			if (curr.left != null) {
				s.push(curr.left);
			}

		}

	}
}
