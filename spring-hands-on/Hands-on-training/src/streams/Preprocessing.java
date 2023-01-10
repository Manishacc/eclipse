package streams;

import java.util.Arrays;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

public class Preprocessing {

	public static void main(String[] args) {
			List<Integer> numbers = Arrays.asList(2,5,3,4);
			
			List<Integer> squares = numbers.stream().map(s-> s*s).collect(Collectors.toList());
			System.out.println(squares);
	
	}

}
