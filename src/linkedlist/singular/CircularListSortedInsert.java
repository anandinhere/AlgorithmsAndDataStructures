package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class CircularListSortedInsert {
	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(5));

		LinkedListNode head = list.getHead();

		head.printLinkedList();
		LinkedListNode headCopy = head;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		LinkedListNode tail = headCopy;

		tail.setNext(head);

		circularInsert(head, tail, 6);

	}

	private static LinkedListNode circularInsert(LinkedListNode head,
			LinkedListNode tail, int i) {

		if (head == null) {
			return new LinkedListNode(i);
		}

		if (i < head.getValue()) {

			LinkedListNode newHead = new LinkedListNode(i);
			newHead.setNext(head);
			tail.setNext(newHead);
			return newHead;

		} else if (i > tail.getValue()) {
			LinkedListNode newTail = new LinkedListNode(i);
			tail.setNext(newTail);
			newTail.setNext(head);
			return head;
		} else {
			LinkedListNode headCopy = head;
			while (headCopy != tail) {

				if (i < headCopy.getNext().getValue()) {
					LinkedListNode temp = headCopy.getNext();
					headCopy.setNext(new LinkedListNode(i));
					headCopy.getNext().setNext(temp);
				}

				headCopy = headCopy.getNext();
			}
		}

		return tail;

	}
}
