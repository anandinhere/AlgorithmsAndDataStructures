package util.linkedlist;

import java.util.Random;

public class LinkedListNode {

	private LinkedListNode next;
	private LinkedListNode previous;

	private LinkedListNode random;

	public LinkedListNode getRandom() {
		return random;
	}

	public void setRandom(LinkedListNode random) {
		this.random = random;
	}

	private int value;

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public LinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(LinkedListNode previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedListNode() {

	}

	public LinkedListNode(int value) {
		this.value = value;
	}

	public LinkedListNode getLinkedList(int size) {

		if (size == 0) {
			return null;
		}
		return createRandomLinkedList(size, 1, new LinkedListNode(1));
	}

	public void printLinkedList() {

		LinkedListNode node = this;
		System.out.print("Linked List Element In Order - ");
		while (node != null) {
			System.out.print(node.value + " ");

			node = node.next;
		}
		System.out.println();
	}

	private LinkedListNode createRandomLinkedList(int reqdSize, int listSize,
			LinkedListNode headNode) {

		if (listSize == reqdSize)
			return headNode;
		listSize++;

		Random rand = new Random();

		LinkedListNode newNode = new LinkedListNode(rand.nextInt(10));
		newNode.next = headNode;

		return createRandomLinkedList(reqdSize, listSize, newNode);

	}

	public int getSize() {
		int size = 0;
		LinkedListNode temp = this;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;

	}

	public static void main(String[] args) {
		LinkedListNode test = (new LinkedListNode()).getLinkedList(10);

		test.printLinkedList();
	}
}
