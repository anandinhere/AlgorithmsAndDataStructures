package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class InsertInSortedWay {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new ListNode(0));
		list.addNode(new ListNode(1));
		list.addNode(new ListNode(2));
		list.addNode(new ListNode(5));

		list.printLinkedList();

		addInSortedWay(list, 3);
		list.printLinkedList();
	}

	private static void addInSortedWay(LinkList list, int i) {

		ListNode head = list.getHead();

		while (head.getNext() != null) {

			ListNode next = head.getNext();
			if (i >= head.getValue() && i <= next.getValue()) {

				ListNode newNode = new ListNode(i);
				newNode.setNext(next);
				head.setNext(newNode);

				return;
			}
			head = head.getNext();
		}

		head.setNext(new ListNode(i));

	}
}
