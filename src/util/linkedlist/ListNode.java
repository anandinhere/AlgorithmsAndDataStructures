package util.linkedlist;

import java.util.Random;

public class ListNode {

	public ListNode next;
	public ListNode previous;

	public ListNode head;
	public ListNode tail;
	public int size = 0;

	private ListNode random;

	public ListNode getRandom() {
		return random;
	}

	public void setRandom(ListNode random) {
		this.random = random;
	}

	public int value;

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getPrevious() {
		return previous;
	}

	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ListNode() {

	}

	public ListNode(int value) {
		this.value = value;
	}

	public void addDoublyNodeToTail(ListNode node) {
		if (size == 0) {
			head = node;
			tail = head;
			size++;
			return;
		}

		tail.next = node;
		node.previous = tail;
		tail = node;
		size++;
	}

	public void addDoublyNodeToHead(ListNode node) {
		if (size == 0) {
			head = node;
			tail = head;
			size++;
			return;
		}

		head.previous = node;
		node.next = head;
		head = node;
		size++;
	}

	public void removeDoublyNode(ListNode node) {
		if (head == tail) {
			head = null;
			size--;
			return;
		}

		if (node == tail) {
			tail = tail.previous;
			tail.next = null;
			size--;
			return;
		}

		if (node == head) {
			head = head.next;
			head.previous = null;
			size--;
			return;
		}

		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;

	}

	public ListNode findDoublyNode(int value) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.value == value)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	public ListNode getLinkedList(int size) {

		if (size == 0) {
			return null;
		}
		return createRandomLinkedList(size, 1, new ListNode(1));
	}

	public void printLinkedList() {

		ListNode node = this;
		System.out.print("Linked List Element In Order - ");
		while (node != null) {
			System.out.print(node.value + " ");

			node = node.next;
		}
		System.out.println();
	}

	private ListNode createRandomLinkedList(int reqdSize, int listSize, ListNode headNode) {

		if (listSize == reqdSize)
			return headNode;
		listSize++;

		Random rand = new Random();

		ListNode newNode = new ListNode(rand.nextInt(10));
		newNode.next = headNode;

		return createRandomLinkedList(reqdSize, listSize, newNode);

	}

	public int getSize() {
		int size = 0;
		ListNode temp = this;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;

	}

	public static void main(String[] args) {
		ListNode test = (new ListNode()).getLinkedList(10);

		test.printLinkedList();
	}

	public static ListNode appendCircularLists(ListNode nodeA, ListNode nodeB) {

		if (nodeA == null)
			return nodeB;
		if (nodeB == null)
			return nodeA;

		ListNode tailA = nodeA.previous;
		ListNode tailB = nodeB.previous;

		tailA.next = nodeB;
		nodeB.previous = tailA;

		tailB.next = nodeA;
		nodeA.previous = tailB;

		return nodeA;
	}

	public static ListNode appendDoublyLists(ListNode nodeA, ListNode nodeB) {

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

	public static void printDoublyList(ListNode head) {

		if (head == null) {
			System.out.println("END OF LIST");
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

		printDoublyList(head.next);

	}

}
