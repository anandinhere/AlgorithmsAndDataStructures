package datastructsimpl;

import util.ArrayUtil;

public class SegmentTree {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		ArrayUtil.printArray(arr);

		// size of segment tree = 2 * (closest power to 2 to given array)
		int segmentTreeSize = 2 * getClosestPowerOf2(arr.length);
		System.out.println("segmentTreeSize : " +segmentTreeSize);

		int[] tree = new int[segmentTreeSize];

		int totalSum = segmentTree(tree, arr, 0, segmentTreeSize - 1, 0, arr.length - 1);

		ArrayUtil.printArray(tree);

		System.out.println("totalSum : "+ totalSum);

		int rangeStart = 2;
		int rangeEnd = 8;

		int sum = findSumWithInRange(tree, arr, 0, rangeStart, rangeEnd, 0, arr.length - 1);
		System.out.println("Range Sum : " + sum);

		int sumAfterUpdate = updateIndex(tree, arr, 0, 0, arr.length - 1, 3, 40);
		ArrayUtil.printArray(tree);

	}

	private static int updateIndex(int[] tree, int[] arr, int treeIndex, int arrStart, int arrEnd, int targetIndex,
			int value) {

		// range is same as array limits
		if (arrStart == arrEnd && targetIndex == arrEnd) {
			return tree[treeIndex] = value;
		}

		int mid = (arrStart + arrEnd) / 2;

		// make sure of inequality test is correct
		if (targetIndex <= mid) {
			updateIndex(tree, arr, treeIndex * 2 + 1, arrStart, mid, targetIndex, value);
			tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
			return tree[treeIndex];

			// make sure of inequality test is correct
		} else
			updateIndex(tree, arr, treeIndex * 2 + 2, mid + 1, arrEnd, targetIndex, value);
		tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
		return tree[treeIndex];

	}

	/**
	 * 
	 * @param tree
	 * @param arr
	 * @param treeIndex
	 *            - Calling this treeIndex just for simplicity sake. Lesson learned
	 *            after implementing method for building segment tree
	 * @param rangeStart
	 * @param rangeEnd
	 * @param arrStart
	 * @param arrEnd
	 * @return
	 */
	private static int findSumWithInRange(int[] tree, int[] arr, int treeIndex, int rangeStart, int rangeEnd,
			int arrStart, int arrEnd) {

		// range is same as array limits
		if (rangeStart == arrStart && rangeEnd == arrEnd) {
			return tree[treeIndex];
		}

		// range is outside of array limits. This probably will never happen because of
		// the following checks
		if (rangeStart < arrStart && rangeEnd > arrEnd) {
			return 0;
		}

		int mid = (arrStart + arrEnd) / 2;

			// if range in either side of mid
		if (rangeStart <= mid && mid < rangeEnd) {
			return findSumWithInRange(tree, arr, treeIndex * 2 + 1, rangeStart, mid, arrStart, mid)
					+ findSumWithInRange(tree, arr, treeIndex * 2 + 2, mid + 1, rangeEnd, mid + 1, arrEnd);
			// if range is in first half
		} else if (rangeStart <= mid && mid >= rangeEnd) {
			return findSumWithInRange(tree, arr, treeIndex * 2 + 1, rangeStart, rangeEnd, arrStart, mid);
			// if range is in second half
		} else
			return findSumWithInRange(tree, arr, treeIndex * 2 + 2, rangeStart, rangeEnd, mid + 1, arrEnd);
	}

	/**
	 * 
	 * @param tree
	 *            - Segment Tree
	 * @param arr
	 *            - Input Array
	 * @param treeStart
	 *            - SegmentTree Start
	 * @param treeEnd
	 *            - Apparently not required
	 * @param arrStart
	 *            - Start index of input array
	 * @param arrEnd
	 *            - end index of input array
	 * @return
	 */

	private static int segmentTree(int[] tree, int[] arr, int treeStart, int treeEnd, int arrStart, int arrEnd) {

		// This implies leaf node is reached
		if (arrStart == arrEnd) {
			tree[treeStart] = arr[arrStart];
			return tree[treeStart];
		}

		//Finding mid of array here. Not Tree. VERY IMPORTANT
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
