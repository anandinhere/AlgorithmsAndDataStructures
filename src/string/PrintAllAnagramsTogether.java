package string;

import java.util.Arrays;

public class PrintAllAnagramsTogether {

	static String[] ip = { "cat", "dog", "tac", "god", "act" };

	public static void main(String[] args) {

		Dupe[] dupe = new Dupe[ip.length];

		for (int i = 0; i < ip.length; i++) {

			char[] temp = ip[i].toCharArray();
			Arrays.sort(temp);

			dupe[i] = new Dupe(temp.toString(), i);

		}

		Arrays.sort(dupe);

		for (int i = 0; i < dupe.length; i++) {

			System.out.println(ip[dupe[i].origIndex]);
		}

	}

}

class Dupe implements Comparable<Dupe> {
	public String word;
	public int origIndex;

	public Dupe(String word, int index) {
		this.word = word;
		origIndex = index;
	}

	@Override
	public int compareTo(Dupe o) {

		return this.word.compareTo(o.word);
	}

}
