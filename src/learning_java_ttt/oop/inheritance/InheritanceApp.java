package learning_java_ttt.oop.inheritance;

public class InheritanceApp {

	public static void main(String[] args) {
		Player shrek = new Player(0, 0, "Shrek");
		Player fiona = new Player(0, 1, "Fiona");
		
		System.out.println(shrek.name);
		System.out.println(fiona.name);
		
		// How do we have unique behaviours on each class
		// without creating new classes which inherit from 
		// Player?
	}
}
