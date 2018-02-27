package linkedlist.singular;

import util.linkedlist.ListNode;

public class CloneListWithRandomMethod1 {

	public static void main(String[] args) {

		ListNode origHead = new ListNode().getLinkedList(5);
		origHead.printLinkedList();

		origHead.setRandom(origHead.getNext().getNext());
		origHead.getNext().setRandom(origHead.getNext().getNext().getNext());
		origHead.getNext().getNext()
				.setRandom(origHead.getNext().getNext().getNext());
		origHead.getNext().getNext().getNext()
				.setRandom(origHead.getNext().getNext().getNext().getNext());
		origHead.getNext().getNext().getNext().getNext()
				.setRandom(origHead.getNext().getNext().getNext().getNext());

		// Printing Original Next and Random Values
		ListNode headCopy = origHead;
		while (headCopy != null) {
			System.out.println("Node value:" + headCopy.getValue()
					+ " Random value: " + headCopy.getRandom().getValue());
			headCopy = headCopy.getNext();
		}

		headCopy = origHead;

		// Backing up next and random of original
		ListNode[] temp = new ListNode[headCopy.getSize()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new ListNode();
			temp[i].setNext(headCopy.getNext());
			headCopy = headCopy.getNext();
		}

		// Creating clone. Changing next of original to clone. random of clone
		// to original
		headCopy = origHead;
		ListNode cloneHead = new ListNode();
		ListNode cloneCopy = cloneHead;

		while (headCopy.getNext() != null) {

			ListNode tempNode = new ListNode();
			ListNode newNode = new ListNode();

			cloneCopy.setNext(newNode);
			cloneCopy.setRandom(headCopy);
			cloneCopy.setValue(headCopy.getValue());

			tempNode = headCopy.getNext();
			headCopy.setNext(cloneCopy);
			headCopy = tempNode;

			cloneCopy = newNode;

		}
		cloneCopy.setValue(headCopy.getValue());
		cloneCopy.setRandom(headCopy);
		headCopy.setNext(cloneCopy);

		// setting random of clone
		cloneCopy = cloneHead;
		while (cloneCopy != null) {
			cloneCopy.setRandom(cloneCopy.getRandom().getRandom().getNext());
			cloneCopy = cloneCopy.getNext();
		}

		// restoring next and random of orignal.
		headCopy = origHead;
		for (int i = 0; i < temp.length; i++) {
			headCopy.setNext(temp[i].getNext());
			headCopy = headCopy.getNext();
		}

		System.out.println("\n\n Printing Original Values");
		headCopy = origHead;
		while (headCopy != null) {
			System.out.println("Node value:" + headCopy.getValue()
					+ " Random value: " + headCopy.getRandom().getValue());
			headCopy = headCopy.getNext();
		}

		System.out.println("\n \n Printing Clone Values");
		cloneCopy = cloneHead;
		while (cloneCopy != null) {
			System.out.println("Node value:" + cloneCopy.getValue()
					+ " Random value: " + cloneCopy.getRandom().getValue());
			cloneCopy = cloneCopy.getNext();
		}

	}

}
