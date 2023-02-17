package learning_java_ttt.oop.strategy_pattern;

// When inheriting from an interface, we use the `implements` keyword
// instead of `extends`
// - we can inherit from multiple interfaces
// - we can only 
public class HungerSoundStrategy implements SoundStrategy {

	@Override
	public void perform() {
		System.out.println("*grumbling*");
	}

}
