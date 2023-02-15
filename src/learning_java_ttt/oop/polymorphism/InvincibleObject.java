package learning_java_ttt.oop.polymorphism;

public class InvincibleObject extends Entity {

	public InvincibleObject(int x, int y) {
		super(x, y);
	}

	public void defendAgainst(Entity e) {
		System.out.println("INVINCIBLE OBJECTS CANNOT BE DAMAGED");
	}
}
