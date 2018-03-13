package linkedlist.doubly;

import util.linkedlist.CircularListNode;

public class AppendCircularDoublyLinkedList {

	public static void main(String[] args) {

		CircularListNode node1 = new CircularListNode(1);
		CircularListNode node2 = new CircularListNode(2);
		CircularListNode node3 = new CircularListNode(3);
		CircularListNode node4 = new CircularListNode(4);
		CircularListNode node5 = new CircularListNode(5);
		CircularListNode node6 = new CircularListNode(6);

		CircularListNode temp = null;

		CircularListNode head = append(node1, node2);
		temp = head;
		while (true) {
			printDoublyNode(temp);
			temp = temp.next;
			if(temp==head) break;
		}
		System.out.println("**************");

		head = append(head, node3);
		temp = head;
		while (true) {
			printDoublyNode(temp);
			temp = temp.next;
			if(temp==head) break;
		}
		System.out.println("**************");

	}

	public static void printDoublyNode(CircularListNode head) {
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

	public static CircularListNode append(CircularListNode nodeA, CircularListNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;

		CircularListNode tailA = nodeA.previous;
		CircularListNode tailB = nodeB.previous;

		tailA.next = nodeB;
		nodeB.previous = tailA;

		tailB.next = nodeA;
		nodeA.previous = tailB;

		return nodeA;
	}

}
