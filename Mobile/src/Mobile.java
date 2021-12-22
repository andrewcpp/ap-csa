// You write this.
//
// If you make Structure a class, Mobile must extend it.
// If you make Structure an interface, Mobile must implement it.

public class Mobile extends Structure {	
	// This constructor is mandatory by problem specification
	// You have to figure out how to handle it
	
	public Mobile(Branch left, Branch right) {
		// You write this
		super(left, right);
	}
}

/*
public class Mobile implements Structure {	
	// This constructor is mandatory by problem specification
	// You have to figure out how to handle it
	
	Branch left;
	Branch right;

	public Mobile(Branch left, Branch right) {
		// You write this
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isBalanced() {
		return left.torque() == right.torque() && left.getStructure().isBalanced() && right.getStructure().isBalanced();
	}

	@Override
	public double getWeight() {
		return left.getStructure().getWeight() + right.getStructure().getWeight();
	}
}
*/

/*
public class Mobile {	
	// This constructor is mandatory by problem specification
	// You have to figure out how to handle it

	public Mobile(Branch left, Branch right) {
		// You write this
	}
}
*/