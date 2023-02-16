package learning_java_ttt.oop.oop_game.entities;

import learning_java_ttt.oop.oop_game.visitors.EntityVisitor;

public abstract class Entity implements EntityVisitor {
	
	private static long id_counter = 1;
	private long id;
	public int x,y;
	
	public Entity() {
		this.id = id_counter++;
		this.x = 0;
		this.y = 0;
	}
	
	public Entity(long id) {
		this.id = id;
		this.x = 0;
		this.y = 0;
	}
	
	public long getId() {
		return this.id;
	}
	
	public abstract void accept(EntityVisitor visitor);
}
