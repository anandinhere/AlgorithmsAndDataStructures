package linkedlist.singular;

import util.linkedlist.ListNode;


//Key is to delete current node. Dont try to delete next node

public class DeleteNodeGreaterValuesOnRightSide {

	public static void main(String[] args) {

		ListNode head = new ListNode().getLinkedList(5);

		head.printLinkedList();

		ListNode reverseHead = reverse(head);

		reverseHead.printLinkedList();

		deleteGreaterNodesOnRightSide(reverseHead);

		reverseHead.printLinkedList();

		ListNode finalResultHead = reverse(reverseHead);
		finalResultHead.printLinkedList();

	}

	private static void deleteGreaterNodesOnRightSide(ListNode reverseHead) {

		int max = reverseHead.getValue();

		ListNode prev = reverseHead;
		ListNode curr = reverseHead.getNext();

		while (curr != null) {

			int currValue = curr.getValue();

			if (currValue < max) {
				prev.setNext(curr.getNext());
				curr = curr.getNext();

			} else {
				max = currValue;
				prev = curr;
				curr = curr.getNext();
			}
		}

	}

	private static ListNode reverse(ListNode head) {

		if (head == null)
			return null;

		if (head.getNext() == null)
			return head;

		ListNode next = head.getNext();
		head.setNext(null);

		ListNode reverseHead = reverse(next);

		next.setNext(head);

		return reverseHead;
	}
}
