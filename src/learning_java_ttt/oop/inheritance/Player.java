package learning_java_ttt.oop.inheritance;

import java.util.ArrayList;

// A class in Java can inherit from another class
// according to the rules of access modifiers:
// 
// We can inherit:
// - public fields and methods
// - protected fields and methods
// We don't inherit constructors
//
// Classes can only inherit from one other class
public class Player extends Entity {

	int health = 100;
	String name;
	
	/* If a parent-/base-/super-type doesn't have a no argument 
	 * constructor. We must supply a constructor which makes 
	 * a call to the parent classes constructor
	 * 
	 * - If the super keyword is to be specified, it must
	 *   be on the first line of the constructor.
	 *   This is the same if we also specify the this keyword
	 *   
	 * We can use `this()` to chain constructor calls
	 */
	public Player() {
		this(0, 0);
	}
	
	// This is constructor overloading
	// - it has a different signature (name and parameters)
	public Player(int x, int y) {
		super(x, y);
	}
	
	public Player(int x, int y, String name) {
		super(x, y);
		this.name = name;
	}
	
	
}


/*
	Access modifiers:
	- public   : Accessible anywhere
	- private  : Only accessible in the same class
	- protected: Accessible in the same package or a subclass
	             anywhere
	- default  : When an access modifier is not specified, 
	             the item is stated to be package-private.
	             Only accessible by classes in the same package.
	
	Classes, constructors, fields and methods all have 
	an access modifier.
*/