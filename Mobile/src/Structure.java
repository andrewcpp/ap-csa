// Is structure going to be a class or an interface?  Either way,
// each structure must have a getWeight() method of type double and
// an isBalanced() method of type boolean.

public class Structure {
	
	private double weight;
	private Branch left;
	private Branch right;
	
	public double getWeight() {
		return weight;
	}
	
	public boolean isBalanced() {
		return left.torque() == right.torque();
	}
	
	public Structure(double weight) {
		this.weight = weight;
	}
	
	public Structure(Branch left, Branch right) {
		this.left = left;
		this.right = right;
	}
}

/*
public interface Structure {
	public double getWeight();
	public boolean isBalanced();
}
*/