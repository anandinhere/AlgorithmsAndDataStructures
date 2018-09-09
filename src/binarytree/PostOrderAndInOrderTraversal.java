package binarytree;

import java.util.Stack;

import util.tree.TreeNode;

public class PostOrderAndInOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		root.printPostOrder(root);

		Stack<TreeNode> s = new Stack<TreeNode>();

		printPostOrder(root, s);

		System.out.println();
		printInOrder(root);

		System.out.println("done");

	}

	private static void printInOrder(TreeNode root) {
		root.printInorder(root);

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		s.push(curr);

		while (!s.isEmpty()) {

			TreeNode peek = s.peek();
			while (true) {

				if (peek.left == null) {
					break;
				}
				s.push(peek.left);
				peek = s.peek();
			}

			curr = s.pop();
			System.out.print(curr.value + " ");

			while (curr != null) {
				if (curr.right != null) {
					curr = curr.right;
					s.push(curr);
					break;
				} else {
					if (s.isEmpty()) {
						break;
					}
					curr = s.pop();
					System.out.print(curr.value + " ");
				}
				
			}

		}

	}

	private static void printPostOrder(TreeNode root, Stack<TreeNode> s) {

		TreeNode curr = root;
		s.push(curr);

		Stack<Integer> s2 = new Stack<Integer>();

		while (!s.isEmpty()) {

			curr = s.pop();
			s2.push(curr.value);

			if (curr.left != null) {
				s.push(curr.left);
			}
			if (curr.right != null) {
				s.push(curr.right);
			}

		}

		while (!s2.isEmpty()) {
			System.out.print(s2.pop() + " ");
		}

	}
}
