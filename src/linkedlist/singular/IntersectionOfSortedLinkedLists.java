package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class IntersectionOfSortedLinkedLists {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new LinkedListNode(2));
		listA.addNode(new LinkedListNode(4));
		listA.addNode(new LinkedListNode(6));
		listA.addNode(new LinkedListNode(7));
		listA.addNode(new LinkedListNode(8));
		listA.addNode(new LinkedListNode(10));
		listA.addNode(new LinkedListNode(13));
		listA.addNode(new LinkedListNode(14));

		LinkList listB = new LinkList();

		listB.addNode(new LinkedListNode(2));
		listB.addNode(new LinkedListNode(3));
		listB.addNode(new LinkedListNode(4));
		listB.addNode(new LinkedListNode(6));
		listB.addNode(new LinkedListNode(6));
		listB.addNode(new LinkedListNode(11));
		listB.addNode(new LinkedListNode(13));
		listB.addNode(new LinkedListNode(14));
		
		listA.printLinkedList();
		listB.printLinkedList();

		LinkList commonList = getIntersectionList(listA.getHead(),
				listB.getHead());

		commonList.printLinkedList();

	}

	private static LinkList getIntersectionList(LinkedListNode listA,
			LinkedListNode listB) {

		LinkList common = new LinkList();

		while (listA != null || listB != null) {
			if (listA.getValue() == listB.getValue()) {
				common.addNode(new LinkedListNode(listA.getValue()));
				listA = listA.getNext();
				listB = listB.getNext();

			} else if (listA.getValue() > listB.getValue()) {
				listB = listB.getNext();

			} else if (listA.getValue() < listB.getValue()) {
				listA = listA.getNext();
			}
		}

		return common;
	}
}
