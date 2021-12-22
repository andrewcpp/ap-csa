// You write this.
//
// If you make Structure a class, Weight must extend it.
// If you make Structure an interface, Weight must implement it.

public class Weight extends Structure {
    // This constructor is now mandatory as we can make weights
    // real objects instead of treating them solely as numbers.
    // 
    // You have to figure out how to handle it

    public Weight(double weight) {
		super(weight);
    }
    
    
}

/*
public class Weight implements Structure {
    // This constructor is now mandatory as we can make weights
    // real objects instead of treating them solely as numbers.
    // 
    // You have to figure out how to handle it
	
	private double weight;

    public Weight(double weight) {
		this.weight = weight;
    }

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public boolean isBalanced() {
		return true;
	}
}
*/

/*

public class Weight {
    // This constructor is now mandatory as we can make weights
    // real objects instead of treating them solely as numbers.
    // 
    // You have to figure out how to handle it

    public Weight(double weight) {
		
    }
}
*/