package learning_java_ttt.arithmetic_parser_sol;

public abstract class Expression {

	public abstract int accept(ExpressionVisitor visitor);
	
	public static interface ExpressionVisitor {
		int visit(BinaryExpression e);
		int visit(ValueExpression e);
	}

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
