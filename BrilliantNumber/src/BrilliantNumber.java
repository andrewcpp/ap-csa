import java.util.ArrayList;

public class BrilliantNumber {
	
	static Primes p = new Primes(50);

	public static void main(String[] args) {
		Brilliant b = new Brilliant(20);
		System.out.println(b.brilliant);
	}
	
	static boolean isPrime(int n) {
		
		if (n == 2)
			return true;
		
		if (n == 1 || n % 2 == 0)
			return false;
		
		for (int i = 3; i <= Math.sqrt(n); i += 2) 
			if (n % i == 0) 
				return false;
		
		return true;
		
	}
	
	static boolean isBrilliant(int n) {
		
		for (int i = p.primes.size() - 1; i >= 0; i--) {
			if (n % p.primes.get(i) == 0 && 
				digitCount(p.primes.get(i), n / p.primes.get(i)) && 
				isPrime(n / p.primes.get(i))) return true;
		}
		
		return false;
		
	}
	
	static boolean digitCount(int x, int y) {
		
		return (x + "").length() == (y + "").length();
		
	}

}

class Primes {
	
	ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public Primes(int n) {
		
		for (int i = 2; primes.size() < n; i++) 
			if (BrilliantNumber.isPrime(i)) 
				primes.add(0, i);
		
	}
	
	boolean isPrime(int n) {
		
		if (n <= primes.get(0)) {
			// O(N) time complexity
			if (primes.contains(n)) 
				return true;
			else 
				return false;
		} else {
			// Polynomial time, approximately O(N^1.5)
			for (int i = primes.get(0) + 1; i <= n; i++) 
				if (BrilliantNumber.isPrime(i)) 
					primes.add(0, i);
			if (primes.get(0) == n) return true;
			else return false;
		}
		
	}
	
}

class Brilliant {
	
	ArrayList<Integer> brilliant = new ArrayList<Integer>();
	
	public Brilliant(int n) {
		initializeArray(n);
	}
	
	void initializeArray(int n) {
		for (int i = 4; brilliant.size() < n; i++)
			if (BrilliantNumber.isBrilliant(i))
				brilliant.add(i);
	}
	
}