package learning_java_ttt.oop.strategy_pattern;

public class SleepingSoundStrategy implements SoundStrategy {

	@Override
	public void perform() {
		System.out.println("*zzzz...*");
	}

}
