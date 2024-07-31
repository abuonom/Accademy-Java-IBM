package com.sistemi.informativi.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.sistemi.informativi.bean.Company;
import com.sistemi.informativi.bean.Course;

public class main {

	public static void main(String[] args) {
		Object array [] = new Object[2];
		array[0] = new Course("1028A", "java", "Rome");
		array[1] = new Company("OpenJob", "VatNumber");
		
		for(Object o : array) {
			System.out.println("Contenuto array" + o);
		}
		
		ArrayList<Course> courseList = new ArrayList<>();
		courseList.add(new Course("1026U",".Net","Milan"));
		courseList.add(new Course("1843U",".Net","Napoli"));
		courseList.remove(1);
		for(Course c: courseList) 
		{
			System.out.println("Contenuto array" + c);
		}
		System.out.println(courseList);
		/*
		 * <Course> è un Generics si applica inserendo nelle parentesi angolari
		 * il tipo di dato che stiamo per inserire in ArrayList
		 */
		
		//ArrayList di String
		
		ArrayList<String> daysList = new ArrayList<>();
		daysList.add("Lunedì");
		daysList.add("Martedì");
		daysList.add("Mercoledì");
		daysList.add("Giovedì");
		daysList.add("Venerdì");
		daysList.add("Sabato");
		daysList.add("Domenica");
		daysList.add("Lunedì");
		//forEach (for enhanced)
		for (String string : daysList) {
			System.out.println(string);
		}
		
		
		//ArrayList di inter
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(4);
		numbers.add(11);
		//forEach funzionale
		System.out.print("ARRAY : ");
		numbers.forEach(number->System.out.println(number));
		
		/*
		 * HashSet non è ordinato e non ha un indicizzazione
		 */
		
		HashSet <String> daysSet = new HashSet<>();
		daysSet.add("Lunedì");
		daysSet.add("Martedì");
		daysSet.add("Mercoledì");
		daysSet.add("Giovedì");
		daysSet.add("Venerdì");
		daysSet.add("Sabato");
		daysSet.add("Domenica");
		daysSet.add("Lunedì");
		System.out.println("HASHSET : " +daysSet);
		
		/*
		 * HASHSET, non include duplicati se e solo se, è possibile confrontare
		 * i valori al suo interno, ad esempio Course è una classe, se non avessimo fatto
		 * l'overload di Equals, ci saremmo trovati entrambi i dati
		 */
		HashSet <Course> courseSet = new HashSet<>();
		courseSet.add(new Course("1026U",".Net","Milan"));
		courseSet.add(new Course("1026U",".Net","Milan"));
		System.out.println("HASHSET : " +courseSet);
		
		/*
		 * HASHMAP
		 * n.b. la chiave non è mutabile
		 */
		Course course1 = new Course("1026U",".Net","Milan");
		Course course2 = new Course("1027U",".Net","Rome");
		HashMap <String,Course> courseMap = new HashMap<>();
		courseMap.put(course1.getCode(),course1);
		courseMap.put(course2.getCode(),course2);
		System.out.println("HASHMAP : " + courseMap);
	}
}