package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import util.tree.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();
		printLevelOrder(root);
		

	}

	public static void printLevelOrder(TreeNode root) {

		int height = root.getHeight(root);

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			System.out.println();
			while (!q1.isEmpty()) {
				TreeNode node = q1.poll();

				// for (int i = 0; i < node.printPosition; i++) {
				// System.out.print(" ");
				// }
				System.out.print(node.value);
				// System.out.println();

				if (node.left != null) {
					node.left.printPosition = node.printPosition / 2;
					q2.add(node.left);
				}

				if (node.right != null) {
					node.right.printPosition = node.printPosition + node.printPosition / 2;
					q2.add(node.right);
				}

			}
			System.out.println();

			while (!q2.isEmpty()) {
				TreeNode node = q2.poll();
				// for (int i = 0; i < node.printPosition; i++) {
				// System.out.print(" ");
				// }
				System.out.print(node.value);
				// System.out.println();
				if (node.left != null) {
					node.left.printPosition = node.printPosition / 2;
					q1.add(node.left);
				}

				if (node.right != null) {
					node.right.printPosition = node.printPosition + node.printPosition / 2;
					q1.add(node.right);
				}

			}
			System.out.println();

		}

	}
}
