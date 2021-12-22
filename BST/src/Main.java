
public class Main {

	public static void main(String[] args) {
		BST<Integer> bsti = new BST<Integer>(12);
		bsti.insert(7);
		bsti.insert(19);
		bsti.insert(16);
		bsti.insert(5);
		bsti.insert(13);
		// If printed in order, the below line should produce 7, 12, 19
		System.out.println(bsti);
		bsti.printTree(bsti);
		System.out.println();
		System.out.println(bsti.depth());
		int n = 10000;
		Randp rp = new Randp(n);
		BST<Integer> avg = new BST<Integer>(rp.nextInt());
		for (int i = 0; i < n-1; i++) {
			avg.insert(rp.nextInt());
		}
		System.out.println(avg.depth());
		
		// Questions
		// Worst case order of growth: O(n)
		// Best case: you jump into the BST and the desired number is the first number O(1)
		// Average case: O(log n)
		// Insertion complexity: O(log n)
		// print tree complexity: O(2^n)?
		
	}

}