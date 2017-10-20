package linkedlist.singular;

import util.linkedlist.LinkedListNode;

/*
 * This method is also dependent on Floyd’s Cycle detection algorithm.
 1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to a loop node.
 2) Count the number of nodes in loop. Let the count be k.
 3) Fix one pointer to the head and another to kth node from head.
 4) Move both pointers at the same pace, they will meet at loop starting node.
 5) Get pointer to the last node of loop and make next of it as NULL.
 */

public class LoopDetectAndRemove {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode().getLinkedList(5);
		head.printLinkedList();

		LinkedListNode headcopy = head;

		while (headcopy.getNext() != null)
			headcopy = headcopy.getNext();

		LinkedListNode tail = headcopy;

		tail.setNext(head.getNext().getNext().getNext());

		removeLoop(head);

		head.printLinkedList();

	}

	private static void removeLoop(LinkedListNode head) {

		LinkedListNode slow = head;

		LinkedListNode fast = head.getNext();

		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		int loopSize = 1;

		while (fast.getNext() != slow) {
			fast = fast.getNext();
			loopSize++;
		}

		fast = head;

		for (int i = 0; i < loopSize; i++) {
			fast = fast.getNext();
		}

		while (fast.getNext() != head.getNext()) {
			fast = fast.getNext();
			head = head.getNext();
		}

		fast.setNext(null);

	}
}
