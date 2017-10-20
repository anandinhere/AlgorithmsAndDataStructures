package linkedlist.singular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.linkedlist.LinkedListNode;

/*
 * References:
 http://en.wikipedia.org/wiki/Cycle_detection

 Floyd's cycle-finding algorithm, also called the "tortoise and the hare algorithm", alluding to Aesop's fable of The Tortoise and the Hare, 
 is a pointer algorithm that uses only two pointers, which move through the sequence at different speeds.

 http://ostermiller.org/find_loop_singly_linked_list.html
 */

public class LoopDetect {

	public static void main(String[] args) {
		LinkedListNode node = (new LinkedListNode()).getLinkedList(10);
		node.printLinkedList();

		boolean hasLoop = checkForLoop(node);
		System.out.println("has loop ?" + hasLoop);

		System.out.println("making a loop");

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		LinkedListNode nodeA = null;
		LinkedListNode nodeB = null;

		try {
			System.out.println("Enter nodeA position");
			int positionA = Integer.parseInt(input.readLine());
			System.out.println("Enter nodeB position");
			int positionB = Integer.parseInt(input.readLine());

			nodeA = NthNodeInLinkedList.getNthElement(node, positionA);
			nodeB = NthNodeInLinkedList.getNthElement(node, positionB);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("nodeA value - " + nodeA.getValue());
		// System.out.println("nodeB value - " + nodeB.getValue());

		nodeB.setNext(nodeA.getNext());

		System.out.println("loop start - " + nodeA.getNext().getValue());

		hasLoop = checkForLoop(node);
		System.out.println("has loop ?" + hasLoop);

	}

	private static boolean checkForLoop(LinkedListNode node) {
		boolean hasloop = false;
		LinkedListNode slow = node;
		LinkedListNode fast = node;

		while (fast.getNext() != null && fast.getNext().getNext() != null) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (fast == slow) {
				hasloop = true;
				break;
			}
		}

		if (hasloop == false)
			return false;

		while (node.getNext() != fast.getNext()) {
			node = node.getNext();
			fast = fast.getNext();
		}
		System.out.println(node.getNext().getValue());

		return hasloop;
	}
}
