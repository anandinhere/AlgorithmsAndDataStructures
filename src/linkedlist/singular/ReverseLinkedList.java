package linkedlist.singular;

import util.linkedlist.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode node = new ListNode().getLinkedList(10);
		node.printLinkedList();

		ListNode reversed = reverseLinkedList(node);

		System.out.println("hello");
		reversed.printLinkedList();
	}

	private static ListNode reverseLinkedList(ListNode node) {

		if (node == null)
			return null;
		if (node.getNext() == null)
			return node;

		ListNode secondNode = node.getNext();
		node.setNext(null);

		ListNode head = reverseLinkedList(secondNode);

		secondNode.setNext(node);

		return head;

	}
}
