package popularProblems;

import java.util.*;
import java.util.Map.Entry;

import util.linkedlist.ListNode;

public class LRUcache {
	public static HashMap<Integer, ListNode> lruCache = new HashMap<Integer, ListNode>();
	public static int cacheSize = 4;
	public static ListNode list = new ListNode();

	public static void main(String[] args) {

		list.addDoublyNodeToTail(new ListNode(1));
		list.addDoublyNodeToTail(new ListNode(2));
		list.addDoublyNodeToTail(new ListNode(3));
		list.addDoublyNodeToTail(new ListNode(4));
		list.addDoublyNodeToTail(new ListNode(5));
		list.addDoublyNodeToTail(new ListNode(6));

		ListNode.printDoublyList(list.head);

		System.out.println(findInCache(6, lruCache).value);
		System.out.println(findInCache(5, lruCache).value);
		System.out.println(findInCache(3, lruCache).value);
		System.out.println(findInCache(2, lruCache).value);

		printLRUKeys();

		System.out.println(findInCache(1, lruCache).value);
		printLRUKeys();
		ListNode.printDoublyList(list.head);
	}

	private static void printLRUKeys() {
		System.out.println("Cache");
		for (Entry<Integer, ListNode> e : lruCache.entrySet()) {
			System.out.println(e.getKey());
		}
		System.out.println("Cache");
	}

	private static ListNode findInCache(int i, HashMap<Integer, ListNode> lruCache) {
		if (lruCache.containsKey(i)) {
			ListNode node = lruCache.get(i);
			list.removeDoublyNode(node);
			list.addDoublyNodeToHead(node);
			return node;
		}

		return addToCache(i);
	}

	private static ListNode addToCache(int i) {

		if (lruCache.size() == cacheSize) {
			lruCache.remove(list.head.value);
		}

		ListNode node = list.findDoublyNode(i);
		list.removeDoublyNode(node);
		list.addDoublyNodeToHead(node);
		lruCache.put(i, node);
		return node;
	}

}
