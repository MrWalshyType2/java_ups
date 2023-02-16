package learning_java_ttt.oop.oop_game.entities.characters;

import learning_java_ttt.oop.oop_game.GameEngine;
import learning_java_ttt.oop.oop_game.entities.objects.GameObject;
import learning_java_ttt.oop.oop_game.visitors.EntityVisitor;

public class Player extends GameCharacter {

	public Player(String name) {
		super(name);
	}
	
	public Player(String name, int health, int damage) {
		super(name, health, damage);
	}

	@Override
	public void visitGameObject(GameObject obj) {
		System.out.println(getName() + " is visiting game object: " + obj);
	}

	@Override
	public void visitPlayer(Player player) {
		System.out.println(getName() + " is visiting player: " + player);
	}

	@Override
	public void visitNonPlayerCharacter(NonPlayerCharacter npc) {
		if (npc.isHostile() && npc.getHealth() > 0) {
			System.out.println("You have encountered a " + npc.getName());
			System.out.println("Unfortunately it is angry, prepare to fight!");
			GameEngine.fight(this, npc);
			return;
		}
		System.out.println("The NPC " + npc.getName() + " does not want to move.");
	}

	@Override
	public void accept(EntityVisitor visitor) {
		visitor.visitPlayer(this);
	}

}
