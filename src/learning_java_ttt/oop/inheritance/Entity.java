package learning_java_ttt.oop.inheritance;

public class Entity {

	private int x,y = 0;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp(int amount) {
		this.y = y + amount;
	}
	
	public void moveRight(int amount) {
		this.x = x + amount;
	}
	
	public void moveDown(int amount) {
		this.y = y - amount;
	}
	
	public void moveLeft(int amount) {
		this.x = x - amount;
	}
}
