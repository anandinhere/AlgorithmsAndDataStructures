package linkedlist.singular;

import util.linkedlist.ListNode;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		ListNode head = new ListNode().getLinkedList(2);
		head.printLinkedList();
		head = deleteMAfterN(head, 3, 2);
		head.printLinkedList();
	}

	private static ListNode deleteMAfterN(ListNode head, int m,
			int n) {
		if (head == null) {
			return null;
		}

		if (head.getNext() == null) {
			return head;
		}

		ListNode headCopy = head;

		int count = 0;
		while (headCopy.getNext() != null && count < m - 1) {
			headCopy = headCopy.getNext();
			count++;
		}

		if (headCopy.getNext() == null) {
			return head;
		}
		count = 0;
		ListNode temp = headCopy;
		while (temp != null && count <= n) {
			temp = temp.getNext();
			headCopy.setNext(temp);
			count++;
		}

		headCopy.setNext(deleteMAfterN(headCopy.getNext(), m, n));

		return head;
	}
}
