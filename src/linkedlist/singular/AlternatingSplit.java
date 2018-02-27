package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class AlternatingSplit {
	public static void main(String[] args) {
		ListNode mainList = new ListNode().getLinkedList(6);
		mainList.printLinkedList();

		splitAlternating(mainList);

	}

	private static void splitAlternating(ListNode mainList) {

		LinkList listA = new LinkList();
		LinkList listB = new LinkList();

		while (mainList != null) {

			listA.addNode(mainList);

			if (mainList.getNext() != null) {
				listB.addNode(mainList.getNext());
				mainList = mainList.getNext().getNext();
			} else
				mainList = null;

			listA.getTail().setNext(null);
			listB.getTail().setNext(null);

		}

		listA.printLinkedList();
		listB.printLinkedList();
	}
}
