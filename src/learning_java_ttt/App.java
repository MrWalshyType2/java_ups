package learning_java_ttt;
// First line: Optional package statement to identify what package the class belongs to

// Imports follow the package statement, but come before the class declaration
import java.util.Random;
// convention for package names is lowercase snake_case

// Class declaration:
//   ACCESS-MODIFIER class ClassName {}
public class App {

	public static void main(String[] args) {
		// We don't need to import as in the same package
		// declaring a variable of type MyFirstClass
		MyFirstClass myObj1;
		
		// use a constructor to create an instance of a class
		// - if a class doesn't have a constructor, it is given a default
		// - the constructor is like a method, except it returns an instance of a class
		myObj1 = new MyFirstClass();
		myObj1.j = 20;
		
		MyFirstClass myObj2 = new MyFirstClass();
		myObj2.j = 500;
		
		System.out.println(myObj1.j);
		System.out.println(myObj2.j);
		
		// call instance methods on a class
		myObj1.doSomething("Fred");
		myObj2.doSomething("Tony");
		
		int mySum = myObj1.add(20, 30);
		System.out.println(mySum);
		
		Car myCar = new Car();
		myCar.mileage = 70000;
		System.out.println(myCar.mileage);
		myCar.drive(100);
		System.out.println(myCar.mileage);
	}
	
	// Methods belong to a class
	// - if static, they can be called without creating an Object of the class
//	public static void main(String[] args) {
//		int a = 10;
//		int b = 20;
//		int c = a + b;
//		
//		System.out.println(c);
//		System.out.println("Hello World");
//		
//		int i = 30;
//		i = ++i + i++;
//		// ++i = PREFIX_INCREMENT expression (unary operator)
//		// i++ = POSTFIX_INCREMENT expression (unary operator)
//		// +   = INFIX_SUM expression (binary operator)
//	}

}