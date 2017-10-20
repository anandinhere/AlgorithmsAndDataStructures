package string;

public class AtoI {
	public static void main(String[] args) {
		char[] str = new String("9375").toCharArray();

		System.out.println(atoi(str));
	}

	private static int atoi(char[] str) {

		int sum = 0;
		for (int i = 0; i < str.length; i++) {
			sum = (sum * 10) + str[i] - '0';
			System.out.println(sum);
		}
		return sum;

	}
}
