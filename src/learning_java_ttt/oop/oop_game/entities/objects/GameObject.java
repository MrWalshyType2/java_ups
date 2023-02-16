package learning_java_ttt.oop.oop_game.entities.objects;

import learning_java_ttt.oop.oop_game.entities.Entity;
import learning_java_ttt.oop.oop_game.entities.characters.NonPlayerCharacter;
import learning_java_ttt.oop.oop_game.entities.characters.Player;
import learning_java_ttt.oop.oop_game.visitors.EntityVisitor;

public class GameObject extends Entity {

	public GameObject(long id) {
		super(id);
	}

	@Override
	public void visitGameObject(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitNonPlayerCharacter(NonPlayerCharacter npc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(EntityVisitor visitor) {
		visitor.visitGameObject(this);
	}


}
