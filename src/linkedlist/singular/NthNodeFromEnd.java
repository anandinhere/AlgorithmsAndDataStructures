package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class NthNodeFromEnd {

	public static void main(String[] args) {

		LinkedListNode head = (new LinkedListNode().getLinkedList(4));
		head.printLinkedList();

		LinkedListNode nthNode = getNthNodeFromEnd(head, 4);
		System.out.println(nthNode.getValue());

	}

	private static LinkedListNode getNthNodeFromEnd(LinkedListNode head,
			int position) {
		
		//Ide is to move in n-4 positions with help of another pointer. ptr2 falls off at the end.
		LinkedListNode ptr1 = head;
		LinkedListNode ptr2 = head;

		for (int i = 1; i <= position; i++) {
			ptr2 = ptr2.getNext();
		}

		while (ptr2 != null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}

		return ptr1;
	}
}
