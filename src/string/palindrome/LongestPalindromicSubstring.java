package string.palindrome;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {


		String str = "aaabaa";
		printLPS(str);
		int length = findLPS(str.toCharArray(),0,str.length()-1);
		System.out.println(length);

	}


	private static int findLPS(char[] str, int i, int j){

		if(i==j && str[i]==str[j]){
			return 1;
		}

//		if(i==j && str[i]!=str[j]){
//			return 0;
//		}

		if( j == i+1 && str[i]==str[j]){
			return 2;
		}

		if( j == i+1 && str[i]!=str[j]){
			return 0;
		}

		int length = 0;

		int nextLen = findLPS(str,i+1,j-1);
		if(nextLen == j-i-1 && str[i]==str[j] ){
			length  = 2 + nextLen;
		}
		else{
			length = Math.max(findLPS(str,i+1,j),findLPS(str,i,j-1));
		}


		return  length;



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
		if(start==-1){
			System.out.println("no palindrome");
		}else
			System.out.println(ip.substring(start, start + length ));

	}
}
