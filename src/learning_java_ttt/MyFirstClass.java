package learning_java_ttt;
//First line: Optional package statement to identify what package the class belongs to

//Imports follow the package statement, but come before the class declaration

//Class declaration:
/* ACCESS-MODIFIER class ClassName {
  MEMBER_VARIABLES;
  
  MEMBER_METHODS;
}

Variables and methods inside a class are:
- Class members if static
- Instance members otherwise

Instance members are only accessible if you have an object of that class
to access them on.
*/
public class MyFirstClass {

	// These are instance members called fields,
	// they represent data about an object created from this class.
	// AccessModifier DataType identifier;
	// ||
	// AccessModifier DataType identifier = value;
	int i; // default to 0
	int j = 1;
	int sum;
	
	// Reference variables default to 'null'
	
	// Instance methods are like instance members, they represent the 
	// behaviours of a unique object.
	/*
	METHOD HEADER
	OPTIONAL(AccessModifier) OPTIONAL(StaticModifier) ReturnType methodName(DataType varName) {
		METHOD SIGNATURE = methodName(DataType varName)
		METHOD BODY INSIDE THE BRACKETS
	}
	*/
	void doSomething(String name) {
		// void means return nothing
		System.out.println(name + String.valueOf(j));
	}
	
	int add(int num1, int num2) {
		this.sum = num1 + num2;
		return num1 + num2;
	}
}
