package streams;

import java.util.Arrays;
import java.util.List;

public class Counting {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Manisha","tanihsa","nelsonMandela","NarendraModi");
		long count = names.stream().filter(n -> n.length()>8).count();
		System.out.println(count);
	}

}
