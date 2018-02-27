package linkedlist.singular;

import util.linkedlist.ListNode;

public class ReverseAlternateAndAppendAtEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode().getLinkedList(10);
		head.printLinkedList();
		reverseAlternateAndAppendAtEnd(head);

	}

	private static void reverseAlternateAndAppendAtEnd(ListNode head) {

		ListNode altNodes = null;

		ListNode headCopy = head;

		while (headCopy != null && headCopy.getNext() != null) {
			ListNode secNode = headCopy.getNext();
			ListNode thirdNode = headCopy.getNext().getNext();

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

	private static ListNode reverse(ListNode head) {
		if (head == null)
			return null;

		if (head.getNext() == null)
			return head;

		ListNode second = head.getNext();

		head.setNext(null);

		ListNode reverseHead = reverse(second);

		second.setNext(head);

		return reverseHead;

	}
}
