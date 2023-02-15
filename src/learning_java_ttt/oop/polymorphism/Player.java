package learning_java_ttt.oop.polymorphism;

public class Player extends Entity {

	int health = 100;
	int damage = 20;
	private String name;
	
	public Player() {
		this(0, 0);
	}
	
	// Ad-hoc polymorphism
	// - a compile-time polymorphism where we can have multiple
	//   methods or constructors with the same name but different 
	//   parameter types
	// This is constructor overloading
	// - it has a different signature (name and parameters)
	public Player(int x, int y) {
		super(x, y);
	}
	
	public Player(int x, int y, String name) {
		this(x, y);
		this.name = name;
	}
	
	/* Dynamic method dispatch (another type of polymorphism)
	 * - if a subtype of a class has overridden a method, 
	 *   it will call the overridden version instead of the 
	 *   supertypes version of the method
	 * - runtime version
	 */
	@Override // this is an annotation
	// it signifies the method following is overridden
	// - its not been mandatory for a long time
	public void moveUp(int amount) {
		System.out.println("MOVING UP " + amount + " positions");
		super.moveUp(amount);
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
