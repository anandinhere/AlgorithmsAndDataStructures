package linkedlist.singular;

import util.linkedlist.ListNode;

public class SwapKthFromBeginAndEnd {
	public static void main(String[] args) {
		ListNode head = new ListNode().getLinkedList(13);
		head.printLinkedList();

		swapKthFromBeginAndEnd(head, 3 - 1);
		head.printLinkedList();
	}

	private static void swapKthFromBeginAndEnd(ListNode head, int k) {

		ListNode curr = head;

		for (int i = 0; i < k - 1; i++) {
			curr = curr.getNext();
		}

		ListNode kprev = curr;

		curr = head;
		ListNode kcopy = kprev.getNext().getNext(); //Important - as trying to get the previous nodes

		while (kcopy.getNext() != null) {
			kcopy = kcopy.getNext();
			curr = curr.getNext();
		}

		ListNode kFromEndPrev = curr;

		System.out.println(kprev.getValue());
		System.out.println(kFromEndPrev.getValue());

		ListNode kth = kprev.getNext();
		ListNode kFromEnd = kFromEndPrev.getNext();

		ListNode kthNext = kth.getNext();
		ListNode kFromEndNext = kFromEnd.getNext();

		kprev.setNext(kFromEnd);
		kprev.getNext().setNext(kthNext);

		kFromEndPrev.setNext(kth);
		kFromEndPrev.getNext().setNext(kFromEndNext);
	}
}
