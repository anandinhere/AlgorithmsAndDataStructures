package array.streams;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
	public static void main(String[] args) {
		StreamToIntArray();
		StreamToStrArray();
		streamFilter();
		streamCollect();
	}

	private static void StreamToIntArray() {
		Stream<Integer> stream = Stream.of(5, 6, 7, 8);
		// Integer[] intArr = (Integer[]) stream.toArray(); this wont work for
		// whatever reason

		Object[] intArr = stream.toArray();
		System.out.println(Arrays.toString(intArr));
	}

	private static void StreamToStrArray() {
		Stream<String> stream = Stream.of("one", "two", "three");
		// Integer[] intArr = (Integer[]) stream.toArray(); this wont work for
		// whatever reason

		Object[] strArr = stream.toArray();
		System.out.println(Arrays.toString(strArr));

	}

	private static void streamFilter() {

		Stream<String> stream = Stream.of("one", "two", "three");
		// Integer[] intArr = (Integer[]) stream.toArray(); this wont work for
		// whatever reason

		
		Object[] arr = stream.filter(str -> str.contains("o")).toArray();
		
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	private static void streamCollect() {

		Stream<String> stream = Stream.of("one", "two", "three");
		// Integer[] intArr = (Integer[]) stream.toArray(); this wont work for
		// whatever reason

		
		String result = stream.filter(str -> str.contains("o")).collect(Collectors.joining());
		
		System.out.println(result);
		
		
	}

}
