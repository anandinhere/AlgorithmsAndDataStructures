package popularProblems.geeksMustDo.arrays;

public class FindMissingNumberInArray {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		int totalNos = 6;

		int missing = findMissingBitMan(arr, totalNos);
		System.out.println(missing);

	}

	private static int findMissing(int[] arr, int totalNos) {

		int totalSum = (totalNos * (totalNos + 1)) / 2;
		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum = arrSum + arr[i];
		}

		return totalSum - arrSum;
	}

	private static int findMissingBitMan(int[] arr, int totalNos) {

		int totalXor = 0;
		for (int i = 1; i <= totalNos; i++) {
			totalXor = i ^ totalXor;
		}

		int arrXor = 0;
		for (int i = 0; i < arr.length; i++) {
			arrXor = arrXor ^ arr[i];
		}

		return totalXor ^ arrXor;
	}
}
