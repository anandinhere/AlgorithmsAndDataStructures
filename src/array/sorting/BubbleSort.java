package array.sorting;

import java.util.Arrays;

import util.ArrayUtil;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		ArrayUtil.printArray(arr);

	}

	
	/*
	 * n^2 comparisons, n^2 swaps
	 * Start from j(=0), bubble to end (i = length-1)
	 * numbers will be sorted on the top (to the end)
	 * 1st for loop start is where the final array starts filling 
	 * 
	 * compare every num with num in next index. swap if greater than next.
	 */
	private static void bubbleSort(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {

			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
