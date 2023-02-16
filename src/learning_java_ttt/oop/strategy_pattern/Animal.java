package learning_java_ttt.oop.strategy_pattern;

public class Animal {

	private String type;
	private SoundStrategy sound;
	
	public Animal(String type, SoundStrategy sound) {
		super();
		this.type = type;
		this.sound = sound;
	}

	public void makeNoise() {
		System.out.println(type  + " is making a noise:");
		sound.perform();
		System.out.println();
	}

	public void makeNoise(SoundStrategy differentSound) {
		System.out.println(type  + " is making a noise:");
		differentSound.perform();
		System.out.println();
	}
	
}
