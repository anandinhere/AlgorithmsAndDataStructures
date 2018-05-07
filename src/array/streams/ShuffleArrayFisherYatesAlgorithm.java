package array.streams;

import java.util.Arrays;
import java.util.Random;

import array.sorting.ArrayUtil;

public class ShuffleArrayFisherYatesAlgorithm {
	public static void main(String[] args) {

		int arr[] = ArrayUtil.getRandArray(0, 10);

		System.out.println(Arrays.toString(arr));
		
		ShuffleArray(arr);

		System.out.println(Arrays.toString(arr));
	}

	/*
	 * https://www.geeksforgeeks.org/shuffle-a-given-array/
	 */
	private static void ShuffleArray(int[] arr) {

		Random randObj = new Random();
		for (int i = arr.length - 1; i > 0; i--) {

			int rand = randObj.nextInt(i);

			// swap
			int temp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = temp;

		}
	}
}
