package learning_java_ttt.oop.oop_game.behaviours;

import learning_java_ttt.oop.oop_game.entities.characters.GameCharacter;

public interface AttackBehaviour {

	void attack(GameCharacter source, GameCharacter target, int modifier);
}
