package linkedlist.singular;

import util.linkedlist.ListNode;

public class DeleteAlternateNodes {

	public static void main(String[] args) {

		ListNode head = new ListNode().getLinkedList(2);
		head.printLinkedList();
		deletealternate(head);
		head.printLinkedList();

	}

	private static void deletealternate(ListNode head) {
		while (head != null && head.getNext() != null) {
			head.setNext(head.getNext().getNext());
			head = head.getNext();
		}
	}
}
