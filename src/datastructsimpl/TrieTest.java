package datastructsimpl;

public class TrieTest {
	public static void main(String[] args) {

		String str = "my name is anand - not aaanad or aaanaaand my name is";

		for (String s : str.split(" ")) {
			Trie.insert(s);
		}

		Trie.printKeys(Trie.root, "");
	}
}
