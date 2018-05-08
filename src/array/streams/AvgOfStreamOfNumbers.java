package array.streams;

import java.util.Arrays;

import array.sorting.ArrayUtil;

public class AvgOfStreamOfNumbers {
	public static void main(String[] args) {

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		printStreamAvg(arr);
	}

	private static void printStreamAvg(int[] arr) {

		float avg = 0;

		for (int i = 0; i < arr.length; i++) {
			avg = ((avg * i) + arr[i] )/ (i + 1);
			System.out.println(avg);
		}
	}
}
