package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Range {

	public static void main(String[] args) {
		//List<Integer> numbers = Arrays.asList(20, 33, 65,12, 78,30);
		//int[] range = IntStream.range(20, 50).toArray();
		int[] numbers = IntStream.range(0, 10).toArray();
		System.out.println(numbers);
		
	}

}
