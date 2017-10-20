package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class DeleteAlternateNodes {

	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode().getLinkedList(2);
		head.printLinkedList();
		deletealternate(head);
		head.printLinkedList();

	}

	private static void deletealternate(LinkedListNode head) {
		while (head != null && head.getNext() != null) {
			head.setNext(head.getNext().getNext());
			head = head.getNext();
		}
	}
}
