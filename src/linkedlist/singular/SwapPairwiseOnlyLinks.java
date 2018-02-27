package linkedlist.singular;

import util.linkedlist.ListNode;

public class SwapPairwiseOnlyLinks {
	public static void main(String[] args) {

		ListNode head = new ListNode().getLinkedList(10);
		head.printLinkedList();

		head = pairwiseSwapLinks(head);
		head.printLinkedList();
	}

	private static ListNode pairwiseSwapLinks(ListNode head) {

		if (head == null)
			return null;
		if (head.getNext() == null) {
			return head;
		}

		ListNode first = head;
		ListNode second = head.getNext();

		ListNode third = pairwiseSwapLinks(head.getNext().getNext());

		second.setNext(first);
		first.setNext(third);
		return second;
	}
}
