package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Conversion {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("hi");
		words.add("Hello");
		words.add("How are you");
		
		Map<String, Integer> wordsLength = words.stream().collect(Collectors.toMap(output ->output, output -> output.length()));
		System.out.println(wordsLength);
	}

}
