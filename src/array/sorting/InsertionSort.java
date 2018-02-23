package array.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		ArrayUtil.printArray(arr);

	}

	/*
	 * n^2 comparisons, best n swaps, worst n^2 swaps
	 * all elements to the left of j will be sorted, but may be moved after insertion.
	 * pick j+1 and find the right spot for it, insert it
	 */
	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int min = i;

			for (int j = i; j >= 0; j--) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

	}
}
