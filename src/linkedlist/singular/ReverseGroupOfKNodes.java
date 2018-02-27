package linkedlist.singular;

import util.linkedlist.ListNode;

public class ReverseGroupOfKNodes {

	public static void main(String[] args) {

		ListNode node = new ListNode().getLinkedList(10);
		node.printLinkedList();

		ListNode reversedListHead = reverseAlternateKNodes(node, 3);

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

		
		ListNode nodeCopy = node;

		int count = 0;
		while (nodeCopy.getNext() != null && count < k) {
			nodeCopy = nodeCopy.getNext();
			count++;
		}
		ListNode kHead = reverseKNodes(node, k);
		kHead.printLinkedList();

		node.setNext(reverseAlternateKNodes(nodeCopy, k));

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
