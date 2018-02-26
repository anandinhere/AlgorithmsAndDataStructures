package array.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		ArrayUtil.printArray(arr);

	}

	// [7, 5, 9, 6, 2, 1, 0, 10, 3, 4, 8]

	/*
	 * best case - n comparisons, worst case - n comparisons and n^2 moves all
	 * elements left of i will be sorted at any given time, but may be moved
	 * after insertion.
	 */
	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int min = i - 1;
			while (min >= 0 && arr[i] < arr[min]) {
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
