package array.sorting;

import java.util.Arrays;

public class MergeSortString {

	public static void main(String[] args) {
		char[] array = { 'b', 'd', 'a', 'c', 'e' };
		System.out.println(Arrays.toString(array));

		char[] res = mergeSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(res));

	}

	/*
	 * charermediate arrays are combined to get final array. Unlike other
	 * sorting algorithms mergesort returns a new array with sorted elements.
	 * 
	 * OR use a temporary array and copy elements from temp array to original
	 * array at the end of merge
	 */

	public static char[] mergeSort(char[] array, int i, int j) {

		if (i == j) {
			char[] res = { array[i] };
			return res;
		}

		int mid = (i + j) / 2;

		char[] first_half = mergeSort(array, i, mid);

		char[] second_half = mergeSort(array, mid + 1, j);

		char[] res = merge(first_half, second_half);
		//System.out.println(Arrays.toString(res));

		return res;

	}

	private static char[] merge(char[] first_half, char[] second_half) {

		char arr1_start = 0;
		char arr2_start = 0;

		char res_start = 0;

		char res[] = new char[first_half.length + second_half.length];

		while (arr1_start <= first_half.length - 1
				&& arr2_start <= second_half.length - 1) {
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
