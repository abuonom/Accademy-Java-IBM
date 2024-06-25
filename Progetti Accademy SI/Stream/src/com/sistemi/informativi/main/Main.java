package com.sistemi.informativi.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream <String> colorStream = Stream.of("blue","red","yellow");
		//Stream <String> colorStreamNew = Stream.concat(Stream.of("brown"), colorStream);
		colorStream = Stream.concat(Stream.of("brown"),colorStream);
		colorStream.forEach(color->System.out.println("Color Stream" + color));
		
		Stream<String> courseStream = Stream.of("Java",".Net","Angular");
		
		/*
		 * Filter è un operatore funzionale che applicato ad uno stream
		 * di partenza restituisce un nuovo stream sulla base di una condizione
		 * data al filter
		 */
		
		Stream <String> AngularCourseStream = courseStream.
				filter(course->course.equals("Angular"));
		AngularCourseStream.forEach(course->System.out.println(course));
		//n.b. forEach consuma lo stream, dopo non è utilizzabile
		
		Stream<Integer> numberStream = Stream.of(4,8,9);
		numberStream = numberStream.map(number->number*2);
		numberStream.forEach(number->System.out.println(number));
		

		Stream<String> daysStream = Stream.of("Java","Net","Angular","Angular");
		daysStream.sorted().distinct().forEach(day->System.out.println(day));
		
		//CONVERSIONE DA STREAM A LIST
		Stream<String> sports = Stream.of("Calcio", "Basket", "Tennis");
		List<String> sportList = sports.toList();
		System.out.println(sportList);
		
		//CONVERSIONE DA STRUTTURA A STREAM
		
		ArrayList<Integer> numberList = new ArrayList<>();
		numberList.add(3);
		numberList.add(4);
		Stream<Integer> number = numberList.stream();
		number.forEach(num->System.out.println(num));
		
		//CONVERSIONE ARRAY A STREM
		
		Integer array[] = {5,6};
		Stream<Integer> number2 = Stream.of(array);
		number2.forEach(num->System.out.println(num));
	}

}
