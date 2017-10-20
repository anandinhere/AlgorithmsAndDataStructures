package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class MoveLastNodeToFirst {
	public static void main(String[] args) {
		LinkedListNode listHead = new LinkedListNode().getLinkedList(10);
		listHead.printLinkedList();

		moveLastToFirst(listHead);

	}

	private static void moveLastToFirst(LinkedListNode listHead) {

		LinkedListNode slow = listHead;
		LinkedListNode fast = listHead.getNext();

		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext();
		}

		slow.setNext(null);
		fast.setNext(listHead);
		fast.printLinkedList();
	}
}
