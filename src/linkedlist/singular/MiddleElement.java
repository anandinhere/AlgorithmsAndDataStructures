package linkedlist.singular;

import util.linkedlist.ListNode;

public class MiddleElement {

	public static void main(String[] args) {
		ListNode node = (new ListNode()).getLinkedList(10);
		node.printLinkedList();

		ListNode midNode = getMiddle(node);
		System.out.println("midNode - " + midNode.getValue());

	}

	public static ListNode getMiddle(ListNode node) {

		ListNode nodeA = node;
		ListNode nodeB = node;

		while (nodeB.getNext() != null && nodeB.getNext().getNext() != null ) {
			nodeA = nodeA.getNext();
			nodeB = nodeB.getNext().getNext();
		}

		return nodeA;
	}
}
