package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode().getLinkedList(10);
		node.printLinkedList();

		LinkedListNode reversed = reverseLinkedList(node);

		System.out.println("hello");
		reversed.printLinkedList();
	}

	private static LinkedListNode reverseLinkedList(LinkedListNode node) {

		if (node == null)
			return null;
		if (node.getNext() == null)
			return node;

		LinkedListNode secondNode = node.getNext();
		node.setNext(null);

		LinkedListNode head = reverseLinkedList(secondNode);

		secondNode.setNext(node);

		return head;

	}
}
