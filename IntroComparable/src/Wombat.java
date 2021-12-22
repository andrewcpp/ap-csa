
public class Wombat extends Animal {
	
	public Wombat() {
		this(1800, "Anonymous Wombat");
	}
	
	public Wombat(int weight, String name) {
		super(weight, name);
	}
	
	public void eat() {
		System.out.println("I hate food.");
	}
	
}
