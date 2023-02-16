package learning_java_ttt.oop.oop_game.entities.characters;

import learning_java_ttt.oop.oop_game.entities.objects.GameObject;
import learning_java_ttt.oop.oop_game.visitors.EntityVisitor;

public class NonPlayerCharacter extends GameCharacter {
	
	private boolean isHostile;

	public NonPlayerCharacter(String name) {
		super(name);
	}
	
	public NonPlayerCharacter(String name, int health, int damage) {
		this(name, health, damage, false);
	}
	
	public NonPlayerCharacter(String name, int health, int damage, boolean isHostile) {
		super(name, health, damage);
		this.isHostile = isHostile;
	}

	@Override
	public void visitGameObject(GameObject obj) {
		System.out.println(getName() + " is visiting game object: " + obj);
		addToInventory(obj);
	}

	@Override
	public void visitPlayer(Player player) {
		System.out.println(getName() + " is visiting player: " + player);
	}

	@Override
	public void visitNonPlayerCharacter(NonPlayerCharacter npc) {
		System.out.println(getName() + " is visiting npc: " + npc);
	}

	@Override
	public void accept(EntityVisitor visitor) {
		visitor.visitNonPlayerCharacter(this);
	}

	public boolean isHostile() {
		return isHostile;
	}

	public void setHostile(boolean isHostile) {
		this.isHostile = isHostile;
	}

	@Override
	public String toString() {
		return "NonPlayerCharacter [isHostile=" + isHostile + ", getName()="
				+ getName() + ", getHealth()=" + getHealth() + ", getDamage()=" + getDamage() + ", getId()=" + getId()
				+ "]";
	}

}
