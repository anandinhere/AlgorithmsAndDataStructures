package popularProblems;

public class Fibonacci {

	static int stop = 0;

	public static void main(String[] args) {

		printFibonacci(0, 1);
	}

	private static void printFibonacci(int i, int j) {

		if (stop == 10)
			return;

		System.out.println(i + j);
		stop++;
		printFibonacci(j, i + j);
	}
}
