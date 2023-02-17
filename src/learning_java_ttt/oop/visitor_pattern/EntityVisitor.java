package learning_java_ttt.oop.visitor_pattern;

public interface EntityVisitor {

	void visitPlayer(Player player);
	void visitNpc(NPC npc);
}
