package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class MiddleElement {

	public static void main(String[] args) {
		LinkedListNode node = (new LinkedListNode()).getLinkedList(10);
		node.printLinkedList();

		LinkedListNode midNode = getMiddle(node);
		System.out.println("midNode - " + midNode.getValue());

	}

	public static LinkedListNode getMiddle(LinkedListNode node) {

		LinkedListNode nodeA = node;
		LinkedListNode nodeB = node;

		while (nodeB.getNext() != null && nodeB.getNext().getNext() != null ) {
			nodeA = nodeA.getNext();
			nodeB = nodeB.getNext().getNext();
		}

		return nodeA;
	}
}
