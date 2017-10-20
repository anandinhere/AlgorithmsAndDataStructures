package linkedlist.singular;

import util.linkedlist.LinkedListNode;

public class DeleteLinkedList {

	public static void main(String[] args) {
		
		LinkedListNode node = (new LinkedListNode()).getLinkedList(10);
		
		node.printLinkedList();
		
		node = null;
		
		node.printLinkedList();
		
	}
}
