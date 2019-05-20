package array.sorting;

import java.util.Arrays;

import util.ArrayUtil;

public class SelectionSort {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		selectionSort(arr);
		ArrayUtil.printArray(arr);

	}

	/*
	 * n^2 comparisons, n swaps
	 * start from i , get min by comparing all to the right of it
	 * swap with the smallest. numbers will be sorted from start to end
	 */
	private static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int min = i;

			for (int j = i+1; j < arr.length; j++) {

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
