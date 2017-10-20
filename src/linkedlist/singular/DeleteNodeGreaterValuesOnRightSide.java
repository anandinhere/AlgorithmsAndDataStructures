package linkedlist.singular;

import util.linkedlist.LinkedListNode;


//Key is to delete current node. Dont try to delete next node

public class DeleteNodeGreaterValuesOnRightSide {

	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode().getLinkedList(5);

		head.printLinkedList();

		LinkedListNode reverseHead = reverse(head);

		reverseHead.printLinkedList();

		deleteGreaterNodesOnRightSide(reverseHead);

		reverseHead.printLinkedList();

		LinkedListNode finalResultHead = reverse(reverseHead);
		finalResultHead.printLinkedList();

	}

	private static void deleteGreaterNodesOnRightSide(LinkedListNode reverseHead) {

		int max = reverseHead.getValue();

		LinkedListNode prev = reverseHead;
		LinkedListNode curr = reverseHead.getNext();

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

	private static LinkedListNode reverse(LinkedListNode head) {

		if (head == null)
			return null;

		if (head.getNext() == null)
			return head;

		LinkedListNode next = head.getNext();
		head.setNext(null);

		LinkedListNode reverseHead = reverse(next);

		next.setNext(head);

		return reverseHead;
	}
}
