package popularProblems.geeksMustDo.arrays;

import util.ArrayUtil;

public class SubArrayWithgivenSum {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 6, 4, 2, 7, 4, 6, 3 };
		ArrayUtil.printArray(arr);

		int sumTofind = 103;

		findSubArrayWithGivenSum(arr, sumTofind);

	}

	//basic idea is to keep adding numbers. if sum is more than expected. remove the numbers from beginning.
	private static void findSubArrayWithGivenSum(int[] arr, int sumTofind) {

		if (arr[0] == sumTofind) {
			// starts and ends here
			System.out.println();
			return;
		}

		int start = 0;
		int end = 0;

		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {

			// adding numbers. add only until end of the array
			while (currSum < sumTofind && end <arr.length) {
				currSum = currSum + arr[end];
				if (currSum == sumTofind) {
					// start and end here
					System.out.println("start " + i + "\nend " + end);
					return;
				}
				// end is already getting incremented here. so no need ot increment it somewhere
				// else with in this for loop
				end++;
			}

			// removing numbers
			if (currSum > sumTofind) {
				currSum = currSum - arr[i];
				// start = i + 1;
				// i = start;
				if (currSum == sumTofind) {
					// start and end here
					System.out.println("start " + (i + 1) + "\nend " + (end - 1));
					return;
				}

			}

		}
	}

}
