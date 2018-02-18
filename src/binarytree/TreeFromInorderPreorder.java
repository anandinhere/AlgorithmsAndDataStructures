package binarytree;

import util.tree.TreeNode;

public class TreeFromInorderPreorder {

	static int preIndex = 0;

	public static void main(String[] args) {
		int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		int preorder[] = new int[] { 1, 2, 4, 5, 3, 6, 7 };
		TreeNode r = makeTree(inorder, preorder, 0, preorder.length - 1, 0,
				inorder.length - 1);

		r.printInorder(r);
	}

	private static TreeNode makeTree(int[] inorder, int[] preorder, int pStart,
			int pEnd, int inStart, int inEnd) {

		if (inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preIndex++]);

		int inSearch = search(root.key, inorder, inStart, inEnd);

		root.left = makeTree(inorder, preorder, pStart, pEnd, inStart,
				inSearch - 1);
		root.right = makeTree(inorder, preorder, pStart, pEnd, inSearch + 1,
				inEnd);

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
