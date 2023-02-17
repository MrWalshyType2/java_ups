package learning_java_ttt.oop.visitor_pattern;

public class App {
	
	public static void main(String[] args) {
		Entity p1 = new Player();
		Entity p2 = new Player();
		Entity n1 = new NPC();
		System.out.println(p1);
		System.out.println(n1);
		
//		n1.acceptEntityVisitor(p1);
		
//		// p1 attack n1
		p1.acceptEntityVisitor(n1);
//		
//		// The NPC damaged the player
		System.out.println(p1);
		System.out.println(n1);
	}

}
