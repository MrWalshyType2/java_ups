package learning_java_ttt.arithmetic_parser;

public class Tokeniser {

	int tokenPosition;
	int currentPosition;
	String src;
	Token[] tokens;
	
	// constructor that accepts a src string
	// Constructor:
	// AccessModifier ClassName() {}
	public Tokeniser(String src) {
		this.src = src;
		// new Token[capacity];
		tokens = new Token[src.length()];
		// the arrays values default to null for reference types
		currentPosition = 0;
		tokenPosition = 0;
	}
	
	public Token[] tokenise() {
		while (!isAtEnd()) {
			scanToken();
		}
		
		return tokens;
	}
	
	public void scanToken() {
		char c = nextChar();
		
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			addToken("operator", String.valueOf(c));
		} 
		else if (isNumeric(c)) addToken("int", number(c));
		else if (c == '\n' || c == ' ') return; // end the method early
		else {
			// no matching token, throw an error
			throw new RuntimeException("Got an unexpected character");
		}
	}
	
	public void addToken(String type, String value) {
		tokens[tokenPosition++] = new Token(type, value);
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
	
	public String number(char c) {
		String value = String.valueOf(c);
		
		while (isNumeric(peek())) {
			value += String.valueOf(nextChar());
		}
		
		return value;
	}
	
	public char nextChar() {
		return src.charAt(currentPosition++);
	}

	public boolean isAtEnd() {
		return currentPosition >= src.length();
	}
}
