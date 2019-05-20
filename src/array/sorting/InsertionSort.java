package array.sorting;

import java.util.Arrays;

import util.ArrayUtil;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		ArrayUtil.printArray(arr);

	}

	// [7, 5, 9, 6, 2, 1, 0, 10, 3, 4, 8]

	/*
	Worst-case performance	О(n2) comparisons and swaps
	Best-case performance	O(n) comparisons, O(1) swaps
	Average performance	О(n2) comparisons and swaps
	 *
	 * all elements left of i will be sorted at any given time, but may be moved
	 * after insertion.
	 */
	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int min = i - 1;
			while (min >= 0 && arr[i] < arr[min]) { //finding the position to insert
				min = min - 1;
			}
			insert(arr[i], i, min + 1, arr); // min + 1 is the index where the
												// while loop was executed
												// successfully latest time.
		}

	}

	private static void insert(int val, int curr, int min, int[] arr) {
		for (int i = curr; i > min; i--) {
			arr[i] = arr[i - 1];
		}
		arr[min] = val;

	}
}
