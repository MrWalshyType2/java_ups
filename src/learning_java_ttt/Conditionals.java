package learning_java_ttt;

public class Conditionals {

	public static void main(String[] args) {
		// if-else
		double temp = 36.5; // degrees c 
		double feverTemp = 38; // degrees c 
		double minSafeTemp = 36.3; // degrees c
		String output = ""; 

		if (temp > feverTemp) { 
		    output = "Patient too hot! Start emergency cooling procedures"; 
		} else { 
		    output = "Patient is fine"; 
		} 
		System.out.println(output);
		
		// If we don't specify a block after the if statements conditional, or the else keyword, the statement to run
		// will be that which immediately follows the keyword or condition.
		
		// The dangling else, which if does each else belong to
		if (temp > 30) if (temp > 40) System.out.println("Temp is greater than 40");
		else System.out.println("something 1"); // line 24
		else System.out.println("something 2"); // line 23
		
		// switch statements
		int month = 1; 

		switch (month) { 
		    case 1: System.out.println("January"); 
		    		break;
		    case 2: System.out.println("February"); 
		            break;
		    case 3: System.out.println("March");
		            break; // etc… 
		    default: System.out.println("Incorrect input");
		             break; 
		} 
	}

}
