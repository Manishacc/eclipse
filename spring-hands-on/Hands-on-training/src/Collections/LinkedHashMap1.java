package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap1 {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

		hm.put(100, "Yasir");
		hm.put(101, "Deepak");
		hm.put(102, "Manisha");

		System.out.println(hm);

	}

}
