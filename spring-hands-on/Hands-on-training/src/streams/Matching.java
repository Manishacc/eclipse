package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Matching {

	public static void main(String[] args) {
		
		Product p1 = new Product(1, "Bag", 2000);
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(new Product(2, "Book", 500));
		products.add(new Product(3, "shoes", 5000));
		products.add(new Product(4, "watch", 3000));
		
		Boolean result1 = products.stream().anyMatch(p->p.getId()>2);
		System.out.println(result1);
		
		Boolean result2 = products.stream().allMatch(p->p.getId()>2);
		System.out.println(result2);
		
		Boolean result3 = products.stream().noneMatch(p->p.getId()>2);
		System.out.println(result3);
		
		
		
	}

}
