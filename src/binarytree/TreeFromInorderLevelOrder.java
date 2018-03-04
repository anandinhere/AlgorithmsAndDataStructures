package binarytree;

import java.util.Map;
import util.tree.TreeNode;

public class TreeFromInorderLevelOrder {

	static int preIndex = 0;

	public static void main(String[] args) {
		int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		// int inorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		// int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		// int inorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		Map<Integer, Integer> m = new java.util.HashMap<Integer, Integer>();
		for (int i = 0; i < levelorder.length; i++) {
			m.put(levelorder[i], i);
		}

		TreeNode root = new TreeNode(levelorder[preIndex++]);
		makeTree(root, inorder, levelorder, 0, inorder.length - 1, m);

		root.printInorder(root);
	}

	private static void makeTree(TreeNode root, int[] inorder,
			int[] levelorder, int inStart, int inEnd, Map<Integer, Integer> m) {

		if (root == null) {
			return;
		}

		int inSearch = search(root.value, inorder, inStart, inEnd);

		if (inSearch != inStart) {
			int leftKey = getNode(inorder, levelorder, inStart, inSearch - 1, m);
			root.left = new TreeNode(levelorder[leftKey]);
		}

		if (inSearch != inEnd) {
			int rightKey = getNode(inorder, levelorder, inSearch + 1, inEnd, m);
			root.right = new TreeNode(levelorder[rightKey]);
		}

		makeTree(root.left, inorder, levelorder, inStart, inSearch - 1, m);
		makeTree(root.right, inorder, levelorder, inSearch + 1, inEnd, m);

		return;
	}

	private static int getNode(int[] inorder, int[] levelorder, int inStart,
			int inEnd, Map<Integer, Integer> m) {

		int min = Integer.MAX_VALUE;

		for (int i = inStart; i <= inEnd; i++) {
			if (m.get(inorder[i]) < min)
				min = m.get(inorder[i]);
		}

		return min;
	}

	private static int search(int key, int[] inorder, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == key) {
				return i;
			}
		}
		return 0;
	}

}
