package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class DeleteGivenNode {

	public static void main(String[] args) {

		LinkedListNode node = (new LinkedListNode()).getLinkedList(10);

		node.printLinkedList();

		LinkedListNode givenNode = NthNodeInLinkedList.getNthElement(node, 5);
		System.out.println("Node to delete " + givenNode.getValue());

		deleteGivenNode(givenNode);
		node.printLinkedList();

	}

	private static void deleteGivenNode(LinkedListNode givenNode) {

		givenNode.setValue(givenNode.getNext().getValue());
		givenNode.setNext(givenNode.getNext().getNext());

	}

}
