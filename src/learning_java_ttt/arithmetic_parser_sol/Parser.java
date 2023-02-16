package learning_java_ttt.arithmetic_parser_sol;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private int current;
	private List<Token> tokens;
	
	public Parser(List<Token> tokens) {
		this.tokens = tokens;
		this.current = 0;
	}
	
	public Expression parse() {
		return expression();
	}

	private Expression expression() {
		return term();
	}

	/**
	 * A term represents some terminal expression of the parser. A term may be a number or a series of 
	 * additions, subtractions, multiplications and divisions built into an expression tree representing the correct 
	 * order of operations and associativity.
	 * @return
	 */
	private Expression term() {
		Expression leftOperand = factor();
		
		while (match("PLUS") || match("MINUS")) {
			Token operator = previous();
			Expression rightOperand = factor();
			leftOperand = new Expression.BinaryExpression(leftOperand, operator, rightOperand);
		}
		return leftOperand;
	}

	/**
	 * A factor represents
	 * @return
	 */
	private Expression factor() {
		Expression leftOperand = primary();
		
		while (match("STAR") || match("SLASH")) {
			Token operator = previous();
			Expression rightOperand = primary();
			leftOperand = new Expression.BinaryExpression(leftOperand, operator, rightOperand);
		}
		return leftOperand;
	}
	
	private Expression primary() {
		if (match("INT")) return new Expression.ValueExpression(previous());
		throw new RuntimeException("Expected an expression.");
	}

	private Token previous() {
		if (current == 0) return null;
		return tokens.get(current - 1);
	}
	
	private Token advance() {
		if (!isAtEnd()) current++;
		return previous();
	}
	
	private Token peek() {
		return tokens.get(current);
	}

	private boolean match(String type) {
		if (check(type)) {
			advance();
			return true;
		}
		return false;
	}
	
	private boolean check(String type) {
		if (isAtEnd()) return false;
		return peek().type == type;
	}	

	private boolean isAtEnd() {
		return tokens.get(current).type.equals("EOF");
	}
}
