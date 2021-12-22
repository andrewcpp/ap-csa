import java.util.Arrays;

public class IntroComparable {

	public static void main(String[] args) {
		Animal[] animals = { new Horse(2000, "Hulk"),
                new Wombat(),
                new Wombat(1600, "Bessie"),
                new Cow(1700, "Moohead"),
                new Wombat(),
                new Wildebeest(1900, "Big Time Jones") };


		printArray(animals);
		for (Animal a : animals) {
			if (a.getClass() == new Wombat().getClass()) System.out.println("Wombats don't gain mass * acceleration when they eat!");
			else a.eat(200);
		}
		Arrays.sort(animals);
		printArray(animals);
	}
	
	public static void printArray(Animal[] a) {
		for (Animal x : a) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}

}