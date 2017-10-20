package util.graph;

public class Node {
	int weight;
	String key;
	int tempKey = Integer.MAX_VALUE;

	public int getTempKey() {
		return tempKey;
	}

	public void setTempKey(int tempKey) {
		this.tempKey = tempKey;
	}

	public Node(String key, int weight) {
		this.key = key;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
