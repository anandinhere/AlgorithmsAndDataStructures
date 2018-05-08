package array.streams;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNonRepeatingCharacterFromStream {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 2, 1, 3, 4, 5, 6, 7, 8, 9, 0 };
		printFirstNonRepeating(arr);
	}

	private static void printFirstNonRepeating(int[] arr) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] map = new int[10];

		for (int i : arr) {
			q.add(i);
			map[i]++;

			while (!q.isEmpty()) {
				if (map[q.peek()] > 1) {
					q.remove();
				} else {
					System.out.println(q.peek());
					break;
				}
					
			}
			if (q.isEmpty()) {
				System.out.println(-1);
			}
		}

	}
}
