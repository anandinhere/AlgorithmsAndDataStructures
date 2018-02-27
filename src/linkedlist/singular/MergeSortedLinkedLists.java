package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class MergeSortedLinkedLists {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(4));
		listA.addNode(new ListNode(6));
		listA.addNode(new ListNode(7));
		listA.addNode(new ListNode(8));
		listA.addNode(new ListNode(10));

		LinkList listB = new LinkList();

		listB.addNode(new ListNode(1));
		listB.addNode(new ListNode(3));
		listB.addNode(new ListNode(5));
		listB.addNode(new ListNode(11));
		listB.addNode(new ListNode(13));
		listB.addNode(new ListNode(14));

		listA.printLinkedList();
		listB.printLinkedList();

		LinkList mergedList = getSortedMergedList(listA.getHead(),
				listB.getHead());

		mergedList.printLinkedList();

	}

	private static LinkList getSortedMergedList(ListNode listA,
			ListNode listB) {

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
