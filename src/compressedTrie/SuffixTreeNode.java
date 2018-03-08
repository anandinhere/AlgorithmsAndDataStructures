package compressedTrie;

public class SuffixTreeNode {

	public SuffixTreeNode() {
		// TODO Auto-generated constructor stub
	}

	boolean leaf = false;
	int count = 0;
	SuffixTreeNode[] children = new SuffixTreeNode[256];
	String key;

}
