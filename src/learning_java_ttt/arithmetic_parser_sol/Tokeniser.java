package learning_java_ttt.arithmetic_parser_sol;

import java.util.ArrayList;
import java.util.List;

public class Tokeniser {

	private int currentPosition;
	private String src;
	private List<Token> tokens;

	/**
	 * Creates a new <code>Tokeniser</code> object which accepts an input string of text 
	 * to be tokenised. This will initialise the tokeniser in preparation for tokenisation.
	 * @param src
	 */
	public Tokeniser(String src) {
		this.src = src;
		tokens = new ArrayList<>();
		currentPosition = 0;
	}
	
	/**
	 * Tokenises the input string supplied at object instantiation. Returns a flat stream of <code>Token</code>
	 * objects, with an end of file token added to the end of the list.
	 * @return
	 */
	public List<Token> tokenise() {
		while (!isAtEnd()) {
			scanToken();
		}
		addToken("EOF", null);

		return tokens;
	}
	
	/**
	 * Scans the next token, adding it to the internally tracked list of tokens. Throws an exception (error) 
	 * if the next character in the input string is not the start of a valid token type.
	 */
	public void scanToken() {
		char c = nextChar();
		switch (c) {
		case '"':
			// only added for demonstration purposes
			addToken("STRING", string());
			break;
		case '+':
			addToken("PLUS", String.valueOf(c));
			break;
		case '-':
			addToken("MINUS", String.valueOf(c));
			break;
		case '*':
			addToken("STAR", String.valueOf(c));
			break;
		case '/':
			addToken("SLASH", String.valueOf(c));
			break;
		case '\n':
		case ' ':
		case '\r':
		case '\t':
			break;
		default:
			if (isNumeric(c)) addToken("int", number(c));
			else throw new RuntimeException("Got an unexpected character");
		}
	}
	
	public void addToken(String type, String value) {
		tokens.add(new Token(type, value));
	}
	
	public boolean isNumeric(char c) {
		if (c == '\0') return false;
		return c >= '0' && c <= '9';
	}
	
	// returns the next char, but doesn't advance currentPosition
	public Character peek() {
		if (this.isAtEnd()) return '\0';
		else return src.charAt(currentPosition);
	}
	
	public char nextChar() {
		return src.charAt(currentPosition++);
	}

	public boolean isAtEnd() {
		return currentPosition >= src.length();
	}
	
	public String number(char c) {
		String value = String.valueOf(c);
		
		while (isNumeric(peek())) {
			value += String.valueOf(nextChar());
		}
		
		return value;
	}
	
	public String string() {
		// husiohf s8yh8sf7"
		String output = "";
		
		while (peek() != '"') {
			output += nextChar();
			// escape characters
//			if (peek() == '\\' && peek(1) == 'n') output += "\n";
//			else if (peek() == '\\') {
//				nextChar();
//				output += nextChar();
//			}
		}
		nextChar();
		return output;
	}
}
