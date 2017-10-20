package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class MergeLinkedListIntoAnother {

	public static void main(String[] args) {

		LinkedListNode listA = new LinkedListNode().getLinkedList(10);
		listA.printLinkedList();

		LinkedListNode listB = new LinkedListNode().getLinkedList(5);
		listB.printLinkedList();

		mergeBintoA(listA, listB);
		listA.printLinkedList();
	}

	private static void mergeBintoA(LinkedListNode listA, LinkedListNode listB) {

		if (listA == null || listB == null) {
			return;
		}

		/*if (listA.getNext() == null) {  //This check is not required as null node will be at the end
			return;
		}*/

		LinkedListNode listA2ndNode = listA.getNext();
		LinkedListNode listB2ndNode = listB.getNext();

		listA.setNext(listB);

		listA.getNext().setNext(listA2ndNode);
		mergeBintoA(listA2ndNode, listB2ndNode);

	}
}
