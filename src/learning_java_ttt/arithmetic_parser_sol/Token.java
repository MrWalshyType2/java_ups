package learning_java_ttt.arithmetic_parser_sol;

public class Token {

	String type;
	String value;
	
	public Token(String type, String value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", value=" + value + "]";
	}

}
