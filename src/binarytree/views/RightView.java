package binarytree.views;

import util.tree.TreeNode;

public class RightView {
	public static void main(String[] args) {
		TreeNode r = new TreeNode().getBasicTree();

		Integer maxLevel = new Integer(-1);

		printLeftView(r, 0, new Max(-1));
	}

	private static void printLeftView(TreeNode r, int level, Max max) {

		if (r == null) {
			return;
		}

		if (level > max.val) {

			System.out.println(r.value);
			max.val = level;
			System.out.println("level " + level + "  maxlevel " + max.val);
		}

		printLeftView(r.right, level + 1, max);
		printLeftView(r.left, level + 1, max);
		

	}

	static class Max {
		public Max(int val) {
			this.val = val;
		}

		int val;
	}
}
