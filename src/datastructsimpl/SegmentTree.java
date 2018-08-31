package datastructsimpl;

import util.ArrayUtil;

public class SegmentTree {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		ArrayUtil.printArray(arr);

		int segmentTreeSize = getClosestPowerOf2(arr.length);
		System.out.println(segmentTreeSize);

		int[] segmentTreeArr = new int[segmentTreeSize];

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

		return (int) Math.pow(2, count );
	}
}
