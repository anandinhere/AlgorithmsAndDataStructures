package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class CountNoOfGivenInt {

	public static void main(String[] args) {

		LinkedListNode node = (new LinkedListNode()).getLinkedList(40);

		node.printLinkedList();

		int count = getNoOfInts(node, 1, 0);
		System.out.println(count);

	}

	private static int getNoOfInts(LinkedListNode node, int givenInt, int total) {

		if (node.getValue() == givenInt) {
			total++;
		}
		if (node.getNext() == null)
			return total;

		return getNoOfInts(node.getNext(), givenInt, total);

	}
}
