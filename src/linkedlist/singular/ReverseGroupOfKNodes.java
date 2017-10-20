package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class ReverseGroupOfKNodes {

	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode().getLinkedList(10);
		node.printLinkedList();

		LinkedListNode reversedListHead = reverseAlternateKNodes(node, 3);

		reversedListHead.printLinkedList();

	}

	private static LinkedListNode reverseAlternateKNodes(LinkedListNode node,
			int k) {

		if (node == null) {
			return null;
		}

		if (node.getNext() == null) {
			return node;
		}

		
		LinkedListNode nodeCopy = node;

		int count = 0;
		while (nodeCopy.getNext() != null && count < k) {
			nodeCopy = nodeCopy.getNext();
			count++;
		}
		LinkedListNode kHead = reverseKNodes(node, k);
		kHead.printLinkedList();

		node.setNext(reverseAlternateKNodes(nodeCopy, k));

		return kHead;

	}

	private static LinkedListNode reverseKNodes(LinkedListNode node, int k) {
		if (node == null) {
			return null;
		}

		if (node.getNext() == null || k == 1) {
			return node;
		}

		LinkedListNode secondNode = node.getNext();
		node.setNext(null);

		LinkedListNode head = reverseKNodes(secondNode, k - 1);

		secondNode.setNext(node);

		return head;

	}
}
