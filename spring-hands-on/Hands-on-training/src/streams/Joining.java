package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Manisha");
		names.add("Namrata");
		names.add("Swati");
		
		String joinedWord = names.stream().collect(Collectors.joining(","));
		System.out.println(joinedWord);
	}

}
