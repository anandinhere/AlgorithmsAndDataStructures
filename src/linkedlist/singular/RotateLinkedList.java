package linkedlist.singular;

import util.linkedlist.ListNode;

public class RotateLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode().getLinkedList(10);
		head.printLinkedList();
		head = rotateList(head, 4);

		head.printLinkedList();
	}

	private static ListNode rotateList(ListNode head, int k) {

		ListNode headCopy = head;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		ListNode tail = headCopy;

		headCopy = head;

		for (int i = 0; i < k - 1; i++) {
			headCopy = headCopy.getNext();
		}

		ListNode newHead = headCopy.getNext();
		headCopy.setNext(null);

		tail.setNext(head);

		return newHead;

	}
}
