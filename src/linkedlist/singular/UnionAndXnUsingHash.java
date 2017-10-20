package linkedlist.singular;

import java.util.HashSet;
import java.util.Hashtable;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class UnionAndXnUsingHash {

	public static void main(String[] args) {

		LinkedListNode listA = new LinkedListNode().getLinkedList(5);
		LinkedListNode listB = new LinkedListNode().getLinkedList(5);
		listA.printLinkedList();
		listB.printLinkedList();

		LinkedListNode union = getUnion(listA, listB);
		union.printLinkedList();
		LinkedListNode xn = getXn(listA, listB);
		xn.printLinkedList();

	}

	private static LinkedListNode getXn(LinkedListNode listA,
			LinkedListNode listB) {

		HashSet<Integer> hash = new HashSet<>();
		while (listA != null) {
			hash.add(listA.getValue());
			listA = listA.getNext();
		}

		LinkList xn = new LinkList();
		while (listB != null) {
			if (hash.contains(listB.getValue())) {
				xn.addNode(new LinkedListNode(listB.getValue()));
			}
			listB = listB.getNext();
		}

		return xn.getHead();
	}

	private static LinkedListNode getUnion(LinkedListNode listA,
			LinkedListNode listB) {

		HashSet<Integer> hash = new HashSet<>();

		LinkList union = new LinkList();

		while (listA != null && listB != null) {
			if (!hash.contains(listA.getValue())) {

				union.addNode(new LinkedListNode(listA.getValue()));
				hash.add(listA.getValue());
				listA = listA.getNext();

			} else {

				listA = listA.getNext();
			}
			if (!hash.contains(listB.getValue())) {
				union.addNode(new LinkedListNode(listB.getValue()));
				hash.add(listB.getValue());
				listB = listB.getNext();
			} else {
				listB = listB.getNext();
			}
		}

		LinkedListNode notEmpty = listA != null ? listA
				: (listB != null ? listB : null);

		while (notEmpty != null) {

			if (!hash.contains(notEmpty.getValue())) {
				union.addNode(new LinkedListNode(notEmpty.getValue()));
				hash.add(notEmpty.getValue());
				notEmpty = notEmpty.getNext();
			} else {
				notEmpty = notEmpty.getNext();
			}
		}

		return union.getHead();
	}
}
