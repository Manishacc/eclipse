package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finding {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Manisha");
		names.add("Chandrashekar");
		names.add("natasha");
		
		Optional<String> longNames =  names.stream().filter(word -> word.length()>8).findFirst();
		
		System.out.println(longNames);
	
		
	}

}
