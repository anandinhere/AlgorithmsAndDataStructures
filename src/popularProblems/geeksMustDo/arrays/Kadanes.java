package popularProblems.geeksMustDo.arrays;

/*
 * Find max contiguous sum sub-array
 */
public class Kadanes {

	public static void main(String[] args) {

		int[] arr = {  -2, 4 };

		int maxContiguosSum = findMaxSum(arr);
		System.out.println( "max_sum "+ maxContiguosSum);

	}

	// If all numbers are negative, max sum will be Integer.MIN_VALUE. Keep track of
	// lowest int/
	// If max sum == Integer.MIN_VALUE --> lowest int is max value.
	// Important point to note is resetting to 0 when curr sum is 0.

	private static int findMaxSum(int[] arr) {

		int max_sum = Integer.MIN_VALUE;
		int currSum = 0;

		int start = 0;
		int end = 0;
		
		int s = 0; //Important to have this additional variable. otherwise big problems will occur.

		for (int i = 0; i < arr.length; i++) {

			currSum = currSum + arr[i];
			if (currSum < 0) {
				currSum = 0;
				s = i + 1;
				continue;
			}

			if (currSum > max_sum) {
				end = i;
				start = s;
				max_sum = currSum;
			}

			// max_sum = Math.max(max_sum, currSum);
		}

		System.out.println("start " + start + "\nend " + end);
		return max_sum;
	}

	private static int findMaxSumDynamic(int[] arr) {

		int max_sum = arr[0];
		int currSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currSum = Math.max(arr[i], currSum + arr[i]);
			max_sum = Math.max(max_sum, currSum);
		}

		return max_sum;

	}

}
