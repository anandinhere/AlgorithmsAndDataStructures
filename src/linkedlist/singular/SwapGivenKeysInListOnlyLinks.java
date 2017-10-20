package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class SwapGivenKeysInListOnlyLinks {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(3));
		list.addNode(new LinkedListNode(4));
		list.addNode(new LinkedListNode(5));
		list.addNode(new LinkedListNode(6));

		list.printLinkedList();

		LinkedListNode head = swapKeysOnlyLinks(list.getHead(), 1, 5);

		head.printLinkedList();

	}

	private static LinkedListNode swapKeysOnlyLinks(LinkedListNode head, int i,
			int j) {

		if (i == head.getValue() && j == head.getValue()) {
			return head;
		}

		LinkedListNode headCopy = head;
		if (i == head.getValue() || j == head.getValue()) {

			if (i == headCopy.getValue()) {

				while (headCopy.getNext().getValue() != j) {
					headCopy = headCopy.getNext();
				}

				LinkedListNode jprev = headCopy;
				LinkedListNode jnode = headCopy.getNext();
				LinkedListNode jnext = headCopy.getNext().getNext();

				LinkedListNode inext = head.getNext();
				LinkedListNode inode = head;

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

			LinkedListNode jprev = headCopy;
			LinkedListNode jnode = headCopy.getNext();
			LinkedListNode jnext = headCopy.getNext().getNext();

			headCopy = head;

			while (headCopy.getNext().getValue() != i) {
				headCopy = headCopy.getNext();
			}
			LinkedListNode iprev = headCopy;
			LinkedListNode inode = headCopy.getNext();
			LinkedListNode inext = headCopy.getNext().getNext();

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
