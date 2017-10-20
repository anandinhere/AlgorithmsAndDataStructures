package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class MergeSortedLinkedLists {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(4));
		listA.addNode(new LinkedListNode(6));
		listA.addNode(new LinkedListNode(7));
		listA.addNode(new LinkedListNode(8));
		listA.addNode(new LinkedListNode(10));

		LinkList listB = new LinkList();

		listB.addNode(new LinkedListNode(1));
		listB.addNode(new LinkedListNode(3));
		listB.addNode(new LinkedListNode(5));
		listB.addNode(new LinkedListNode(11));
		listB.addNode(new LinkedListNode(13));
		listB.addNode(new LinkedListNode(14));

		listA.printLinkedList();
		listB.printLinkedList();

		LinkList mergedList = getSortedMergedList(listA.getHead(),
				listB.getHead());

		mergedList.printLinkedList();

	}

	private static LinkList getSortedMergedList(LinkedListNode listA,
			LinkedListNode listB) {

		LinkList mergedList = new LinkList();
		while (listA != null && listB != null) {
			if (listA.getValue() < listB.getValue()) {
				mergedList.addNode(listA);
				listA = listA.getNext();
			} else if (listA.getValue() > listB.getValue()) {
				mergedList.addNode(listB);
				listB = listB.getNext();
			} else {
				mergedList.addNode(listB);
				listA = listA.getNext();
				listB = listB.getNext();
			}
		}

		if (listA != null) {
			while (listA != null) {
				mergedList.addNode(listA);
				listA = listA.getNext();
			}

		} else if (listB != null) {
			while (listB != null) {
				mergedList.addNode(listB);
				listB = listB.getNext();
			}
		}

		return mergedList;
	}
}
