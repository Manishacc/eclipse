package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Students {
	String name;
	int id;
	int age;
	
	public Students(String name, int id, int age){
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	public static void main(String[] args) {
		ArrayList<Students> myList = new ArrayList<Students>();
		
		myList.add(new Students("Yasir" , 1, 22));
		myList.add(new Students("Deepak" , 2, 22));
		myList.add(new Students("Manisha" , 3, 22));
				
		Collections.sort(myList , new ComparatorClass());
		
		for(Students s:myList) {
			System.out.println(s.name);
		}
		
	}	

}
