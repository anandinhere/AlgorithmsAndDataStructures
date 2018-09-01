package datastructsimpl;

import util.ArrayUtil;

public class SegmentTree {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		ArrayUtil.printArray(arr);

		
		// size of segment tree = 2 * (closest power to 2 to given array)
		int segmentTreeSize = 2 * getClosestPowerOf2(arr.length);
		System.out.println(segmentTreeSize);

		int[] segmentTreeArr = new int[segmentTreeSize];

		int totalSum = segmentTree(segmentTreeArr, arr, 0, segmentTreeSize - 1, 0, arr.length - 1);
		
		ArrayUtil.printArray(segmentTreeArr);
		
		System.out.println(totalSum);

	}
	
	/**
	 * 
	 * @param tree - Segment Tree
	 * @param arr - Input Array
	 * @param treeStart - SegmentTree Start
	 * @param treeEnd - Apparently nort required
	 * @param arrStart - Start index of input array
	 * @param arrEnd - end index of input array
	 * @return
	 */

	private static int segmentTree(int[] tree, int[] arr, int treeStart, int treeEnd, int arrStart, int arrEnd) {

		//This implies leaf node is reached
		if (arrStart == arrEnd) {
			tree[treeStart] = arr[arrStart];
			return tree[treeStart];
		}

		int mid = (arrStart + arrEnd) / 2;

		tree[treeStart] = segmentTree(tree, arr, 2 * treeStart + 1, treeEnd, arrStart, mid)
				+ segmentTree(tree, arr, 2 * treeStart + 2, treeEnd, mid + 1, arrEnd);

		return tree[treeStart];
	}

	private static int getClosestPowerOf2(int length) {

		if ((length & (length - 1)) == 0) {
			return length;
		}

		int count = 0;

		while (length != 0) {
			length = length >> 1;
			count++;
		}

		return (int) Math.pow(2, count);
	}
}
