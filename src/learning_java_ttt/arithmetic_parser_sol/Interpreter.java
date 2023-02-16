package learning_java_ttt.arithmetic_parser_sol;

import learning_java_ttt.arithmetic_parser_sol.Expression.BinaryExpression;
import learning_java_ttt.arithmetic_parser_sol.Expression.ValueExpression;

public class Interpreter implements Expression.ExpressionVisitor {
	
	public int interpret(Expression e) {
		return e.accept(this);
	}

	@Override
	public int visit(BinaryExpression e) {
		switch (e.operator.value) {
		case "+":
			return interpret(e.leftOperand) + interpret(e.rightOperand);
		case "-":
			return interpret(e.leftOperand) - interpret(e.rightOperand);
		case "*":
			return interpret(e.leftOperand) * interpret(e.rightOperand);
		case "/":
			return interpret(e.leftOperand) / interpret(e.rightOperand);
		default:
			throw new RuntimeException("Unexpected operator: " + e.operator.value);
		}
	}

	@Override
	public int visit(ValueExpression e) {
		if (e.type == "INT") return Integer.valueOf(e.value);
		throw new RuntimeException("Unexpected value");
	}

}
