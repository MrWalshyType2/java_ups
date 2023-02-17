package learning_java_ttt.oop.oop_game.behaviours;

import learning_java_ttt.oop.oop_game.entities.characters.GameCharacter;

public class KickBehaviour implements AttackBehaviour {

	@Override
	public void attack(GameCharacter source, GameCharacter target, int modifier) {
		int actualDamage = source.getDamage() * modifier + 5;
		target.setHealth(target.getHealth() - actualDamage);
		
		System.out.println(source.getName() + " is kicking " + target.getName());
		System.out.println(":: Dealt " + actualDamage + " points of damage.");
	}

}
