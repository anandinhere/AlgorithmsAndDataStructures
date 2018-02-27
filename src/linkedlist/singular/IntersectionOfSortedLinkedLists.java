package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class IntersectionOfSortedLinkedLists {

	public static void main(String[] args) {

		LinkList listA = new LinkList();

		listA.addNode(new ListNode(2));
		listA.addNode(new ListNode(4));
		listA.addNode(new ListNode(6));
		listA.addNode(new ListNode(7));
		listA.addNode(new ListNode(8));
		listA.addNode(new ListNode(10));
		listA.addNode(new ListNode(13));
		listA.addNode(new ListNode(14));

		LinkList listB = new LinkList();

		listB.addNode(new ListNode(2));
		listB.addNode(new ListNode(3));
		listB.addNode(new ListNode(4));
		listB.addNode(new ListNode(6));
		listB.addNode(new ListNode(6));
		listB.addNode(new ListNode(11));
		listB.addNode(new ListNode(13));
		listB.addNode(new ListNode(14));
		
		listA.printLinkedList();
		listB.printLinkedList();

		LinkList commonList = getIntersectionList(listA.getHead(),
				listB.getHead());

		commonList.printLinkedList();

	}

	private static LinkList getIntersectionList(ListNode listA,
			ListNode listB) {

		LinkList common = new LinkList();

		while (listA != null || listB != null) {
			if (listA.getValue() == listB.getValue()) {
				common.addNode(new ListNode(listA.getValue()));
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
