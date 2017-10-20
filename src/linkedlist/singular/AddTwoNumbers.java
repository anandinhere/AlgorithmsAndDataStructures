package linkedlist.singular;

import util.linkedlist.LinkedListNode;

//quotient = 3 / 2;
//remainder = 3 % 2;

//http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/ without recursion

public class AddTwoNumbers {
	public static void main(String[] args) {
		LinkedListNode a = new LinkedListNode().getLinkedList(4);
		LinkedListNode b = new LinkedListNode().getLinkedList(4);

		a.printLinkedList();
		b.printLinkedList();

		int finalCarry = addNumbers(a, b);

		if (finalCarry > 0) {
			LinkedListNode result = new LinkedListNode(finalCarry);
			result.setNext(a);
			result.printLinkedList();
		} else {

			a.printLinkedList();
		}
	}

	private static int addNumbers(LinkedListNode a, LinkedListNode b) {

		if (a.getNext() == null) {
			int aval = a.getValue();
			int bval = b.getValue();

			int sum = aval + bval;

			int carry = sum / 10;

			a.setValue(sum % 10);
			return carry;
		}

		int aval = a.getValue();
		int bval = b.getValue();

		int sum = aval + bval + addNumbers(a.getNext(), b.getNext());

		int carry = sum / 10;

		a.setValue((sum % 10));

		return carry;

	}
}
