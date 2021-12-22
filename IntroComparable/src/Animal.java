
public class Animal implements Comparable<Animal> {
	private int weight;
	private String name;
	
	public Animal(int weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void eat(int weight) {
		this.weight += weight;
	}

	@Override
	public int compareTo(Animal a) {
		return weight - a.getWeight();
	}
	
	@Override
	public String toString() {
		return name + ":" + weight;
	}
}
