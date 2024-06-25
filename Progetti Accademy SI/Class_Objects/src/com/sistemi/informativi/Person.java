package com.sistemi.informativi;

import java.util.Objects;

public class Person {
	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}
	/*
	 Variabili di istanza
	 Dichiarate internamente al corpo di una classe
	 Visibile in qualsiasi metodo della classe stessa
	 Ogni oggetto, avrà una propria copia
	 */
	String firstName;
	String lastName;
	int age;
	
}
