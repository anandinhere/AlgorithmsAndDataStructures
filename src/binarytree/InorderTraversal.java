package binarytree;

import java.util.Stack;

import util.tree.TreeNode;

public class InorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode().getBasicTree();

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root;

		while (temp != null) { //Go all the way to left most bottom node and keep adding to stack.
			s.add(temp);
			temp = temp.left;
		}

		while (!s.empty()) {
			if (!s.empty() && temp == null) {
				temp = s.pop();
				System.out.println(temp.value);
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
