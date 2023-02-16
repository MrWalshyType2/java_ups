package learning_java_ttt.oop.oop_game.entities.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import learning_java_ttt.oop.oop_game.behaviours.AttackBehaviour;
import learning_java_ttt.oop.oop_game.entities.Entity;
import learning_java_ttt.oop.oop_game.entities.objects.GameObject;

public abstract class GameCharacter extends Entity {
	
	private String name;
	private int health;
	private int damage;
	private List<GameObject> inventory;
	private Map<String, AttackBehaviour> attacks;

	public GameCharacter(String name) {
		this(name, 100, 5);
	}
	
	public GameCharacter(String name, int health, int damage) {
		this(name, health, damage, new HashMap<>());
	}
	
	public GameCharacter(String name, int health, int damage, Map<String, AttackBehaviour> attacks) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.inventory = new ArrayList<>();
		this.attacks = attacks;
	}
	
	public void addToInventory(GameObject obj) {
		this.inventory.add(obj);
	}
	
	public void registerAttack(String name, AttackBehaviour behaviour) {
		attacks.put(name.toUpperCase(), behaviour);
	}
	
	public Set<String> getAttackNames() {
		return attacks.keySet();
	}
	
	public AttackBehaviour getAttackMove(String name) {
		return attacks.get(name);
	}
	
	public List<GameObject> getInventory() {
		return inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "GameCharacter [name=" + name + ", health=" + health + ", damage=" + damage + ", inventory=" + inventory
				+ ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(damage, health, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCharacter other = (GameCharacter) obj;
		return damage == other.damage && health == other.health && Objects.equals(name, other.name);
	}

}
