package binarytree;

import util.tree.TreeNode;

public class TreeFromInorderPreorder {

	static int preIndex = 0;

	public static void main(String[] args) {
		// int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		// int preorder[] = new int[] { 1, 2, 4, 5, 3, 6, 7 };

		int inorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		int preorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		// int inorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// int preorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode r = makeTree(inorder, preorder, 0, inorder.length - 1);

		r.printInorder(r);
	}

	private static TreeNode makeTree(int[] inorder, int[] preorder,
			int inStart, int inEnd) {

		if (inorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preIndex++]); //preorder tree build. so preorder++ preorder is the order of roots of trees
		// starting from root to children roots
		// if checks tell us if the node has a left or a right. 

		int inSearch = search(root.value, inorder, inStart, inEnd);

		if (inSearch != inStart) {
			root.left = makeTree(inorder, preorder, inStart, inSearch - 1);
		}

		if (inSearch != inEnd) {
			root.right = makeTree(inorder, preorder, inSearch + 1, inEnd);
		}

		return root;
	}

	private static int search(int pStart, int[] inorder, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == pStart) {
				return i;
			}
		}
		return 0;
	}

}
