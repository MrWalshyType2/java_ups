package learning_java_ttt.oop.strategy_pattern;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Animal sheep = new Animal("sheep", SoundStrategy.of("bahhh"));
		Animal cow = new Animal("cow", SoundStrategy.of("mooo"));
		
		// using there default sound strategies
		sheep.makeNoise();
		cow.makeNoise();
		
		// we can also supply a different sound strategy (a change of runtime behaviour)
		sheep.makeNoise(new HungerSoundStrategy());
		cow.makeNoise(new SleepingSoundStrategy());
		
		System.out.println(sheep);
		
		
		SoundStrategy someStrat = SoundStrategy.of("do something");
		someStrat.perform();
	}

}
