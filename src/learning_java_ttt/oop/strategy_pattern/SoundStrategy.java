package learning_java_ttt.oop.strategy_pattern;

public interface SoundStrategy {

	static SoundStrategy of(String sound) {
		return new SoundStrategy() {

			@Override
			public void perform() {
				System.out.println(sound);
			}
		
		};
	}

	void perform();
}
