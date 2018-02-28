package binarytree;

import linkedlist.doubly.AppendDoublyLinkedList;
import util.linkedlist.ListNode;

public class SortedDLLtoBalancedBST {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		ListNode head = AppendDoublyLinkedList.append(node1, node2);
		head = AppendDoublyLinkedList.append(head, node3);
		head = AppendDoublyLinkedList.append(head, node4);
		head = AppendDoublyLinkedList.append(head, node5);
		head = AppendDoublyLinkedList.append(head, node6);
		AppendDoublyLinkedList.printDoublyList(head);

		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		head = convertDLLtoBST(head, temp);

		System.out.println(head);
	}
	
	/*
	 * O(nlogn) - finding middle logn times
	 * 
	 */

	private static ListNode convertDLLtoBST(ListNode head, ListNode tail) {
		if (head == null || tail == null || head.value > tail.value) {
			return null;
		}
		if (head == tail)
			return head;

		ListNode mid = getMid(head, tail);
		mid.left = convertDLLtoBST(head, mid.previous);

		mid.right = convertDLLtoBST(mid.next, tail);

		return mid;
	}

	private static ListNode getMid(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == tail) {
			return head;
		}

		while (fast.next != tail && fast.next.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("mid : " + slow.value);

		return slow.next;
	}

}
