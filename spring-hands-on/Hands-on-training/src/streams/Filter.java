package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
	public static void main(String args[]) {
		List<Product> productList = new ArrayList<Product>();
		List<Integer> numbers = Arrays.asList(1,25,76,23,98);
		
		productList.add(new Product(1, "laptop", 50000));
		productList.add(new Product(2,"TV", 100000));
		productList.add(new Product(3, "smartwatch", 5000));
		
		List<String> newList = productList.stream().filter(p -> p.price>6000).map(p-> p.name).collect(Collectors.toList());
		List<Integer> evenNumbers = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());
		
		System.out.println(newList);
		System.out.println(evenNumbers);
		
		
	}
}
