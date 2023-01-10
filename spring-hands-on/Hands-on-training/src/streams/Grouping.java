package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class Grouping {

	public static void main(String[] args) {
		Product p1= new Product(1, "glasses",2000);
		Product p2 = new Product(2,"speaker",8000);
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		
		Map<String, List<Product>> productNames = products.stream().collect(Collectors.groupingBy(p -> p.getName())); 
	
		System.out.println(productNames);
		
	}

}
