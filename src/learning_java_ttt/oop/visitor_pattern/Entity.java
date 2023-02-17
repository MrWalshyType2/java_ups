package learning_java_ttt.oop.visitor_pattern;

// Interfaces can inherit from other interfaces,
// confusingly using the extends keyword instead of implements
public interface Entity extends EntityVisitor {

	void acceptEntityVisitor(EntityVisitor visitor);
	
}