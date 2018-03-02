package binarytree;

import util.tree.TreeNode;

public class TreeFromInorderPostorder {

	static int preIndex = 6;

	public static void main(String[] args) {
		 int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		 int postorder[] = new int[] { 4, 5, 2, 6, 7, 3, 1 };

		// int inorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		// int postorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		//int inorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		//int postorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode r = makeTree(inorder, postorder, 0, inorder.length - 1);

		r.printInorder(r);
	}

	private static TreeNode makeTree(int[] inorder, int[] postorder,
			int inStart, int inEnd) {



		TreeNode root = new TreeNode(postorder[preIndex--]);

		int inSearch = search(root.value, inorder, inStart, inEnd);

		if (inSearch != inEnd) {
			root.right = makeTree(inorder, postorder, inSearch + 1, inEnd);
		}

		if (inSearch != inStart) {
			root.left = makeTree(inorder, postorder, inStart, inSearch - 1);
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
