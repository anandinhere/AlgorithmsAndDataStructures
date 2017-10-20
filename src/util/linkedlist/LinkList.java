package util.linkedlist;

import java.util.Random;

public class LinkList {

	private LinkedListNode head;
	private LinkedListNode tail;

	public LinkedListNode getHead() {
		return head;
	}

	public void setHead(LinkedListNode head) {
		this.head = head;
	}

	public LinkedListNode getTail() {
		return tail;
	}

	public void setTail(LinkedListNode tail) {
		this.tail = tail;
	}

	public LinkedListNode getLinkedList(int size) {
		this.head = new LinkedListNode(1);
		this.tail = head;
		head = createRandomLinkedList(size, 1, head);

		return head;
	}

	private LinkedListNode createRandomLinkedList(int reqdSize, int listSize,
			LinkedListNode headNode) {

		if (listSize == reqdSize)
			return headNode;
		listSize++;

		Random rand = new Random();

		LinkedListNode newNode = new LinkedListNode(rand.nextInt(10));
		newNode.setNext(headNode);

		return createRandomLinkedList(reqdSize, listSize, newNode);

	}

	public void addNode(LinkedListNode newNode) {

		if (this.isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = tail.getNext();
		}
	}

	public boolean isEmpty() {
		if (this.head == null)
			return true;
		return false;
	}

	public void printLinkedList() {

		LinkedListNode node = this.head;
		System.out.print("Linked List Elements In Order : ");
		while (node != null) {
			System.out.print(node.getValue() + " ");

			node = node.getNext();
		}
		System.out.println();
	}

}
