package learning_java_ttt.arithmetic_parser_sol;

// abstract classes cannot be instantiated like the following: Expression e = new Expression();
public abstract class Expression {

	// Each Expression may accept a Visitor
	public abstract int accept(ExpressionVisitor visitor);
	
	// the Visitor interface
	public static interface ExpressionVisitor {
		int visit(BinaryExpression e);
		int visit(ValueExpression e);
	}

	// we can have classes and interfaces as members of a class
	// - we make them static so we can access them without an instance of 
	//   the class they are in: Expression e = new Expression.BinaryExpression(args...);
	public static class BinaryExpression extends Expression {
		Expression leftOperand, rightOperand;
		Token operator;
		
		public BinaryExpression(Expression leftOperand, Token operator, Expression rightOperand) {
			this.leftOperand = leftOperand;
			this.operator = operator;
			this.rightOperand = rightOperand;
		}

		@Override
		public int accept(ExpressionVisitor visitor) {
			return visitor.visit(this);
		}
	}
	
	public static class ValueExpression extends Expression {
		String type;
		String value;
		public ValueExpression(Token value) {
			this.type = value.type;
			this.value = value.value;
		}

		@Override
		public int accept(ExpressionVisitor visitor) {
			return visitor.visit(this);
		}
	}
}
