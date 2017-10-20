package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class ReverseAlternateAndAppendAtEnd {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode().getLinkedList(10);
		head.printLinkedList();
		reverseAlternateAndAppendAtEnd(head);

	}

	private static void reverseAlternateAndAppendAtEnd(LinkedListNode head) {

		LinkedListNode altNodes = null;

		LinkedListNode headCopy = head;

		while (headCopy != null && headCopy.getNext() != null) {
			LinkedListNode secNode = headCopy.getNext();
			LinkedListNode thirdNode = headCopy.getNext().getNext();

			secNode.setNext(altNodes);
			altNodes = secNode;

			headCopy.setNext(thirdNode);

			headCopy = thirdNode;
		}

		head.printLinkedList();

		altNodes.printLinkedList();

		altNodes = reverse(altNodes);

		altNodes.printLinkedList();

		headCopy = head;
		while (headCopy.getNext() != null) {
			headCopy = headCopy.getNext();
		}
		headCopy.setNext(altNodes);
		
		head.printLinkedList();

	}

	private static LinkedListNode reverse(LinkedListNode head) {
		if (head == null)
			return null;

		if (head.getNext() == null)
			return head;

		LinkedListNode second = head.getNext();

		head.setNext(null);

		LinkedListNode reverseHead = reverse(second);

		second.setNext(head);

		return reverseHead;

	}
}
