package learning_java_ttt.oop.oop_game;

import java.util.List;

import learning_java_ttt.oop.oop_game.behaviours.PunchBehaviour;
import learning_java_ttt.oop.oop_game.entities.Entity;
import learning_java_ttt.oop.oop_game.entities.characters.NonPlayerCharacter;
import learning_java_ttt.oop.oop_game.entities.characters.Player;

public class Game {

	public static void main(String[] args) {
		// setup the player and entities
		Player player1 = new Player("Bob");
		NonPlayerCharacter troll = new NonPlayerCharacter("Troll", 130, 20, true);
		troll.y = 1;
		player1.registerAttack("punch", new PunchBehaviour());
		troll.registerAttack("punch", new PunchBehaviour());
		
		// register with game engine and start
		List<Entity> entities = List.of(troll);
		GameEngine engine = new GameEngine(5, 20, entities, player1);
		engine.start();
	}
}
