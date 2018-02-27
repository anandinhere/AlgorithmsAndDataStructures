package linkedlist.singular;

import util.linkedlist.ListNode;

public class MergeLinkedListIntoAnother {

	public static void main(String[] args) {

		ListNode listA = new ListNode().getLinkedList(10);
		listA.printLinkedList();

		ListNode listB = new ListNode().getLinkedList(5);
		listB.printLinkedList();

		mergeBintoA(listA, listB);
		listA.printLinkedList();
	}

	private static void mergeBintoA(ListNode listA, ListNode listB) {

		if (listA == null || listB == null) {
			return;
		}

		/*if (listA.getNext() == null) {  //This check is not required as null node will be at the end
			return;
		}*/

		ListNode listA2ndNode = listA.getNext();
		ListNode listB2ndNode = listB.getNext();

		listA.setNext(listB);

		listA.getNext().setNext(listA2ndNode);
		mergeBintoA(listA2ndNode, listB2ndNode);

	}
}
