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

	// A SoundStrategy has a single method call
	// - it's a contract saying any class which implements this interface (inherits from it)
	//   MUST implement this method.
	// - we don't specify public because interface methods are public by default
	// - it is also abstract by default, abstract meaning it has no implementation
	abstract public void perform();
}