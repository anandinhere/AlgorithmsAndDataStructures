package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class SwapGivenKeysInListOnlyLinks {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new ListNode(0));
		list.addNode(new ListNode(1));
		list.addNode(new ListNode(2));
		list.addNode(new ListNode(3));
		list.addNode(new ListNode(4));
		list.addNode(new ListNode(5));
		list.addNode(new ListNode(6));

		list.printLinkedList();

		ListNode head = swapKeysOnlyLinks(list.getHead(), 1, 5);

		head.printLinkedList();

	}

	private static ListNode swapKeysOnlyLinks(ListNode head, int i,
			int j) {

		if (i == head.getValue() && j == head.getValue()) {
			return head;
		}

		ListNode headCopy = head;
		if (i == head.getValue() || j == head.getValue()) {

			if (i == headCopy.getValue()) {

				while (headCopy.getNext().getValue() != j) {
					headCopy = headCopy.getNext();
				}

				ListNode jprev = headCopy;
				ListNode jnode = headCopy.getNext();
				ListNode jnext = headCopy.getNext().getNext();

				ListNode inext = head.getNext();
				ListNode inode = head;

				jprev.setNext(inode);
				jprev.getNext().setNext(jnext);

				jnode.setNext(inext);

				jnode.printLinkedList();

				return jnode;

			}
		}

		else {
			while (headCopy.getNext().getValue() != j) {
				headCopy = headCopy.getNext();
			}

			ListNode jprev = headCopy;
			ListNode jnode = headCopy.getNext();
			ListNode jnext = headCopy.getNext().getNext();

			headCopy = head;

			while (headCopy.getNext().getValue() != i) {
				headCopy = headCopy.getNext();
			}
			ListNode iprev = headCopy;
			ListNode inode = headCopy.getNext();
			ListNode inext = headCopy.getNext().getNext();

			jprev.setNext(inode);
			jprev.getNext().setNext(jnext);

			iprev.setNext(jnode);
			iprev.getNext().setNext(inext);

			jnode.printLinkedList();

			return head;

		}

		return null;

	}

}
