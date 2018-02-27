package linkedlist.singular;

import util.linkedlist.ListNode;

public class CountNoOfGivenInt {

	public static void main(String[] args) {

		ListNode node = (new ListNode()).getLinkedList(40);

		node.printLinkedList();

		int count = getNoOfInts(node, 1, 0);
		System.out.println(count);

	}

	private static int getNoOfInts(ListNode node, int givenInt, int total) {

		if (node.getValue() == givenInt) {
			total++;
		}
		if (node.getNext() == null)
			return total;

		return getNoOfInts(node.getNext(), givenInt, total);

	}
}
