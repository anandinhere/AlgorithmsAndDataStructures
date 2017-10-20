package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class OddEvenSegregate {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new LinkedListNode(6));
		list.addNode(new LinkedListNode(4));
		// list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		// list.addNode(new LinkedListNode(1));

		// 0 4 3 1 9 9 9 6 2 1 - not working

		LinkedListNode head = list.getHead();

		head = new LinkedListNode().getLinkedList(10);

		head.printLinkedList();

		head = segregateOddEven(head);
		head.printLinkedList();
	}

	private static LinkedListNode segregateOddEven(LinkedListNode head) {

		LinkedListNode headCopy = head;

		LinkedListNode tail = null;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		tail = headCopy;

		LinkedListNode tailCopy = tail;
		headCopy = head;

		while ((headCopy.getValue() & 1) == 0 && headCopy != tail) {

			LinkedListNode temp = headCopy;
			headCopy = headCopy.getNext();
			temp.setNext(null);

			tailCopy.setNext(temp);
			tailCopy = tailCopy.getNext();

		}
		headCopy.printLinkedList();
		// at this stage headcopy is pointing to first odd in the list.
		head = headCopy;

		while (headCopy != tail && headCopy.getNext() != tail) {
			if (((headCopy.getNext().getValue() & 1) == 0)) {

				LinkedListNode temp = headCopy.getNext();
				headCopy.setNext(headCopy.getNext().getNext());
				temp.setNext(null);
				tailCopy.setNext(temp);
				tailCopy = tailCopy.getNext();
			} else {
				headCopy = headCopy.getNext();
			}

			head.printLinkedList();

		}

		return head;

	}
}
