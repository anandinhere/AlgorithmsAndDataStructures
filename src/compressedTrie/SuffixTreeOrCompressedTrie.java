package compressedTrie;

/*
 m: average word length

 w : number of words in the trie. 

 Then the boundary O(w*m) is much more useful, 
 since it simply represents the max amount of characters in the trie, 
 which is obviously also it's space boundary.

 Using Trie, we can search the key in O(m) time.
 */
public class SuffixTreeOrCompressedTrie {

	static SuffixTreeNode root = null;

	public SuffixTreeOrCompressedTrie() {
		// TODO Auto-generated constructor stub
	}

	public static void insert(String key) {

		SuffixTreeNode root = SuffixTreeOrCompressedTrie.root;
		if (root == null) {
			root = new SuffixTreeNode();
			SuffixTreeOrCompressedTrie.root = root;
		}

		if (key == null || key.length() == 0) {
			return;
		}

		int index = 0;
		if (root.children[key.charAt(index)] == null) {
			root.children[key.charAt(index)] = new SuffixTreeNode();
			root = root.children[key.charAt(index)];
			root.key = key;
			root.leaf = true;
			root.count++;
		} else {
			root = root.children[key.charAt(index)];
			String rootKey = root.key;
			Integer i = getDiffChar(rootKey, key);

			if (i == null) {
				root.key = root.key.charAt(0) + "";
				insert(key.charAt(1), key.substring(1), root);
				insert(key.charAt(1), rootKey.substring(1), root);
			} else {
				root.key = key.substring(1, i);
				insert(key.charAt(i), key.substring(i), root);
				insert(key.charAt(i), key.substring(i), root);
			}
		}
	}

	private static Integer getDiffChar(String rootKey, String key) {
		int rootIndex = 1;
		int keyIndex = 1;

		while (rootIndex < rootKey.length() && keyIndex < key.length()) {
			if (rootKey.charAt(rootIndex) == key.charAt(keyIndex)) {
				return rootIndex;
			}
			rootIndex++;
			keyIndex++;
		}
		return null;
	}

	private static void insert(int index, String key, SuffixTreeNode root) {

		if (root.children[key.charAt(0)] == null) {
			root.children[key.charAt(0)] = new SuffixTreeNode();
			root = root.children[key.charAt(0)];
			root.key = key;
			root.leaf = true;
			root.count++;
		} else {
			root = root.children[key.charAt(0)];
			String rootKey = root.key;
			Integer i = getDiffChar(rootKey, key);

			if (i == null) {
				root.key = root.key.charAt(0) + "";
				insert(key.charAt(1), key.substring(1), root);
				insert(key.charAt(1), rootKey.substring(1), root);
			} else {
				root.key = key.substring(1, i);
				insert(key.charAt(i), key.substring(i), root);
				insert(key.charAt(i), key.substring(i), root);
			}
		}

	}

	public static void printKeys(SuffixTreeNode root, String s) {

		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				SuffixTreeNode child = root.children[i];
				char c = (char) i;

				if (child.leaf == true) {
					System.out.print(s + c);
					System.out.println(" # " + child.count);
				}
				printKeys(child, s + c);
			}
		}

	}
}
