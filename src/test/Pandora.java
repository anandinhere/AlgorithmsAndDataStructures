package test;

public class Pandora {

	public static void main(String[] args) {
	System.out.println(method(2));	
	}
	
	static boolean method(int n) {
		if (n < 2) return false;
		for (int i = 2; i < n; i++) {
		if (n%i == 0) {
		return false;
		}
		}
		return true;
		} 
}
