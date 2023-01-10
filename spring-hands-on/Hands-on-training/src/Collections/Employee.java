package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee>{


		int id;
		String name;
		
		public Employee(int id, String name) {
			this.id= id;
			this.name=name;
		}
		
		@Override
		public int compareTo(Employee emp) {
			if(this.id> emp.id)
				return 1;
			else if(this.id== emp.id)
				return 0;
			else
				return -1;
		}
		
		public static void main(String[] args) {
			
			List<Employee> sony = new ArrayList<Employee>();
			Employee emp1 = new Employee(1, "Manisha");
			Employee emp2 = new Employee(2, "Shylaja");
			Employee emp3 = new Employee(3, "Vinoth");
			
			sony.add(new Employee(1, "Manisha"));
			sony.add(emp1);
			sony.add(emp2);
			sony.add(emp3);
			
			Collections.sort(sony);
			
			for (Employee employee : sony) {
				System.out.println(employee.name);
			}
			
			
			
		

	}

}
