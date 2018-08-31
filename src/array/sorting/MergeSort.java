package array.sorting;

import java.util.Arrays;

import util.ArrayUtil;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = ArrayUtil.getRandArray(0, 4);
		ArrayUtil.printArray(array);

		int[] res = mergeSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(res));

	}

	/*
	 * Intermediate arrays are combined to get final array. Unlike other sorting
	 * algorithms mergesort returns a new array with sorted elements.
	 * 
	 * OR use a temporary array and copy elements from temp array to original array at the end of merge
	 */

	private static int[] mergeSort(int[] array, int i, int j) {

		if (i == j) {
			int[] res = { array[i] };
			return res;
		}

		int mid = (i + j) / 2;

		int[] first_half = mergeSort(array, i, mid);

		int[] second_half = mergeSort(array, mid + 1, j);

		int[] res = merge(first_half, second_half);
		ArrayUtil.printArray(res);

		return res;

	}

	private static int[] merge(int[] first_half, int[] second_half) {

		int arr1_start = 0;
		int arr2_start = 0;

		int res_start = 0;

		int res[] = new int[first_half.length + second_half.length];

		while (arr1_start <= first_half.length - 1 && arr2_start <= second_half.length - 1) {
			if (first_half[arr1_start] < second_half[arr2_start]) {
				res[res_start] = first_half[arr1_start];
				res_start++;
				arr1_start++;

			} else if (first_half[arr1_start] > second_half[arr2_start]) {
				res[res_start] = second_half[arr2_start];
				res_start++;
				arr2_start++;

			}
		}

		if (arr1_start > first_half.length - 1) {
			while (arr2_start <= second_half.length - 1) {
				res[res_start] = second_half[arr2_start];
				res_start++;
				arr2_start++;
			}
		}
		if (arr2_start > second_half.length - 1) {
			while (arr1_start <= first_half.length - 1) {
				res[res_start] = first_half[arr1_start];
				res_start++;
				arr1_start++;
			}
		}

		return res;
	}
}
