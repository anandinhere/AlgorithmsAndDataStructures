package datastructsimpl;

/*
 m: average word length

 w : number of words in the trie. 

 Then the boundary O(w*m) is much more useful, 
 since it simply represents the max amount of characters in the trie, 
 which is obviously also it's space boundary.

 Using Trie, we can search the key in O(m) time.
 */
public class SuffixTreeOrCompressedTrie {

	static SuffixTreeNode root;

	public SuffixTreeOrCompressedTrie() {
		// TODO Auto-generated constructor stub
	}

	public static void insert(String key) {

		SuffixTreeNode temp = root;
		if (root == null) {
			root = new SuffixTreeNode();
			temp = root;
		}

		if (key == null || key.length() == 0) {
			return;
		}

		int index = 0;
		if (temp.children[key.charAt(index)] == null) {
			temp.children[key.charAt(index)] = new SuffixTreeNode();
			temp = temp.children[key.charAt(index)];
			temp.key = key;
			temp.leaf = true;
			temp.count++;
		} else {
			temp = temp.children[key.charAt(index)];
			String tempKey = temp.key;
			Integer i = getDiffChar(tempKey, key);

			if (i == null) {
				temp.key = key.substring(1, key.length() - 1);
				insert(key.charAt(1),key.substring(1), temp.children[key.charAt(1)]);
				insert(key.charAt(1), tempKey.substring(1), temp.children[key.charAt(1)]);
			} else {
				temp.key = key.substring(1, i);
				insert(key.charAt(i), key.substring(i), temp.children[key.charAt(i)]);
				insert(key.charAt(i), key.substring(i), temp.children[key.charAt(i)]);
			}
		}
	}

	private static Integer getDiffChar(String tempKey, String key) {
		int tempIndex = 1;
		int keyIndex = 1;

		while (tempIndex < tempKey.length() && keyIndex < key.length()) {
			if (tempKey.charAt(tempIndex) == key.charAt(keyIndex)) {
				return tempIndex;
			}

		}
		return null;
	}

	private static void insert(int index, String key, SuffixTreeNode temp) {

		if (temp.children[key.charAt(index)] == null) {
			temp.children[key.charAt(index)] = new SuffixTreeNode();
			temp = temp.children[key.charAt(index)];
			temp.key = key;
			temp.leaf = true;
			temp.count++;
		} else {
			temp = temp.children[key.charAt(index)];
			String tempKey = temp.key;
			Integer i = getDiffChar(tempKey, key);

			if (i == null) {
				temp.key = key.substring(1, key.length() - 1);
				insert(key.charAt(1), key.substring(1), temp.children[key.charAt(1)]);
				insert(key.charAt(1), tempKey.substring(1), temp.children[key.charAt(1)]);
			} else {
				temp.key = key.substring(1, i);
				insert(key.charAt(i), key.substring(i), temp.children[key.charAt(i)]);
				insert(key.charAt(i), key.substring(i), temp.children[key.charAt(i)]);
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
