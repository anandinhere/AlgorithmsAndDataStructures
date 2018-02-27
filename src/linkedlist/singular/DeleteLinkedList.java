package linkedlist.singular;

import util.linkedlist.ListNode;

public class DeleteLinkedList {

	public static void main(String[] args) {
		
		ListNode node = (new ListNode()).getLinkedList(10);
		
		node.printLinkedList();
		
		node = null;
		
		node.printLinkedList();
		
	}
}
