package learning_java_ttt.oop.oop_game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import learning_java_ttt.oop.oop_game.behaviours.AttackBehaviour;
import learning_java_ttt.oop.oop_game.entities.Entity;
import learning_java_ttt.oop.oop_game.entities.characters.GameCharacter;
import learning_java_ttt.oop.oop_game.visitors.MapPrinterVisitor;
import learning_java_ttt.oop.oop_game.visitors.MovementVisitor;

public class GameEngine {
	private Entity[][] map;
	private Entity player;
	
	public GameEngine(int height, int width, List<Entity> entities, Entity player) {
		map = new Entity[height][width];
		entities.forEach(entity -> map[entity.y][entity.x] = entity);
		this.player = player;
		this.map[player.y][player.x] = player;
	}

	public void start() {		
		do {
			printMap();
			printPlayerLocation();
			System.out.println();
			
			String command = getInput();
			if (command.toUpperCase().equals("Q")) break;
			executeCommand(command.toUpperCase());
			System.out.println();
		} while (true);
		System.out.println("Thanks for playing");
	}

	private void executeCommand(String command) {
		try {
			if (command.trim().length() == 0) throw new IllegalArgumentException("Expected a command but got empty input");
			String[] commandFragments = command.split(" ");
			String[] args = Arrays.copyOfRange(commandFragments, 1, commandFragments.length);
			executeCommand(commandFragments[0], args);
		} catch (Exception e) {
			System.out.println(":: " + e.getMessage());
		}
	}

	private void executeCommand(String command, String[] args) {
		switch (command) {
		case "MOVE":
			if (args.length == 0) throw new IllegalArgumentException("Expected a direction after 'move'.");
			player.accept(new MovementVisitor(args[0], map));
			break;
		default:
			System.out.println("Unrecognised command: " + command);
			break;
		}
	}

	private void printPlayerLocation() {
		System.out.println("===> Your location");
		System.out.println("x: " + player.x);
		System.out.println("y: " + player.y);
	}

	public void printMap() {
		System.out.println("===> World map");
		
		// print out the map
		MapPrinterVisitor visitor = new MapPrinterVisitor();
		for (int row = 0; row < map.length; row++) {
			System.out.print("| ");
			for (int column = 0; column < map[row].length; column++) {
				Entity current = map[row][column];
				if (current == null) System.out.print(" ");
				else current.accept(visitor);
			}
			System.out.println(" |");
		}
	}
	
	public static String getInput() {
		return InputUtil.nextLine("> ");
	}
	
	public static String getInput(String prompt) {
		return InputUtil.nextLine(prompt);
	}
	
	public static void fight(GameCharacter source, GameCharacter target) {
		while (true) {
			// your attack
			printFightingMoves(source);
			AttackBehaviour playerMove = getPlayerAttackMove(source);
			playerMove.attack(source, target, 1);
			
			if (target.getHealth() <= 0) {
				System.out.println("You won!");
				break;
			}
			
			// npcs attack
		}
	}

	private static AttackBehaviour getPlayerAttackMove(GameCharacter source) {
		Set<String> moves = source.getAttackNames();
		String input;
		while (true) {
			input = getInput("ATTACK> ");
			if (!moves.contains(input.toUpperCase())) System.out.println("You don't know how to " + input);
			else break;
		}
		return source.getAttackMove(input.toUpperCase());
	}

	private static void printFightingMoves(GameCharacter source) {
		Set<String> moves = source.getAttackNames();
		System.out.println("MOVES:");
		moves.forEach(move -> {
			System.out.println("- " + move.toLowerCase());
		});
	}
}

class InputUtil {
	final private static Scanner SC = new Scanner(System.in);
	
	public static String nextLine() {
		return SC.nextLine();
	}
	
	public static String nextLine(String prompt) {
		System.out.print(prompt);
		return SC.nextLine();
	}
}
