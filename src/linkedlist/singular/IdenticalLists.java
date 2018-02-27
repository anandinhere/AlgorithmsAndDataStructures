package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class IdenticalLists {
	public static void main(String[] args) {
		LinkList listA = new LinkList();

		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(4));
		listA.addNode(new ListNode(6));
		listA.addNode(new ListNode(7));
		listA.addNode(new ListNode(8));
		listA.addNode(new ListNode(10));

		LinkList listB = new LinkList();

		listB.addNode(new ListNode(2));
		listB.addNode(new ListNode(4));
		listB.addNode(new ListNode(6));
		listB.addNode(new ListNode(7));
		listB.addNode(new ListNode(8));

		listA.printLinkedList();
		listB.printLinkedList();

		System.out.println(checkIfIdentical(listA.getHead(), listB.getHead()));

	}

	private static boolean checkIfIdentical(ListNode head1,
			ListNode head2) {

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
