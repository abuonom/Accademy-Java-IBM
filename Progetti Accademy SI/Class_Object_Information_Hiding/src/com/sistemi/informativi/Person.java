package com.sistemi.informativi;
 /*
  * JAVA BEAN = Una classe contenente variabili di istanza
  * metodi di set e get per ogni variabile di istanza
  * 
  * Se io aggiungessi un metodo di somma ad esempio, non è più un bean
  */
public class Person {
	private String firstName;
	private String lastName;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
