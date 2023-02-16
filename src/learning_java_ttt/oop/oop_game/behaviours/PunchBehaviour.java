package learning_java_ttt.oop.oop_game.behaviours;

import learning_java_ttt.oop.oop_game.entities.characters.GameCharacter;

public class PunchBehaviour implements AttackBehaviour {

	@Override
	public void attack(GameCharacter source, GameCharacter target, int modifier) {
		int actualDamage = source.getDamage() * modifier;
		target.setHealth(target.getHealth() - source.getDamage());
		
		System.out.println(source.getName() + " is throwing a punch at " + target.getName());
		System.out.println(":: Dealt " + actualDamage + " points of damage.");
	}

}
