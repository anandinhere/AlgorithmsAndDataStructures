package linkedlist.singular;

import util.linkedlist.ListNode;

public class DeleteGivenNode {

	public static void main(String[] args) {

		ListNode node = (new ListNode()).getLinkedList(10);

		node.printLinkedList();

		ListNode givenNode = NthNodeInLinkedList.getNthElement(node, 5);
		System.out.println("Node to delete " + givenNode.getValue());

		deleteGivenNode(givenNode);
		node.printLinkedList();

	}

	private static void deleteGivenNode(ListNode givenNode) {

		givenNode.setValue(givenNode.getNext().getValue());
		givenNode.setNext(givenNode.getNext().getNext());

	}

}
