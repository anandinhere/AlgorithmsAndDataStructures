package binarytree.problems;

import util.tree.TreeNode;

public class LeafTraversalOf2TreesIsSame {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode().getBasicTree();
		TreeNode root2 = new TreeNode().getBasicTree();
		
		checkLeaf(root1,root2);
	}
	
	
	//can't do traversal and check at the same time. both trees may not have the exact same structure.
	private static boolean checkLeaf(TreeNode root1, TreeNode root2) {
		
		//if(root1.isLeaf() && !root2.isLeaf())
		
		return false;
		
	}
}
