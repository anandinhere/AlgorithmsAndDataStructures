package string;

public class FirstNonRepeatingChar {
	public static void main(String[] args) {

		String str1 = "geeksforgeeksa";

		char[] str1Arr = str1.toCharArray();

		int[] ascii = new int[256];

		int minDups = Integer.MAX_VALUE;
		int minDupsIndex = -1;

		for (int i = 0; i < str1Arr.length; i++) {

			int charIndex = (int) str1Arr[i];

			ascii[charIndex]++;

		}

		minDups = Integer.MAX_VALUE;
		minDupsIndex = -1;
		for (int i = 0; i < str1Arr.length; i++) {

			int asciiIndex = (int) str1Arr[i];

			if (ascii[asciiIndex] >= 1) {
				if (ascii[asciiIndex] < minDups) {
					minDups = ascii[asciiIndex];
					minDupsIndex = asciiIndex;
					System.out.println(minDupsIndex);
				}

			}

		}

		System.out.println((char) minDupsIndex);

	}
}
