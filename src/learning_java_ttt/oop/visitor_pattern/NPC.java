package learning_java_ttt.oop.visitor_pattern;

public class NPC implements Entity {
	
	int health = 100;
	int damage = 50;

	@Override
	public void acceptEntityVisitor(EntityVisitor visitor) {
		visitor.visitNpc(this);
	}
	
	@Override
	public void visitPlayer(Player player) {
		System.out.println("NPC is attacking a Player");
		player.health -= damage - player.damage;
		System.out.println("Player lost " + (damage - player.damage) + " points of health");
		
		System.out.println("NPC suffered recoil damage of " + (player.damage / 2) + " points");
		health -= player.damage / 2;		
	}

	@Override
	public void visitNpc(NPC npc) {
		System.out.println("NPC is visiting an NPC");
	}

	@Override
	public String toString() {
		return "NPC [health=" + health + ", damage=" + damage + "]";
	}

}
