package linkedlist.doubly;

import util.linkedlist.ListNode;

public class AppendDoublyLinkedList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		ListNode temp = null;

		ListNode head = append(node1, node2);
		temp = head;
		while (temp != null) {
			printDoublyNode(temp);
			temp = temp.next;
		}
		System.out.println("**************");

		head = append(head, node3);
		temp = head;
		while (temp != null) {
			printDoublyNode(temp);
			temp = temp.next;
		}
		System.out.println("**************");

	}

	private static void printDoublyNode(ListNode head) {
		if (head == null) {
			System.out.println("null");
			return;
		}

		if (head.previous != null)
			System.out.print("prev:" + head.previous.value + "  ");
		else
			System.out.print("prev:" + "null" + "  ");

		System.out.print("curr:" + head.value + "  ");

		if (head.next != null)
			System.out.print("next:" + head.next.value + "  ");
		else
			System.out.print("next:" + "null" + "  ");

		System.out.println();

	}

	private static ListNode append(ListNode nodeA, ListNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;
		
		
		ListNode nodeACopy = nodeA;
		ListNode tailA = null;

		while (nodeA.next != null) {
			nodeA = nodeA.next;
		}
		tailA = nodeA;

		tailA.next = nodeB;
		nodeB.previous = tailA;

		return nodeACopy;
	}

}
