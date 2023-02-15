package learning_java_ttt.oop.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InheritanceApp {

	public static void main(String[] args) {
		/* Subtype polymorphism
		 * 
		 * If a class A is a subclass of B, we can put an 
		 * instance/object of class A inside a variable of
		 * type B.
		 */
		Player shrek = new Player(0, 0, "Shrek");
		Entity fiona = new Player(0, 1, "Fiona");
		Entity someObj = new InvincibleObject(0, 2);

//		System.out.println(shrek.getName());
//		System.out.println(fiona.getName());
		
		// How do we have unique behaviours on each class
		// without creating new classes which inherit from 
		// Player?
		
		/*
		 * List is an interface in Java, it defines a 
		 * way to interact with a collection of objects.
		 * - Only objects, not primitives
		 * 
		 * An ArrayList is an implementation of the List interface
		 * - an interface defines the public API (methods) of some 
		 *   type hierarchy (classes which are inheriting the interface)
		 */
		List<String> myStrings = new ArrayList<>();
		myStrings.add("some string");
		myStrings.add("another string");
		
		// get a string out of the list
		System.out.println(myStrings.get(1));
		
//		myStrings.forEach(s -> System.out.println(s));
//		myStrings.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		
//		});
		
		for (String s : myStrings) {
			System.out.println(s);
		}
	}

}
