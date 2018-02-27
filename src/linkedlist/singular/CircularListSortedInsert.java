package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class CircularListSortedInsert {
	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new ListNode(0));
		list.addNode(new ListNode(1));
		list.addNode(new ListNode(2));
		list.addNode(new ListNode(5));

		ListNode head = list.getHead();

		head.printLinkedList();
		ListNode headCopy = head;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		ListNode tail = headCopy;

		tail.setNext(head);

		circularInsert(head, tail, 6);

	}

	private static ListNode circularInsert(ListNode head,
			ListNode tail, int i) {

		if (head == null) {
			return new ListNode(i);
		}

		if (i < head.getValue()) {

			ListNode newHead = new ListNode(i);
			newHead.setNext(head);
			tail.setNext(newHead);
			return newHead;

		} else if (i > tail.getValue()) {
			ListNode newTail = new ListNode(i);
			tail.setNext(newTail);
			newTail.setNext(head);
			return head;
		} else {
			ListNode headCopy = head;
			while (headCopy != tail) {

				if (i < headCopy.getNext().getValue()) {
					ListNode temp = headCopy.getNext();
					headCopy.setNext(new ListNode(i));
					headCopy.getNext().setNext(temp);
				}

				headCopy = headCopy.getNext();
			}
		}

		return tail;

	}
}
