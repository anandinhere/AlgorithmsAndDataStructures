package popularProblems;

import util.linkedlist.ListNode;

public class LRUcache {

	public static void main(String[] args) {

		ListNode list = new ListNode();
		list.addDoublyNode(1);
		list.addDoublyNode(2);
		list.addDoublyNode(3);
		list.addDoublyNode(4);
		list.addDoublyNode(5);
		list.addDoublyNode(6);

		ListNode.printDoublyList(list.head);
		
		
		list.removeDoublyNode(list.tail);
		
		ListNode.printDoublyList(list.head);
	}
}
