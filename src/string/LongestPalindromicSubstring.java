package string;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {

		printLPS(new String("orgeeksskeegfor"));

	}

	private static void printLPS(String ip) {

		char[] ipArr = ip.toCharArray();

		int start = -1;
		int length = -1;

		for (int i = 1; i < ipArr.length; i++) {

			int low = i - 1;
			int high = i;
			int templen = 0;

			while (low >= 0 && high < ipArr.length && ipArr[low] == ipArr[high]) {
				templen = high - low + 1;
				if (templen > length) {
					start = low;
					length = templen;
				}
				--low;
				++high;

			}

			low = i - 1;
			high = i + 1;
			templen = 0;

			while (low >= 0 && high < ipArr.length && ipArr[low] == ipArr[high]) {
				templen = high - low + 1;
				if (templen > length) {
					start = low;
					length = templen;
				}
				--low;
				++high;

			}

		}

		System.out.println(ip.substring(start, start + length ));

	}
}
