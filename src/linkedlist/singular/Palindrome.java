package linkedlist.singular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class Palindrome {

	static boolean isOdd = false;

	public static void main(String[] args) throws IOException {

		LinkList linkedList = new LinkList();

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Enter Int elements");

		boolean validInput = true;

		while (validInput) {

			try {

				int value = Integer.parseInt(input.readLine());
				LinkedListNode node = new LinkedListNode(value);
				linkedList.addNode(node);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid Input");
				validInput = false;
			}

		}

		linkedList.printLinkedList();

		// checkPalindrome(linkedList.getHead(), linkedList.getHead(),
		// linkedList.getHead());
		
		
		
		 checkPalindrome(linkedList.getHead(), linkedList.getHead());

	}

	private static LinkedListNode checkPalindrome(LinkedListNode head,
			LinkedListNode fast, LinkedListNode slow) {

		if (fast.getNext() == null || fast.getNext().getNext() == null) {

			if (fast.getNext() == null) {
				isOdd = true;
				return slow.getNext(); // Idea - method 2
			}
			if (slow.getNext().getValue() == head.getValue()) {
				System.out.println("Yes Palindrome");
				return slow.getNext().getNext();
			}

		}

		int currentNode = head.getValue();
		int previousNode = slow.getValue();
		LinkedListNode slowPtr = slow.getNext();
		LinkedListNode fastPtr = fast.getNext().getNext();

		LinkedListNode newHead = checkPalindrome(head.getNext(), fastPtr,
				slowPtr);
		System.out.println(newHead.getValue() + "" + currentNode);

		if (isOdd) {
			if (newHead.getValue() == previousNode) {
				System.out.println("Yes Palindrome");
			}

		} else if (newHead.getValue() == currentNode) {
			System.out.println("Yes Palindrome");
		}
		return newHead.getNext();

	}

	private static LinkedListNode checkPalindrome(LinkedListNode slow,
			LinkedListNode fast) {

		if (fast.getNext() == null || fast.getNext().getNext() == null) {

			if (fast.getNext() == null) { // odd
				return slow.getNext();
			}
			if (fast.getNext().getNext() == null) { // even

				if (slow.getValue() == slow.getNext().getValue()) {
					System.out.println("yes");
					return slow.getNext().getNext();
				} else
					return null;

			}

		}

		int currentNode = slow.getValue();
		slow = slow.getNext();
		fast = fast.getNext().getNext();

		LinkedListNode newHead = checkPalindrome(slow, fast);

		if (newHead != null && currentNode == newHead.getValue()) {
			System.out.println("yes");
			return newHead.getNext();
		} else {
			System.out.println("no");
			return null;
		}

	}
}
