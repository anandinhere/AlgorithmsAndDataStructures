package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class RemoveDupsSortedList {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new LinkedListNode(1));
		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(3));
		listA.addNode(new LinkedListNode(6));
		listA.addNode(new LinkedListNode(6));
		listA.addNode(new LinkedListNode(9));
		listA.addNode(new LinkedListNode(9));
		// listA.addNode(new LinkedListNode(9));

		listA.printLinkedList();

		LinkedListNode headA = listA.getHead();

		while (headA.getNext() != null) {

			LinkedListNode next = headA.getNext();

			if (headA.getValue() == next.getValue()) {
				headA.setNext(headA.getNext().getNext());

			} else {
				headA = headA.getNext();
			}

		}

		listA.printLinkedList();

	}
}
