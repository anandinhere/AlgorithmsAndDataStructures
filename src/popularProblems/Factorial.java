package popularProblems;

public class Factorial {

	public static void main(String[] args) {

		int factorial = factorial(5);
		System.out.println(factorial);
	}

	private static int factorial(int i) {

		if (i == 1)
			return 1;

		return factorial(i - 1) * i;

	}
}
