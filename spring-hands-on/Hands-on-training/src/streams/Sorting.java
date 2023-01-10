package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
List<String> names = new ArrayList<>();
		
		names.add("Manisha");
		names.add("Chandrashekar");
		names.add("natasha");
		
		List<String> sortedList = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
	}

}
