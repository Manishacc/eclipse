package Collections;

import java.util.LinkedHashSet;

public class LinkedHashSet1 {

	public static void main(String[] args) {
			LinkedHashSet<String> names = new LinkedHashSet<>();
			names.add("Manisha");
			names.add("Jyoti");
			names.add("Shylaja");
			names.add("Raksha");
			System.out.println(names);
			System.out.println(names.contains("Isha"));
			names.remove("Raksha");
			System.out.println("names"+names +"size:"+ names.size());
			
	}

}
