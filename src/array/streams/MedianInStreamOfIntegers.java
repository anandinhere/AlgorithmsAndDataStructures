package array.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import util.ArrayUtil;

public class MedianInStreamOfIntegers {

	static PriorityQueue<Integer> pqLeft = new PriorityQueue<Integer>(10, Collections.reverseOrder()); // we want max
																										// heap on left
	static PriorityQueue<Integer> pqright = new PriorityQueue<Integer>(10); // by default min heap on right

	public static void main(String[] args) {
		int[] arr = ArrayUtil.getRandArray(0, 20);
		System.out.println(Arrays.toString(arr));

		printMedianInStream(arr);

	}

	//Incomplete
	private static void printMedianInStream(int[] arr) {
		float median = 0;
		for (int num : arr) {
			if (num > median) {
				pqright.add(num);
			} else {
				pqLeft.add(num);
			}

			if (pqright.size() == pqLeft.size()) {
				median = (pqright.peek() + pqright.peek()) / 2;
			} else {
				PriorityQueue<Integer> biggerQueue = pqright.size() > pqLeft.size() ? pqright : pqLeft;
				median = biggerQueue.peek();
			}
			System.out.println("median " + median);

		}

	}
}
