package binarytree;

import util.tree.TreeNode;

public class FullTreeFromPreorderPostorder {

	static int preIndex = 0;

	public static void main(String[] args) {
		// int postorder[] = new int[] { 4, 5, 2, 6, 7, 3, 1 };
		// int preorder[] = new int[] { 1, 2, 4, 5, 3, 6, 7 };
		//
		int preorder[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int postorder[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

		// int postorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		// int preorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		// int postorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// int preorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode r = makeTree(postorder, preorder, 0, postorder.length - 1);

		r.printInorder(r);
	}

	private static TreeNode makeTree(int[] postorder, int[] preorder,
			int inStart, int inEnd) {

		// if (inStart > inEnd || preIndex >= postorder.length) {
		// return null;
		// }

		TreeNode root = new TreeNode(preorder[preIndex++]);
		// || preIndex >= postorder.length
		if (inStart == inEnd) {
			return root;
		}

		if (preIndex == postorder.length) {
			return root;
		}

		int postSearch = search(preorder[preIndex], postorder, inStart, inEnd);

		if (postSearch <= inEnd) {
			root.left = makeTree(postorder, preorder, inStart, postSearch);
			root.right = makeTree(postorder, preorder, postSearch + 1,
					inEnd - 1);
		}

		return root;
	}

	private static int search(int key, int[] postorder, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (postorder[i] == key) {
				return i;
			}
		}
		return 0;
	}

}
