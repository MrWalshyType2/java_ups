package learning_java_ttt;

import java.util.Arrays;
import java.util.Iterator;

public class Iteration {

	public static void main(String[] args) {
		int counter = 1;

		while (counter <= 10) {
		    System.out.println(counter);
		    // increment counter by one before the next iteration of the loop
		    counter++; // counter = counter + 1
//		    counter += 2; // counter = counter + 2
		}
		
		// do while statements always execute at least once
		// - a while statement may never execute as it checks the condition first instead
		counter = 0;
		do {
			System.out.println("I ran");
			counter++;
		} while (counter < 2);
		
		// for loops
		// - we use it when we know how many times we want to iterate
		for (int i = 1; i <= 10; i++) {
		    System.out.println(i);
		}
		
		// iterating over an array
		int[] nums = {1,2,3,4,5};
		
		// if we want to modify the the array, use a normal for statement
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * 2;
			if (i == nums.length - 1) System.out.print(nums[i]);
			else System.out.print(nums[i] + ",");
		}
		
		System.out.println();
		
		// if we only want to read the items in the array, use an enhanced for loop
		for (int num : nums) {
			System.out.print(num + ",");
		}

	}

}
