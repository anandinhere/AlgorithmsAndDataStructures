package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class IdenticalLists {
	public static void main(String[] args) {
		LinkList listA = new LinkList();

		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(4));
		listA.addNode(new LinkedListNode(6));
		listA.addNode(new LinkedListNode(7));
		listA.addNode(new LinkedListNode(8));
		listA.addNode(new LinkedListNode(10));

		LinkList listB = new LinkList();

		listB.addNode(new LinkedListNode(2));
		listB.addNode(new LinkedListNode(4));
		listB.addNode(new LinkedListNode(6));
		listB.addNode(new LinkedListNode(7));
		listB.addNode(new LinkedListNode(8));

		listA.printLinkedList();
		listB.printLinkedList();

		System.out.println(checkIfIdentical(listA.getHead(), listB.getHead()));

	}

	private static boolean checkIfIdentical(LinkedListNode head1,
			LinkedListNode head2) {

		while (head1 != null && head2 != null) {
			if (head1.getValue() != head2.getValue())
				return false;
			head1 = head1.getNext();
			head2 = head2.getNext();
		}

		if (head1 != null || head2 != null) {
			return false;
		}

		return true;

	}
}
