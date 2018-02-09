package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int lastAnswer = 0;

		int N = in.nextInt();
		int totalInputs = in.nextInt();

		ArrayList[] arr = new ArrayList[N];

		for (int i = 0; i < totalInputs; i++) {
			int query = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			int seqIndex = (x ^ lastAnswer) % N;
			if (arr[seqIndex] == null)
				arr[seqIndex] = new ArrayList<>();
			if (query == 1) {

				arr[seqIndex].add(y);
			} else {

				lastAnswer = (int) arr[seqIndex].get(y % (arr[seqIndex].size()));
				System.out.println(lastAnswer);
			}
		}
	}
}
