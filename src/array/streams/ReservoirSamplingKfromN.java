package array.streams;

import java.util.Arrays;
import java.util.Random;

import array.sorting.ArrayUtil;

public class ReservoirSamplingKfromN {

	public static void main(String[] args) {

		int k = 5;

		int[] arr = ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		getRandomKArray(arr, k);
	}

	private static void getRandomKArray(int[] arr, int k) {

		int[] randK = new int[k];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {

			// First k elements are copied to randK array.
			if (i < k) {
				randK[i] = arr[i];
				if (i == k - 1) {
					System.out.println(Arrays.toString(randK));
				}
				continue;
			}

			// get random number j from 0 - i ,
			// check if it is in between 0 and k-1.
			// If yes, replace randK[j] with arr[j]

			int j = r.nextInt(i + 1);
			System.out.println("j== " + j);
			if ((j >= 0) && (j <= k - 1)) {
				// swap
				randK[j] = arr[i];
			}
			System.out.println(Arrays.toString(randK));
		}
	}
}
