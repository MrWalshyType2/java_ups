package learning_java_ttt.oop.oop_game.visitors;

import java.util.List;

import learning_java_ttt.oop.oop_game.entities.Entity;
import learning_java_ttt.oop.oop_game.entities.characters.NonPlayerCharacter;
import learning_java_ttt.oop.oop_game.entities.characters.Player;
import learning_java_ttt.oop.oop_game.entities.objects.GameObject;

public class MovementVisitor implements EntityVisitor {
	
	private String direction;
	private Entity[][] map;
	
	public MovementVisitor(String direction, Entity[][] map) {
		var validDirections = List.of("UP", "RIGHT", "DOWN", "LEFT");
		if (!validDirections.contains(direction)) throw new IllegalArgumentException("Invalid movement direction: " + direction);
		this.direction = direction;
		this.map = map;
	}

	@Override
	public void visitGameObject(GameObject obj) {

	}
	
	@Override
	public void visitNonPlayerCharacter(NonPlayerCharacter npc) {

	}

	@Override
	public void visitPlayer(Player player) {
		switch (direction) {
		case "UP":
			if (isAtTopEdge(player.y)) printCannotMoveFurther();
			else moveEntity(player, player.x, player.y - 1);
			break;
		case "RIGHT":
			if (isAtRightEdge(player.x)) printCannotMoveFurther();
			else moveEntity(player, player.x + 1, player.y);
			break;
		case "DOWN":
			if (isAtBottomEdge(player.y)) printCannotMoveFurther();
			else moveEntity(player, player.x, player.y + 1);
			break;
		case "LEFT":
			if (isAtLeftEdge(player.x)) printCannotMoveFurther();
			else moveEntity(player, player.x - 1, player.y);
			break;
		}
	}

	private void moveEntity(Entity e, int x, int y) {
		// collision detection here?
		if (map[y][x] != null) {
			map[y][x].accept(e);
			return;
		}
		
		// move the player if we didn't collide with another entity
		map[e.y][e.x] = null;
		map[y][x] = e;
		e.x = x;
		e.y = y;
	}

	private boolean isAtBottomEdge(int y) {
		return y == map.length - 1;
	}

	private boolean isAtRightEdge(int x) {
		return x == map[0].length - 1;
	}

	private boolean isAtLeftEdge(int x) {
		return x == 0;
	}

	private boolean isAtTopEdge(int y) {
		return y == 0;
	}
	
	private void printCannotMoveFurther() {
		System.out.println("Cannot move any further " + direction.toLowerCase());
	}

}
