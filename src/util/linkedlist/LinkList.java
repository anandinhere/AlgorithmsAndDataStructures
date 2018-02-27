package util.linkedlist;

import java.util.Random;

public class LinkList {

	private ListNode head;
	private ListNode tail;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public ListNode getTail() {
		return tail;
	}

	public void setTail(ListNode tail) {
		this.tail = tail;
	}

	public ListNode getLinkedList(int size) {
		this.head = new ListNode(1);
		this.tail = head;
		head = createRandomLinkedList(size, 1, head);

		return head;
	}

	private ListNode createRandomLinkedList(int reqdSize, int listSize,
			ListNode headNode) {

		if (listSize == reqdSize)
			return headNode;
		listSize++;

		Random rand = new Random();

		ListNode newNode = new ListNode(rand.nextInt(10));
		newNode.setNext(headNode);

		return createRandomLinkedList(reqdSize, listSize, newNode);

	}

	public void addNode(ListNode newNode) {

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

		ListNode node = this.head;
		System.out.print("Linked List Elements In Order : ");
		while (node != null) {
			System.out.print(node.getValue() + " ");

			node = node.getNext();
		}
		System.out.println();
	}

}
