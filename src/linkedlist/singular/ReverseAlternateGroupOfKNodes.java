package linkedlist.singular;

import util.linkedlist.ListNode;

public class ReverseAlternateGroupOfKNodes {

	public static void main(String[] args) {

		ListNode node = new ListNode().getLinkedList(24);
		node.printLinkedList();

		ListNode reversedListHead = reverseAlternateKNodes(node, 6);

		reversedListHead.printLinkedList();

	}

	private static ListNode reverseAlternateKNodes(ListNode node,
			int k) {

		if (node == null) {
			return null;
		}

		if (node.getNext() == null) {
			return node;
		}

		/*
		 * Though this is a good checks, it increases complexity. Hence lines 38
		 * if (node.getSize() <= k / 2) { return reverseKNodes(node, k / 2); }
		 */

		ListNode nodeCopy = node;

		int count = 0;
		while (nodeCopy.getNext() != null && count < k / 2) {
			nodeCopy = nodeCopy.getNext();
			count++;
		}

		ListNode kHead = reverseKNodes(node, k / 2);

		kHead.printLinkedList();
		if (count < (k / 2 - 1)) { //Important stopping step
			return kHead;
		}

		node.setNext(nodeCopy);

		count = 0;
		while (nodeCopy.getNext() != null && count < (k / 2) - 1) {
			nodeCopy = nodeCopy.getNext();
			count++;
		}

		node = nodeCopy;

		node.setNext(reverseAlternateKNodes(nodeCopy.getNext(), k));

		return kHead;

	}

	private static ListNode reverseKNodes(ListNode node, int k) {
		if (node == null) {
			return null;
		}

		if (node.getNext() == null || k == 1) {
			return node;
		}

		ListNode secondNode = node.getNext();
		node.setNext(null);

		ListNode head = reverseKNodes(secondNode, k - 1);

		secondNode.setNext(node);

		return head;

	}
}
