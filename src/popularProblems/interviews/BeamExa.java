package popularProblems.interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import array.sorting.ArrayUtil;

public class BeamExa {
	public static void main(String[] args) {

		String str = "123 1234 klshfklhsfoewur 123 lk  456 aljd 123 kjk 456 lkj lkslksfljsdf ";

		String pat = "123 456";

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

		List l = t.search(t.root, "123", 3, 0);
		System.out.println(l.toString());

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
