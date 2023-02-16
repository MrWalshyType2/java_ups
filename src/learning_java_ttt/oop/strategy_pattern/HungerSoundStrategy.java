package learning_java_ttt.oop.strategy_pattern;

public class HungerSoundStrategy implements SoundStrategy {

	@Override
	public void perform() {
		System.out.println("*grumbling*");
	}

}
