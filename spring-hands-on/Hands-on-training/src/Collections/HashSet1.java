package Collections;

import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
		HashSet<String> cars = new HashSet<String>();
		cars.add("Verna");
		cars.add("Swift");
		cars.add("Ferari");
		cars.add("Jaguar");
		
		System.out.println(cars);
		System.out.println(cars.contains("Swift"));
		cars.remove("Verna");
		System.out.println(cars);
		System.out.println(cars.size());
	}

}
