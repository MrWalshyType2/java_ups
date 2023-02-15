package learning_java_ttt.oop.polymorphism;

public class Player extends Entity {

	int health = 100;
	int damage = 20;
	
	public Player(int x, int y) {
		super(x, y);
	}

	public void attack(Entity e) {
		// A Player has a health, but an Entity might not
		// - this means we have lost type information by using a supertype
		// e.defendAgainst(this);
	}
	
	public void defendAgainst(Entity e) {
		// Same problem as attack
		// e.attack(this);
	}
}
