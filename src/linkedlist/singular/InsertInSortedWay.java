package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class InsertInSortedWay {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(5));

		list.printLinkedList();

		addInSortedWay(list, 3);
		list.printLinkedList();
	}

	private static void addInSortedWay(LinkList list, int i) {

		LinkedListNode head = list.getHead();

		while (head.getNext() != null) {

			LinkedListNode next = head.getNext();
			if (i >= head.getValue() && i <= next.getValue()) {

				LinkedListNode newNode = new LinkedListNode(i);
				newNode.setNext(next);
				head.setNext(newNode);

				return;
			}
			head = head.getNext();
		}

		head.setNext(new LinkedListNode(i));

	}
}
