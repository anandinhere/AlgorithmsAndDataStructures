package string;

public class CheckInterleaving {
	static char[] str1 = { 'a', 'b' };
	static char[] str2 = { 'c', 'd' };
	static char[] op = { 'c', 'a', 'b', 'e' };

	public static void main(String[] args) {
		System.out.println(check(0, 0, 0));
	}

	private static boolean check(int str1Index, int str2Index, int resIndex) {

		if (resIndex == op.length)
			return true;

		if (str1Index < str1.length && op[resIndex] == str1[str1Index]) {
			str1Index++;
		} else if (str2Index < str2.length && op[resIndex] == str2[str2Index]) {
			str2Index++;
		} else
			return false;

		return check(str1Index, str2Index, resIndex + 1);

	}

}
