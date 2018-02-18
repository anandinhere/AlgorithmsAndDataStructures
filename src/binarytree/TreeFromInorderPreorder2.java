package binarytree;

import util.tree.TreeNode;

public class TreeFromInorderPreorder2 {

	static int preIndex = 0;

	public static void main(String[] args) {
//		 int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
//		 int preorder[] = new int[] { 1, 2, 4, 5, 3, 6, 7 };

		 //int preorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		int inorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int preorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode r = makeTree(inorder, preorder, 0, 0, inorder.length - 1);

		r.printInorder(r);
	}

	private static TreeNode makeTree(int[] inorder, int[] preorder, int pStart,
			int inStart, int inEnd) {

		if (inStart > inEnd) {
			return null;
		}

		// if (pStart == pEnd) {
		// return new TreeNode(preorder[pStart]);
		// }

		TreeNode root = new TreeNode(preorder[pStart]);

		int inSearch = search(root.key, inorder, inStart, inEnd);
		if (inSearch == 0)
			return root;
		int pSearch = searchPre(inorder[inSearch - 1], preorder);

		root.left = makeTree(inorder, preorder, pStart + 1, inStart,
				inSearch - 1);
		root.right = makeTree(inorder, preorder, pSearch + 1, inSearch + 1,
				inEnd);

		return root;
	}

	private static int search(int key, int[] inorder, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == key) {
				return i;
			}
		}
		return 0;
	}

	private static int searchPre(int key, int[] preorder) {
		int x = 0;
		for (int i = 0; i <= preorder.length; i++) {

			if (preorder[i] == key) {
				return i;
			}
			x++;
		}
		return 0;
	}

}
