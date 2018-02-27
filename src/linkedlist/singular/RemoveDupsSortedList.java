package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class RemoveDupsSortedList {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new ListNode(1));
		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(3));
		listA.addNode(new ListNode(6));
		listA.addNode(new ListNode(6));
		listA.addNode(new ListNode(9));
		listA.addNode(new ListNode(9));
		// listA.addNode(new LinkedListNode(9));

		listA.printLinkedList();

		ListNode headA = listA.getHead();

		while (headA.getNext() != null) {

			ListNode next = headA.getNext();

			if (headA.getValue() == next.getValue()) {
				headA.setNext(headA.getNext().getNext());

			} else {
				headA = headA.getNext();
			}

		}

		listA.printLinkedList();

	}
}
