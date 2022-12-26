package proj5;

/**
 * The Binary Search Tree ADT models a tree where all the values to the left of a given node
 * are less than that node and all the values to the right are equal to or greater than
 * the given node
 * 
 * @author Chris Fernandes, Kristina Striegnitz, edited by Nick DeBaise
 * @version Fall 2022
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSTNode<T> root;

	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

    
    /**
	 * inserts a new value into this BST
	 * @param newValue value to insert
	 */
	public void insert(T newValue) {
		root = insert(root,newValue);
	}

	/**
	 * inserts value into tree rooted at subroot
	 * 
	 * @param subroot  subroot of tree to insert into
	 * @param value  the value to insert
	 * @return   root of the subtree I've just finished inserting into
	 */
	private BSTNode<T> insert(BSTNode<T> subroot, T value) {
		if (subroot==null){
			return new BSTNode<T>(value);
		}
		else if (value.compareTo(subroot.key) > 0){
			subroot.rlink = insert(subroot.rlink,value);
			return subroot;
		}
		else {
			subroot.llink = insert(subroot.llink, value);
			return subroot;
		}
	}
	
	/**
	 * deletes value from tree.  If value not there, do nothing.
	 * @param value  value to delete
	 */
	public void delete(T value) {
		root = delete(root, value);
	}

	/**
	 * deletes value from tree rooted at subroot
	 * @param subroot  root of tree to be deleted from
	 * @param value  element to delete
	 * @return pointer to tree rooted at subroot that has value removed from it
	 */
	private BSTNode<T> delete(BSTNode<T> subroot, T value) {
		if(subroot == null) {
			return null;
		} else {
			if(value.compareTo(subroot.key) < 0) {
				subroot.llink = delete(subroot.llink, value);
			} else if(value.compareTo(subroot.key) > 0) {
				subroot.rlink = delete(subroot.rlink, value);
			} else {
				if(subroot.isLeaf()) {
					return null;
				} else if(subroot.hasRightChildOnly()) {
					return subroot.rlink;
				} else if(subroot.hasLeftChildOnly()) {
					return subroot.llink;
				} else {
					BSTNode<T> replacement = findLargestInLeft(subroot);
					subroot.key = replacement.key;
					subroot.llink = delete(subroot.llink, subroot.key);
				}
			}
		}

		return subroot;
	}

	/**
	 * Given a BSTNode, find the largest value in the left subtree
	 * @param root the root of the tree to search for
	 * @return the largest node in the left subtree of root
	 */
	private BSTNode<T> findLargestInLeft(BSTNode<T> root) {
		if(root == null) {
			return null;
		}

		root = root.llink;
		while(root.rlink != null) {
			root = root.rlink;
		}

		return root;
	}

    /**
     * checks whether the target value is in the tree
     * @return true or false to indicate whether the target value is in the tree
     */
    public boolean search(T target) {
		return getNode(root, target) != null;
    }


	/**
	 * Search for and return the node at the given target value
	 *
	 * @param target the target value to search for
	 * @return null if not found or the node corresponding to the first instance of target
	 */
	public T getNode(T target) {
		return getNode(root, target);
	}

	/**
	 * Recursively find the target node
	 *
	 * @param subroot the root of the tree to start the search from
	 * @param target the target value to search for
	 * @return null if not found or the node corresponding to the first instance of target
	 */
	private T getNode(BSTNode<T> subroot, T target) {
		if(subroot == null) {
			return null;
		} else {
			if(subroot.key.equals(target)) {
				return subroot.key;
			} else {
				if(subroot.key.compareTo(target) > 0) {
					//go left
					return getNode(subroot.llink, target);
				} else {
					//go right
					return getNode(subroot.rlink, target);
				}
			}
		}
	}


	/**
	 * returns tree as printable string
	 * @return tree in string format with form (left subtree) value (right subtree)
	 */
	public String toString(){
		return toString(root);
	}

	/**
	 * recursive helper method for toString()
	 *
	 * @param N root of subtree to make into a string
	 * @return string version of tree rooted at N
	 */
	private String toString(BSTNode<T> N){
		String ret = "";
		if (N != null){
			ret += "(";
			ret += toString(N.llink);
			ret += "  " + N + "  ";
			ret += toString(N.rlink);
			ret += ")";
		}
		return ret;
	}

	/**
	 * Return the binary search tree as an array of String values
	 * @return the bst in a string array
	 */
	public String[] toArray() {
		LinkedList<T> list = new LinkedList<>();

		fillLinkedListInOrder(root, list);

		return list.toArray();
	}

	/**
	 * Fill the given LinkedList in order (least to greatest)
	 * @param root the root of the BST
	 * @param list the given list to fill
	 */
	private void fillLinkedListInOrder(BSTNode<T> root, LinkedList<T> list) {
		if (root.llink != null) {
			fillLinkedListInOrder(root.llink, list);
		}

		list.add(root.key);

		if (root.rlink != null) {
			fillLinkedListInOrder(root.rlink, list);
		}

	}

}