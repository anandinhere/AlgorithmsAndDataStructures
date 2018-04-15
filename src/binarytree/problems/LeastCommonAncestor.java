package binarytree.problems;

import util.tree.TreeNode;

public class LeastCommonAncestor {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBST();

		TreeNode root1 = new TreeNode().getBasicTree();

		TreeNode rootBT = getLCAforBT(root1, 6, 7);

		rootBT.printLevelOrder();
		System.out.println(rootBT.value);

		//System.out.println(root.getHeight(root));

		//TreeNode lca = getLCA(rootBT, 6, 7);
		//System.out.println(lca.value);

	}

	private static TreeNode getLCAforBT(TreeNode root, int i, int j) {

		if(root==null) return null;
		

		
		if (root.value == i || root.value == j) {
			return root;
		}
		

		TreeNode leftRoot = getLCAforBT(root.left, i, j);
		TreeNode rightRoot = getLCAforBT(root.right, i, j);

		if(leftRoot!=null && rightRoot!=null){
			return root;
		}
		else{
			return leftRoot==null?rightRoot:leftRoot;
		}
	}

	private static TreeNode getLCA(TreeNode root, int i, int j) {

		if (root.value > i && root.value < j) {
			return root;
		}

		if (root.value == i || root.value == j)
			return root;

		if (root.value > i && root.value > j) {
			return getLCA(root.left, i, j);
		} else
			return getLCA(root.right, i, j);

	}
}
