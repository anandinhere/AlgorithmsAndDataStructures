package util.linkedlist;

import java.util.Random;

public class ListNode {

	public ListNode next;
	public ListNode previous;

	public ListNode left;
	public ListNode right;

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

	private ListNode createRandomLinkedList(int reqdSize, int listSize,
			ListNode headNode) {

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
}
