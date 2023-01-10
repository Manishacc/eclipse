package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduce {

	public static void main(String[] args) {
			List<Integer> numbers =  Arrays.asList(10, 20,5,2,3);
			int sum = numbers.stream().reduce(0, (num1,num2)-> num1+num2);
			
			System.out.println(sum);
			
	}

}
