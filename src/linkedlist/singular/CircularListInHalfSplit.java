package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class CircularListInHalfSplit {

	public static void main(String[] args) {

		LinkedListNode listA = new LinkedListNode().getLinkedList(10);
		listA.printLinkedList();

		LinkedListNode copyA = listA;

		while (copyA.getNext() != null)
			copyA = copyA.getNext();

		copyA.setNext(listA);

		LinkedListNode slow = listA;
		LinkedListNode fast = listA;

		while (fast.getNext().getNext() != listA) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		
		//this is second half (circular list)
		//listA is first half (circular list)
		LinkedListNode secondHalf = slow.getNext();
		slow.setNext(listA);
		fast.getNext().setNext(secondHalf);

	}
}
