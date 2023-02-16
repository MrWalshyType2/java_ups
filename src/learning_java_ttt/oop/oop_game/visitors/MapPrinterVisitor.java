package learning_java_ttt.oop.oop_game.visitors;

import learning_java_ttt.oop.oop_game.entities.characters.NonPlayerCharacter;
import learning_java_ttt.oop.oop_game.entities.characters.Player;
import learning_java_ttt.oop.oop_game.entities.objects.GameObject;

/**
 * Prints a character representing the given entity.
 * @author Morgan Walsh
 *
 */
public class MapPrinterVisitor implements EntityVisitor {

	@Override
	public void visitGameObject(GameObject obj) {
		System.out.print("G");
	}

	@Override
	public void visitPlayer(Player player) {
		System.out.print("P");
	}

	@Override
	public void visitNonPlayerCharacter(NonPlayerCharacter npc) {
		System.out.print("N");
	}
	
}