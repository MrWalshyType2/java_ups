package learning_java_ttt.oop.oop_game.visitors;

import learning_java_ttt.oop.oop_game.entities.characters.NonPlayerCharacter;
import learning_java_ttt.oop.oop_game.entities.characters.Player;
import learning_java_ttt.oop.oop_game.entities.objects.GameObject;

public interface EntityVisitor {

	void visitGameObject(GameObject obj);
	void visitPlayer(Player player);
	void visitNonPlayerCharacter(NonPlayerCharacter npc);
}
