package linkedlist.singular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.linkedlist.LinkedListNode;

public class NthNodeInLinkedList {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Ener size of linked list");

		int size = Integer.parseInt(input.readLine());

		LinkedListNode head = (new LinkedListNode()).getLinkedList(size);
		head.printLinkedList();

		System.out.println("Enter position to find");
		int position = Integer.parseInt(input.readLine());

		LinkedListNode node =  getNthElement(head, position);
		System.out.println(node.getValue());

	}

	public static LinkedListNode getNthElement(LinkedListNode head, int n) {
		int position = 1;

		while (head != null && position <= n) {
			if (position == n) {

				return head;

			}
			position++;
			head = head.getNext();
		}

		System.out.println("Invalid position");
		return null;
	}
}
