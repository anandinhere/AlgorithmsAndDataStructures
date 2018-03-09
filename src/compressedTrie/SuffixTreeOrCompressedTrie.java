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

		insert(key, root);
	}

	private static Integer getDiffChar(String rootKey, String key) {
		int index = 1;
		while (index < rootKey.length() && index < key.length()) {
			if (rootKey.charAt(index) != key.charAt(index)) {
				return index;
			}
			index++;
		}

		if (index > 1) {
			return index;
		}

		return null;
	}

	private static void insert(String key, SuffixTreeNode root) {

		if (key == null || key.length() == 0) {
			return;
		}

		if (root.children[key.charAt(0)] == null) {
			root.children[key.charAt(0)] = new SuffixTreeNode();
			root = root.children[key.charAt(0)];
			root.key = key;
			root.leaf = true;
			root.count++;
		} else {
			root = root.children[key.charAt(0)];
			if (key.equals(root.key)) {
				root.leaf = true;
				root.count++;
				return;
			}
			String rootKey = root.key;
			Integer i = getDiffChar(rootKey, key);
			root.leaf = false;
			root.count--;
			int rootLen = root.key.length();
			if (i == null) {
				root.key = root.key.charAt(0) + "";
				if (root.key.charAt(0) == key.charAt(0)
						&& (1 == root.key.length() || 1 == key.length())) {
					root.leaf = true;
					root.count++;
				}
				insert(key.substring(1), root);
				insert(rootKey.substring(1), root);
			} else {

				root.key = key.substring(0, i);
				if (root.key.equals(key.substring(0, i))
						&& (i == rootLen || i == key.length())) {
					root.leaf = true;
					root.count++;
				}
				insert(key.substring(i), root);
				insert(rootKey.substring(i), root);
			}
		}

	}

	public static void printKeys(SuffixTreeNode root, String s) {

		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				SuffixTreeNode child = root.children[i];
				String key = child.key;

				if (child.leaf == true) {
					System.out.print(s + key);
					System.out.println(" # " + child.count);
				}
				printKeys(child, s + key);
			}
		}

	}

	public static void main(String[] args) {

		String str = "a an ana anan anand  an a anan";

		for (String s : str.split(" ")) {
			SuffixTreeOrCompressedTrie.insert(s);

			
		}
		
		SuffixTreeOrCompressedTrie.printKeys(
				SuffixTreeOrCompressedTrie.root, "");
		System.out.println("***");

	}
}
