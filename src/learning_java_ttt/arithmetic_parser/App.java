package learning_java_ttt.arithmetic_parser;

public class App {

	public static void main(String[] args) {
		String src = "3 + 3 - 50 * 100 / 30";
		// Expect back from the tokeniser
		/*
		 * [
		 *   Token(type=INT, value=3),
		 *   Token(type=OPERATOR, value=+),
		 *   Token(type=INT, value=3)
		 * ]
		 */
		Tokeniser tokeniser = new Tokeniser(src);
		Token[] tokens = tokeniser.tokenise();
		
//		System.out.println(tokeniser.src);
//		System.out.println(tokeniser.tokens);
//		System.out.println(tokeniser.currentPosition);
//		System.out.println(tokeniser.isAtEnd());
		
		// change to use an enhanced for loop
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
	}

}
