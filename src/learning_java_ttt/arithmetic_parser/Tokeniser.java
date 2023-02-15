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
		addToken("EOF", null);
		
		// Think about how we would remove the null elements from the 
		// array of tokens
		// 1. Find the index of the last non-null element (tokenPosition - 1)
		// 2. Copy the contents of tokens into a new array,
		//    with a size of the found index + 1, upto the found index
		Token[] results = new Token[tokenPosition];
		for (int i = 0; i < results.length; i++) {
			results[i] = tokens[i];
		}
		return results;
	}
	
	public void scanToken() {
		// Convert this method to use a switch statement instead of if-elseif-else
		char c = nextChar();
		// "husiohf s8yh8sf7"
		switch (c) {
		case '"':
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
