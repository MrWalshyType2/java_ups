package learning_java_ttt;

public class Arrays {

	public static void main(String[] args) {
		int[] numbers = new int[10]; // [0,0,0, etc...]
		String[] names = new String[5]; // [null, null, null, etc...]

		int numbersLength = numbers.length; // 10
		int namesLength = names.length; // 5
		
		System.out.println(numbersLength);
		System.out.println(namesLength);
		
		// long form, size is inferred from input data, size = 5
		int[] newNumbers = new int[] { 1,2,3,4,5 };

		// short form, size = 2
		String[] newNames = { "Fred", "Sarah" };
		
		System.out.println(newNames[1]);
		
		String[][] multiDimensionalArray = {
				{ "row1, col1", "row1, col2" },
				{ "row2, col1", "row2, col2" }
		};
		System.out.println(multiDimensionalArray[1][1]);
	}

}
