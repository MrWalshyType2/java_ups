package learning_java_ttt.oop.visitor_pattern;

public class Player implements Entity {

	int health = 100;
	int damage = 20;
	int attackModifier = 2;
	
	@Override
	public void acceptEntityVisitor(EntityVisitor visitor) {
		visitor.visitPlayer(this);
	}

	@Override
	public void visitPlayer(Player player) {
		System.out.println("Player is visiting a Player:");
		System.out.println(player);
	}

	@Override
	public void visitNpc(NPC npc) {
		System.out.println("Player is visiting an NPC");
	}

	@Override
	public String toString() {
		return "Player [health=" + health + ", damage=" + damage + "]";
	}

	
}
