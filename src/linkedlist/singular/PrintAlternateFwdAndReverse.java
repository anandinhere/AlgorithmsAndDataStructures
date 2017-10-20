package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class PrintAlternateFwdAndReverse {

	public static void main(String[] args) {

		LinkedListNode list = new LinkedListNode().getLinkedList(10);
		list.printLinkedList();
		printAlternate(list);

	}

	private static void printAlternate(LinkedListNode node) {

		if (node == null)
			return;

		System.out.print(node.getValue() + " ");

		if (node.getNext() != null)
			printAlternate(node.getNext().getNext());
		System.out.print(node.getValue() + " ");

	}
}
