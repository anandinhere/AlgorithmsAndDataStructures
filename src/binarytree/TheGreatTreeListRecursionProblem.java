package binarytree;

import util.linkedlist.ListNode;
import util.tree.TreeNode;

public class TheGreatTreeListRecursionProblem {

	public static void main(String[] args) {

		TreeNode root = new TreeNode().getBasicTree();

		ListNode head = makeList(root);

	}

	private static ListNode makeList(TreeNode root) {
		if (root == null)
			return null;

		ListNode head = null;

		ListNode leftHead = makeList(root.left);
		ListNode rightHead = makeList(root.right);

		if (leftHead == null && rightHead == null) {
			head = new ListNode();
			head.value = root.key;
			head.previous = head;
			head.next = head;

			return head;
		}

		head = new ListNode();
		head.value = root.key;

		head = append(leftHead, head);
		head = append(head, rightHead);

		return head;
	}

	private static ListNode append(ListNode leftHead, ListNode head) {

		ListNode temp = leftHead;
		while (temp.next != temp) {
			temp = temp.next;
		}
		
		head.next = temp.next;
		temp.next=head;
		head.previous = temp;
		

		return null;
	}
}
