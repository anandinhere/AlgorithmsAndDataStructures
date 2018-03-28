package datastructsimpl;

import java.util.Arrays;
import java.util.Scanner;

public class QueueUsingArray {
	int[] queue = null;
	int currSize = 0;
	boolean reverse = false;
	int start = 0;
	int end = 0;

	public QueueUsingArray(int size) {
		queue = new int[size];
	}

	public void add(int x) {
		System.out.println("add " + x);
		if (currSize == queue.length) {
			System.out.println("Queue Full");
			return;
		}

		if (currSize == 0) {
			queue[end] = x;
		} else if (end >= start) {
			end++;
			if (end == queue.length) {
				end = 0;
			}
			queue[end] = x;
		} else if (end < start) {
			end++;
			queue[end] = x;
		}
		currSize++;
		System.out.println(this);
	}

	public int remove() {
		System.out.println("remove");
		if (currSize == 0) {
			System.out.println("Queue Empty");
			return -1;
		}

		if (currSize == 1) {
		} else if (start <= end) {
			start++;
			if (start == queue.length) {
				start = 0;
			}
		} else if (start > end) {
			start++;
			if (start == queue.length) {
				start = 0;
			}
		}
		currSize--;
		System.out.println(this);
		return queue[start];

	}

	@Override
	public String toString() {
		String output = "Start " + start + " \nend " + end + "\ncurrSize "
				+ currSize + "\narray " + Arrays.toString(queue) + "\n-----";

		int count = 0;
		int endCopy = end;
		System.out.print("Queue elements from end to start ");
		while (count < currSize) {
			System.out.print(queue[endCopy] + " ");
			endCopy--;
			if (endCopy == -1) {
				endCopy = queue.length - 1;
			}
			count++;
		}
		System.out.println("\n");

		return output;
	}

	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray(3);

		System.out.println("Menu \n1 - add \n2 - remove \n3 - stop");

		Scanner in = new Scanner(System.in);

		int next = 0;
		while (next != 3) {

			next = in.nextInt();

			switch (next) {
			case 1:
				q.add(in.nextInt());
				break;
			case 2:
				q.remove();
				break;

			default:
				break;
			}
		}

		System.out.println("out of menu - stopped");

	}
}
