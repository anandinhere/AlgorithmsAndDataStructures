package linkedlist.singular;

import util.linkedlist.ListNode;

public class RecursivePrintReverse {

	public static void main(String[] args) {
		ListNode listHead = new ListNode().getLinkedList(10);

		listHead.printLinkedList();

		printInReverse(listHead);
	}

	private static void printInReverse(ListNode listHead) {

		if (listHead == null)
			return;

		printInReverse(listHead.getNext());
		System.out.print(listHead.getValue());

	}
}
