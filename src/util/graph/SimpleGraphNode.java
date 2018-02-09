package util.graph;

public class SimpleGraphNode {

	private boolean isVisited;
	private int intVal;
	private int key;
	private char charVal;
	private boolean inRecurseStack;
	private int tempWeight = Integer.MAX_VALUE;
	private int parentKey;

	public int getParentKey() {
		return parentKey;
	}

	public void setParentKey(int parentKey) {
		this.parentKey = parentKey;
	}

	public int getTempWeight() {
		return tempWeight;
	}

	public void setTempWeight(int tempWeight) {
		this.tempWeight = tempWeight;
	}

	public boolean isInRecurseStack() {
		return inRecurseStack;
	}

	public void setInRecurseStack(boolean inRecStack) {
		this.inRecurseStack = inRecStack;
	}

	public SimpleGraphNode() {

	}

	public SimpleGraphNode(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	public char getCharVal() {
		return charVal;
	}

	public void setCharVal(char charVal) {
		this.charVal = charVal;
	}

}
