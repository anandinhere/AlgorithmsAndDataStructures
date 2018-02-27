package linkedlist.singular;

import util.linkedlist.ListNode;

public class PrintAlternateFwdAndReverse {

	public static void main(String[] args) {

		ListNode list = new ListNode().getLinkedList(10);
		list.printLinkedList();
		printAlternate(list);

	}

	private static void printAlternate(ListNode node) {

		if (node == null)
			return;

		System.out.print(node.getValue() + " ");

		if (node.getNext() != null)
			printAlternate(node.getNext().getNext());
		System.out.print(node.getValue() + " ");

	}
}
