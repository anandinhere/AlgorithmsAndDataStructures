package array.sorting;

public class MergeSortArray {

	// , 5, 4, 1, 2, 3
	static int[] array = { 9, 8, 7, 6 };

	public static void main(String[] args) {

		mergeSort(0, array.length - 1);
		
		System.out.println(array.toString());

	}

	private static void mergeSort(int i, int j) {

		if (i == j) {
			return;
		}

		//if (i == j - 1)
			//return;

		mergeSort(i, j / 2);
		mergeSort((j / 2) + 1, j);

		merge(i, (j / 2) + 1);

	}

	private static void merge(int i, int j) {
		while (i <= j && i < array.length && j < array.length) {
			if (array[i] > array[j]) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;

				j++;

			} else if (array[j] > array[i]) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

				i++;
			} else {
				i++;
				j++;
			}
		}
	}
}
