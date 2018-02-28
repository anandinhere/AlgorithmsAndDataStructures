package util.linkedlist;

public class CircularListNode extends ListNode {
	
	public CircularListNode next;
	public CircularListNode previous;
	
	public CircularListNode(int val) {
		this.value = val;
		this.next = this;
		this.previous = this;
	}

}
