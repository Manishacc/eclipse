package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
	public static void main(String args[]) {
		List<Product> productList = new ArrayList<Product>();
		
		
		productList.add(new Product(1, "laptop", 50000));
		productList.add(new Product(2,"TV", 100000));
		productList.add(new Product(3, "smartwatch", 5000));
		
		List<String> newList = productList.stream().filter(p -> p.price>6000).map(p-> p.name).collect(Collectors.toList());
		
		System.out.println(newList);
		
		
	}
}
