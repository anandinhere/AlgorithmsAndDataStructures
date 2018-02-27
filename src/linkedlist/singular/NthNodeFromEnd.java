package linkedlist.singular;

import util.linkedlist.ListNode;

public class NthNodeFromEnd {

	public static void main(String[] args) {

		ListNode head = (new ListNode().getLinkedList(4));
		head.printLinkedList();

		ListNode nthNode = getNthNodeFromEnd(head, 4);
		System.out.println(nthNode.getValue());

	}

	private static ListNode getNthNodeFromEnd(ListNode head,
			int position) {
		
		//Ide is to move in n-4 positions with help of another pointer. ptr2 falls off at the end.
		ListNode ptr1 = head;
		ListNode ptr2 = head;

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
