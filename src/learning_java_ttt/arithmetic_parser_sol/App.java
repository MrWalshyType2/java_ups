package learning_java_ttt.arithmetic_parser_sol;

import java.util.List;

public class App {

	public static void main(String[] args) {
		String src = "3 + 3 - 50 * 100 / 30";
		// Expect back from the tokeniser
		/*
		 * [
		 *   Token(type=INT, value=3),
		 *   Token(type=OPERATOR, value=+),
		 *   Token(type=INT, value=3),
		 *   etc...
		 * ]
		 */
		Tokeniser tokeniser = new Tokeniser(src);
		List<Token> tokens = tokeniser.tokenise();
		
//		for (Token token : tokens) System.out.println(token);
		
		Parser parser = new Parser(tokens);
		Expression expression = parser.parse();
		
		Interpreter interpreter = new Interpreter();
		int result = interpreter.interpret(expression);
		System.out.println(result);
	}

}
