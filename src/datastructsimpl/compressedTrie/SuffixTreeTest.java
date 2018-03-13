package datastructsimpl.compressedTrie;


public class SuffixTreeTest {
	public static void main(String[] args) {

		String str = "anand ananp";

		for (String s : str.split(" ")) {
			SuffixTreeOrCompressedTrie.insert(s);
		}

		SuffixTreeOrCompressedTrie.printKeys(SuffixTreeOrCompressedTrie.root,
				"");
	}
}
