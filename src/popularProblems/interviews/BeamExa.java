package popularProblems.interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.ArrayUtil;

public class BeamExa {
	public static void main(String[] args) {

		String str = "123 1234 klshfklhsfoewur 123 4567 aljd 123 kk 4567 lkj lkslksfljsdf ";

		String pat = "123 456";
		String[] patArr = pat.split(" ");

		Trie t = new Trie();

		for (int i = 0; i < str.length(); i++) {

			String s = "";
			char c = str.charAt(i);
			if (c == ' ') {
				continue;
			}
			while (c != ' ') {
				s = s + c;
				i++;
				c = str.charAt(i);
			}

			System.out.println("Inserting " + s);
			t.insert(t.root, s, 0, s.length(), i - s.length());
			//

		}

		t.print(t.root);

		List<Integer> l1 = t.search(t.root, patArr[0], 3, 0);
		List<Integer> l2 = t.search(t.root, patArr[1], 3, 0);

		getSmallestWindow(l1, l2, patArr[0], patArr[1]);

	}

	// O(m+n)
	private static void getSmallestWindow(List<Integer> l1, List<Integer> l2, String pat1, String pat2) {

		if (l1.size() == 0 || l2.size() == 0) {
			System.out.println("No window found!");
			return;
		}

		int[] l1Arr = new int[l1.size()];
		int[] l2Arr = new int[l2.size()];

		int i = 0;
		for (Integer item : l1) {
			l1Arr[i] = item;
			i++;
		}
		i = 0;
		for (Integer item : l2) {
			l2Arr[i] = item;
			i++;
		}

		i = 0;
		int j = 0;

		int start = -1;
		int end = -1;
		int minLen = Integer.MAX_VALUE;
		int currLen = Integer.MAX_VALUE;

		while (i < l1Arr.length && j < l2Arr.length) {

			if (l1Arr[i] < l2Arr[j]) {
				currLen = l2Arr[j] - l1Arr[i];

				if (currLen < minLen) {
					minLen = currLen;
					start = i;
					end = j;
				}

			} else {
				j++;
				continue;
			}
			i++;

		}

		System.out.println("Start " + l1Arr[start] + "\nEnd " + (l2Arr[end] + pat2.length()) + "\nMin Length "
				+ (minLen + pat2.length()));

	}

	static class Trie {

		TrieNode root = null;

		public Trie() {
			// TODO Auto-generated constructor stub
		}

		public Trie(TrieNode r) {
			root = r;
		}

		public void insert(TrieNode node, String str, int index, int len, int addInfo) {

			// missed root creation

			// Check if root is empty
			TrieNode childNode = null;
			char c = str.charAt(index);
			if (root == null) {
				root = new TrieNode();
				root.children[c] = new TrieNode();
				childNode = root.children[c];
			}
			// If root not empty
			else {
				// missed not null here
				if (node.children[c] == null) {
					node.children[c] = new TrieNode();
					childNode = node.children[c];
				} else {
					childNode = node.children[c];
				}
			}

			// if index reached end of string.
			if (index == len - 1) {
				childNode.indexes.add(addInfo);
				childNode.end = true;
				return;
			}

			if (index < len) {
				insert(childNode, str, index + 1, len, addInfo);
			}

		}

		public void print(TrieNode root) {

			for (int i = 0; i < root.children.length; i++) {

				TrieNode n = root.children[i];

				if (n != null) {
					System.out.print((char) i);
					System.out.println();
					if (n.end) {
						System.out.println(n.indexes.toString());
					}
					print(n);
				}

			}

		}

		public List<Integer> search(TrieNode node, String str, int len, int index) {

			TrieNode childNode = null;

			char c = str.charAt(index);
			childNode = node.children[c];

			if (childNode == null) {
				return null;
			}

			if (index == len - 1) {
				return childNode.indexes;
			}

			return search(childNode, str, len, index + 1);

		}
	}

	static class TrieNode {

		public TrieNode[] children = new TrieNode[256];

		boolean end = false;
		List<Integer> indexes = new LinkedList<Integer>();

	}
}
