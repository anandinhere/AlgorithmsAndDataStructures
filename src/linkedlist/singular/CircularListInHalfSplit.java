package linkedlist.singular;

import util.linkedlist.ListNode;

public class CircularListInHalfSplit {

	public static void main(String[] args) {

		ListNode listA = new ListNode().getLinkedList(10);
		listA.printLinkedList();

		ListNode copyA = listA;

		while (copyA.getNext() != null)
			copyA = copyA.getNext();

		copyA.setNext(listA);

		ListNode slow = listA;
		ListNode fast = listA;

		while (fast.getNext().getNext() != listA) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		
		//this is second half (circular list)
		//listA is first half (circular list)
		ListNode secondHalf = slow.getNext();
		slow.setNext(listA);
		fast.getNext().setNext(secondHalf);

	}
}
