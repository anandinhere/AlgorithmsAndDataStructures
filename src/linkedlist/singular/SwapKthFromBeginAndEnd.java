package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class SwapKthFromBeginAndEnd {
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode().getLinkedList(13);
		head.printLinkedList();

		swapKthFromBeginAndEnd(head, 3 - 1);
		head.printLinkedList();
	}

	private static void swapKthFromBeginAndEnd(LinkedListNode head, int k) {

		LinkedListNode curr = head;

		for (int i = 0; i < k - 1; i++) {
			curr = curr.getNext();
		}

		LinkedListNode kprev = curr;

		curr = head;
		LinkedListNode kcopy = kprev.getNext().getNext(); //Important - as trying to get the previous nodes

		while (kcopy.getNext() != null) {
			kcopy = kcopy.getNext();
			curr = curr.getNext();
		}

		LinkedListNode kFromEndPrev = curr;

		System.out.println(kprev.getValue());
		System.out.println(kFromEndPrev.getValue());

		LinkedListNode kth = kprev.getNext();
		LinkedListNode kFromEnd = kFromEndPrev.getNext();

		LinkedListNode kthNext = kth.getNext();
		LinkedListNode kFromEndNext = kFromEnd.getNext();

		kprev.setNext(kFromEnd);
		kprev.getNext().setNext(kthNext);

		kFromEndPrev.setNext(kth);
		kFromEndPrev.getNext().setNext(kFromEndNext);
	}
}
