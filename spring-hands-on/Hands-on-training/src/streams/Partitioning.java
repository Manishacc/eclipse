package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {

	public static void main(String[] args) {
		Product p1= new Product(1, "glasses",2000);
		Product p2 = new Product(2,"speaker",8000);
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		
		//Map<Boolean, List<Product>> output = products.stream().collect(Collectors.partitioningBy(n -> n.getName()>= 5));
	}

}
