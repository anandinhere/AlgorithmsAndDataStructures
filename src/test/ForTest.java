package test;

public class ForTest {

	public static void main(String[] args) {
		
		
		        
		        String str1 = "this is a test string";
		        String str2 = "tist";
		        
		        
		        int[] str1CharArray = new int[256];
		        
		        char[] str1Char = str1.toCharArray();
		        
		        for(char c : str1Char){
		            str1CharArray[(int)c]++;
		        }
		        
		        for(char c : str1Char){
		            System.out.println( str1CharArray[(int)c]);
		        }
		        
		        
		        
		        
		    
		
		for (int i = 0; i < 10; i++) {

			if (i == 5)
				i = 9;
			//System.out.println(i);

		}
	}
}
