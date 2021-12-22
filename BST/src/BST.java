
public class BST<T extends Comparable<T>> {
	private T datum;
	private BST<T> left; 
	private BST<T> right;  
	
	public BST(T datum) {
		this.datum = datum;
		left = null;
		right = null;
	}

	public T getDatum() {
		return datum;  // returns the datum of a node
	}
	public BST<T> getLeft() {
		return left;   // returns the left subtree
	}
	public BST<T> getRight() {
		return right;  // returns the right subtree
	}
	
	public void setLeft(BST<T> tree) {
		left = tree;
	}

	public void setRight(BST<T> tree) {
		right = tree;
	}
	
	public void printTree(BST<T> tree) {
		if (tree.getLeft() != null) printTree(tree.getLeft());
		System.out.print(tree.getDatum() + " ");
		if (tree.getRight() != null) printTree(tree.getRight());
	}
	
	public void insert(T datum) {
		if (datum.compareTo(this.getDatum()) < 0) {
			if (getLeft() == null) {
				setLeft(new BST<T>(datum));
			} else {
				getLeft().insert(datum);
			}
		} else if (datum.compareTo(this.getDatum()) > 0) {
			if (getRight() == null) {
				setRight(new BST<T>(datum));
			} else {
				getRight().insert(datum);
			}
		}
	}
	
	public int depth() {
		int depth = 0;
		if (this == null) 
			return 0;
		else {
			if (getLeft() != null && getRight() == null) depth += getLeft().depth() + 1;
			else if (getLeft() == null && getRight() != null) depth += getRight().depth() + 1;
			else if (getLeft() != null && getRight() != null) {
				depth += Math.max(getLeft().depth() + 1, getRight().depth() + 1);
			}
		}
		return depth;
	}
	
	/*
	public void delete(T datum) {
		if (datum.compareTo(this.getDatum()) < 0) {
			if (getLeft() == null) {
				
			} else if (getLeft().getDatum() == datum) {
				setLeft(null);
			}
		} else if (datum.compareTo(this.getDatum()) > 0) {
			if (getRight() == null) {
				setRight(new BST<T>(datum));
			} else {
				getRight().insert(datum);
			}
		}
	}
	*/
	
	
	public String toString() {
		String s = "" + datum + ", ";
		if (left != null)
			s = s + left.toString();
		if (right != null)
			s = s + right.toString();
		return s;
	}
}