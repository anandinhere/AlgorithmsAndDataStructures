package linkedlist.singular;

import util.linkedlist.ListNode;

public class MoveLastNodeToFirst {
	public static void main(String[] args) {
		ListNode listHead = new ListNode().getLinkedList(10);
		listHead.printLinkedList();

		moveLastToFirst(listHead);

	}

	private static void moveLastToFirst(ListNode listHead) {

		ListNode slow = listHead;
		ListNode fast = listHead.getNext();

		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext();
		}

		slow.setNext(null);
		fast.setNext(listHead);
		fast.printLinkedList();
	}
}
