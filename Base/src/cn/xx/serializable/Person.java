package cn.xx.serializable;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -8429210907034985496L;
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}
