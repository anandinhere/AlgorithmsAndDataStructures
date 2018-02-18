package binarytree;

import java.util.Stack;

import util.tree.TreeNode;

public class InorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root;

		while (temp != null) {
			s.add(temp);
			temp = temp.left;
		}

		while (!s.empty()) {
			if (!s.empty() && temp == null) {
				temp = s.pop();
				System.err.println(temp.key);
				temp = temp.right;
				
			}

			while (temp != null) {
				s.add(temp);
				temp = temp.left;
			}

			//if (s.empty()) {
		//		break;
		//	}
		}
	}
}
