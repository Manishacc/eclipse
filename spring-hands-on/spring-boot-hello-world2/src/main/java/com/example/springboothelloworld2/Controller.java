package com.example.springboothelloworld2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Employee;

@RestController
public class Controller {
	@RequestMapping("/")
	public String hello() {
		//createObject();
		createData();
		return "Hello javaTpoint";
	}

	private void createObject() {
		ArithmeticOperation d1 = new ArithmeticOperation();
		d1.calculate(10, 20);
		Addition a = new Addition();
		a.calculate(10, 5);
		Substraction s = new Substraction();
		s.calculate(100, 50);
		Multiplication m = new Multiplication();
		m.calculate(2, 2);
	}

	private void createData() {
		Employee e1 = new Employee();
		e1.setId("101");
		e1.setName("Manisha");
		e1.setAge(22);
		e1.setNationality("Indian");

		Employee e2 = new Employee();
		e2.setId("102");
		e2.setName("Shylaja");
		e2.setAge(25);
		e2.setNationality("Indian");

		Employee e3 = new Employee();
		e3.setId("103");
		e3.setName("Tejaswini");
		e3.setAge(23);
		e3.setNationality("Indian");

		Employee e4 = new Employee();
		e4.setId("104");
		e4.setName("Jyoti");
		e4.setAge(25);
		e4.setNationality("Indian");

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(e4);
		employeeList.add(e3);
		employeeList.add(e2);
		employeeList.add(e1);

		System.out.println(employeeList);

		List<Employee> newList = employeeList.stream().filter(n -> n.getName().startsWith("S"))
				.collect(Collectors.toList());
		System.out.println(newList);

		List<String> names = employeeList.stream().map(e -> e.getName()).collect(Collectors.toList());
		System.out.println(names);

		Map<String, String> mapIdName = employeeList.stream()
				.collect(Collectors.toMap(a -> a.getId(), a -> a.getName()));
		System.out.println(mapIdName);

		Set<Employee> set = employeeList.stream().distinct().collect(Collectors.toSet());
		System.out.println(set);

		Map<Object, List<Employee>> group = employeeList.stream().collect(Collectors.groupingBy(a -> a.getAge() > 30));

		List<Employee> employees = employeeList.stream().filter(a -> a.getName().startsWith("S") && a.getAge() > 30)
				.collect(Collectors.toList());
		System.out.println(employees);

		List<Integer> empAge= employeeList.stream().map(a->a.getAge()).sorted().collect(Collectors.toList());
		System.out.println(empAge);

		Long count = employeeList.stream().filter(a -> a.getAge() > 30 && a.getNationality() == "Indian").count();
		System.out.println(count);

		String empNames = employeeList.stream().map(a->a.getName()).collect(Collectors.joining(","));
		System.out.println(empNames);
	}

}
