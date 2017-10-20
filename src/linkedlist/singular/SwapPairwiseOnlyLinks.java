package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class SwapPairwiseOnlyLinks {
	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode().getLinkedList(10);
		head.printLinkedList();

		head = pairwiseSwapLinks(head);
		head.printLinkedList();
	}

	private static LinkedListNode pairwiseSwapLinks(LinkedListNode head) {

		if (head == null)
			return null;
		if (head.getNext() == null) {
			return head;
		}

		LinkedListNode first = head;
		LinkedListNode second = head.getNext();

		LinkedListNode third = pairwiseSwapLinks(head.getNext().getNext());

		second.setNext(first);
		first.setNext(third);
		return second;
	}
}
