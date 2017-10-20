package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode().getLinkedList(2);
		head.printLinkedList();
		head = deleteMAfterN(head, 3, 2);
		head.printLinkedList();
	}

	private static LinkedListNode deleteMAfterN(LinkedListNode head, int m,
			int n) {
		if (head == null) {
			return null;
		}

		if (head.getNext() == null) {
			return head;
		}

		LinkedListNode headCopy = head;

		int count = 0;
		while (headCopy.getNext() != null && count < m - 1) {
			headCopy = headCopy.getNext();
			count++;
		}

		if (headCopy.getNext() == null) {
			return head;
		}
		count = 0;
		LinkedListNode temp = headCopy;
		while (temp != null && count <= n) {
			temp = temp.getNext();
			headCopy.setNext(temp);
			count++;
		}

		headCopy.setNext(deleteMAfterN(headCopy.getNext(), m, n));

		return head;
	}
}
