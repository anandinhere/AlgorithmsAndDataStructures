package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class RecursivePrintReverse {

	public static void main(String[] args) {
		LinkedListNode listHead = new LinkedListNode().getLinkedList(10);

		listHead.printLinkedList();

		printInReverse(listHead);
	}

	private static void printInReverse(LinkedListNode listHead) {

		if (listHead == null)
			return;

		printInReverse(listHead.getNext());
		System.out.print(listHead.getValue());

	}
}
