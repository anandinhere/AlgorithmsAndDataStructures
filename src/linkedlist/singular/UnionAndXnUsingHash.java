package linkedlist.singular;

import java.util.HashSet;
import java.util.Hashtable;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class UnionAndXnUsingHash {

	public static void main(String[] args) {

		ListNode listA = new ListNode().getLinkedList(5);
		ListNode listB = new ListNode().getLinkedList(5);
		listA.printLinkedList();
		listB.printLinkedList();

		ListNode union = getUnion(listA, listB);
		union.printLinkedList();
		ListNode xn = getXn(listA, listB);
		xn.printLinkedList();

	}

	private static ListNode getXn(ListNode listA,
			ListNode listB) {

		HashSet<Integer> hash = new HashSet<>();
		while (listA != null) {
			hash.add(listA.getValue());
			listA = listA.getNext();
		}

		LinkList xn = new LinkList();
		while (listB != null) {
			if (hash.contains(listB.getValue())) {
				xn.addNode(new ListNode(listB.getValue()));
			}
			listB = listB.getNext();
		}

		return xn.getHead();
	}

	private static ListNode getUnion(ListNode listA,
			ListNode listB) {

		HashSet<Integer> hash = new HashSet<>();

		LinkList union = new LinkList();

		while (listA != null && listB != null) {
			if (!hash.contains(listA.getValue())) {

				union.addNode(new ListNode(listA.getValue()));
				hash.add(listA.getValue());
				listA = listA.getNext();

			} else {

				listA = listA.getNext();
			}
			if (!hash.contains(listB.getValue())) {
				union.addNode(new ListNode(listB.getValue()));
				hash.add(listB.getValue());
				listB = listB.getNext();
			} else {
				listB = listB.getNext();
			}
		}

		ListNode notEmpty = listA != null ? listA
				: (listB != null ? listB : null);

		while (notEmpty != null) {

			if (!hash.contains(notEmpty.getValue())) {
				union.addNode(new ListNode(notEmpty.getValue()));
				hash.add(notEmpty.getValue());
				notEmpty = notEmpty.getNext();
			} else {
				notEmpty = notEmpty.getNext();
			}
		}

		return union.getHead();
	}
}
