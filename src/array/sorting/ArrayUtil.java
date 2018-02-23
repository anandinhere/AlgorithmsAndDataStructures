package array.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	static int[] getRandArray(int min, int max) {

		int size = max - min + 1;
		int[] arr = new int[size];
		ArrayList<Integer> list = new ArrayList<Integer>();

		Random r = new Random();
		while (list.size() < size) {

			int next = r.nextInt(max + 1 - min) + min;
			if (!list.contains(next)) {
				list.add(next);
			}

		}

		int index = 0;
		for (int h : list) {
			arr[index] = h;
			index++;
		}

		return arr;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
		// for (int e : arr) {
		// System.out.println(e);
		// }
	}

	public static void main(String[] args) {
		int[] arr = getRandArray(1, 10);

		for (int e : arr) {
			System.out.println(e);
		}
	}
}
