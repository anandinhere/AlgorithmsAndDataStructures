package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class OddEvenSegregate {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new ListNode(6));
		list.addNode(new ListNode(4));
		// list.addNode(new LinkedListNode(1));
		list.addNode(new ListNode(2));
		// list.addNode(new LinkedListNode(1));

		// 0 4 3 1 9 9 9 6 2 1 - not working

		ListNode head = list.getHead();

		head = new ListNode().getLinkedList(10);

		head.printLinkedList();

		head = segregateOddEven(head);
		head.printLinkedList();
	}

	private static ListNode segregateOddEven(ListNode head) {

		ListNode headCopy = head;

		ListNode tail = null;

		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}

		tail = headCopy;

		ListNode tailCopy = tail;
		headCopy = head;

		while ((headCopy.getValue() & 1) == 0 && headCopy != tail) {

			ListNode temp = headCopy;
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

				ListNode temp = headCopy.getNext();
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
