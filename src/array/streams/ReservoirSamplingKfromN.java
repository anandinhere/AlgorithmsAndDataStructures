package array.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import util.ArrayUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReservoirSamplingKfromN  {

	public static void main(String[] args) throws Exception {

		int k = 5;
		int noOfTickets = 10;

		int[] arr = ArrayUtil.getRandArray(1, 69);
		//System.out.println(Arrays.toString(arr));



		Set<Integer[]> set = new HashSet<Integer[]> ();

		try (BufferedReader br = new BufferedReader(new FileReader("/Users/anand/code/AlgorithmsAndDataStructures/powerball_from_2010.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				values = sortStrArray(values[1].split(" "));
				Integer[] numbers = new Integer[k];
				numbers = strToIntArray(values);
				//System.out.println(Arrays.toString(numbers));
				set.add(numbers);
			}
		}
		System.out.println("\n\n\n\n");
		for (int i = 0; i < noOfTickets; i++) {
			getRandomKArray(arr, k, set);
		}
		
	}

	private static String[] sortStrArray(String[] myArray){
		int size = myArray.length;

		for(int i = 0; i<size-1; i++) {
			for (int j = i+1; j<myArray.length; j++) {
				if(myArray[i].compareTo(myArray[j])>0) {
					String temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		}
		return myArray;
	}

	private static Integer[] strToIntArray(String [] numberStrs){
		Integer[] numbers = new Integer[numberStrs.length];
		for(int i = 0;i < numberStrs.length;i++)
		{
			// Note that this is assuming valid input
			// If you want to check then add a try/catch
			// and another index for the numbers if to continue adding the others (see below)
			numbers[i] = Integer.parseInt(numberStrs[i]);
		}
		return numbers;
	}

	private static void getRandomKArray(int[] arr, int randArraySize, Set<Integer[]> set) {

		int[] randK = new int[randArraySize];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {

			// First randArraySize elements are copied to randK array.
			if (i < randArraySize) {
				randK[i] = arr[i];
				if (i == randArraySize - 1) {
					//System.out.println(Arrays.toString(randK));
				}
				continue;
			}

			// get random number j from 0 - i ,
			// check if it is in between 0 and randArraySize-1.
			// If yes, replace randK[j] with arr[j]

			int j = r.nextInt(i + 1);
			//System.out.println("j== " + j);
			if ((j >= 0) && (j <= randArraySize - 1)) {
				// swap
				randK[j] = arr[i];
			}

		}


		

		int max = 26; int min = 1;
		int powerBallNo = (int)Math.floor(Math.random()*(max-min+1)+min);


//
//		random = random.replaceAll(", ", " ");
//		random = random.replaceAll("\\[", "");
//		random = random.replaceAll("]", "");

		int[] randKWithPB = new int[randK.length+1];

		for (int i = 0; i < randK.length; i++){
			randKWithPB[i] = randK[i];
		}
		randKWithPB[randK.length] = powerBallNo;


		//randKWithPB = new int[]{28, 45, 53, 56, 69, 20};

		int[] arrToCompare = randKWithPB.clone();

		Arrays.sort(arrToCompare);

		boolean flag = false;
		for ( Integer[] integerArr : set) {
			int[] intArr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
			if(Arrays.equals(intArr, arrToCompare)) {
				flag = true;

			}
		}
		if(!flag){
			System.out.println((Arrays.toString(randKWithPB)));
		}

	}
}
