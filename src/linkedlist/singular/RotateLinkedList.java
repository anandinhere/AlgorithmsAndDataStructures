package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class RotateLinkedList {
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode().getLinkedList(10);
		head.printLinkedList();
		head = rotateList(head, 4);

		head.printLinkedList();
	}

	private static LinkedListNode rotateList(LinkedListNode head, int k) {

		LinkedListNode headCopy = head;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		LinkedListNode tail = headCopy;

		headCopy = head;

		for (int i = 0; i < k - 1; i++) {
			headCopy = headCopy.getNext();
		}

		LinkedListNode newHead = headCopy.getNext();
		headCopy.setNext(null);

		tail.setNext(head);

		return newHead;

	}
}
