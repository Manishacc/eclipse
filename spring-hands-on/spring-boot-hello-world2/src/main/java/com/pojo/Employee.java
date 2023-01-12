package com.pojo;

public class Employee {
	private String name;
	private String id;
	private int age;
	private String nationality;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
    public String toString() {
        return name + " " + id + " " + age + " " + nationality;    //anything you want to return, in this case all the values in the class
    }

}
