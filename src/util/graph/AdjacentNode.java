package util.graph;

public class AdjacentNode {
	int weight;
	int key;
	int tempKey = Integer.MAX_VALUE;

	public int getTempKey() {
		return tempKey;
	}

	public void setTempKey(int tempKey) {
		this.tempKey = tempKey;
	}

	public AdjacentNode(int key, int weight) {
		this.key = key;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
