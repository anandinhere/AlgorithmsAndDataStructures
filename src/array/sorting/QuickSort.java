package array.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {

		int[] arr = { 0, 9, 5, 1, 2, 8, 7, 10, 4, 3, 6 };
		// ArrayUtil.getRandArray(0, 10);
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		ArrayUtil.printArray(arr);

	}

	private static void quickSort(int[] arr, int start, int end) {
		System.out.println("Start " + start + " end " + end);
		if (start >= end) {
			System.out.println("returning");
			return;
		}

		int pivot = partitionArray(arr, start, end);
		System.out.println("Pivot " + arr[pivot]);
		ArrayUtil.printArray(arr);

		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}

	private static void quickSorWrong(int[] arr, int start, int end) {
		System.out.println("Start " + start + " end " + end);
		if (start >= end) {
			System.out.println("returning");
			return;
		}

		int pivotIndex = getPivot(arr, start, end);
		int pivotVal = arr[pivotIndex];
		System.out.println("Pivot " + arr[pivotIndex]);

		partitionArrayWrong(arr, pivotVal, start, end);
		ArrayUtil.printArray(arr);

		quickSort(arr, start, pivotIndex - 1); // WRONG - Because pivotindex is
												// the correct index of
												// arr[pivotindex] after running
												// partition. How to keep track
												// of it?
		// It is nothing but where startptr end up during partition. Keep track
		// of startptr and that is the pivotindex for recursion.
		quickSort(arr, pivotIndex + 1, end);
	}

	private static void partitionArrayWrong(int[] arr, int pivot, int start,
			int end) {

		int startPtr = start;
		int endPtr = end;

		while (startPtr < endPtr && startPtr <= end && endPtr >= start) {
			System.out.println(startPtr + " " + endPtr);
			if (arr[startPtr] < pivot) {
				startPtr++;
			} else if (arr[endPtr] > pivot) {
				endPtr--;
			} else {
				int temp = arr[startPtr];
				arr[startPtr] = arr[endPtr];
				arr[endPtr] = temp;
				// startPtr++;
				// endPtr--;
			}

		}
		System.out.println(startPtr + " " + endPtr);
	}

	private static int partitionArray(int[] arr, int start, int end) {

		int startPtr = start;
		int endPtr = end;

		int pivot = getPivot(arr, start, end);
		int pivotVal = arr[pivot];

		while (startPtr < endPtr) {
			System.out.println(startPtr + " " + endPtr);
			if (arr[startPtr] < pivotVal) {
				startPtr++;
			} else if (arr[endPtr] > pivotVal) {
				endPtr--;
			} else {
				int temp = arr[startPtr];
				arr[startPtr] = arr[endPtr];
				arr[endPtr] = temp;
				
			}

		}
		System.out.println(startPtr + " " + endPtr);
		return startPtr;
	}

	private static int getPivot(int[] arr, int start, int end) {

		return end;
		// int mid = (start + end) / 2;
		// TreeMap<Integer, Integer> hMap = new TreeMap<Integer, Integer>();
		// hMap.put(arr[mid], mid);
		// hMap.put(arr[start], start);
		// hMap.put(arr[end], end);
		//
		// if (hMap.size() > 1) {
		// hMap.pollFirstEntry();
		// }
		// return hMap.pollFirstEntry().getKey();

		// if (arr[start] <= arr[mid] && arr[mid] <= arr[end])
		// return mid;
		// else if (arr[mid] <= arr[end] && arr[end] <= arr[start])
		// return end;
		// else
		// return start;

	}
}
