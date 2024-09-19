/**
 * A minimal implementation of a binary search tree storing Integers.
 * See the Python version for additional documentation; we haven't copied over any docstrings here.
 * You can also see
 * <a href="https://www.teach.cs.toronto.edu/~csc148h/notes/binary-search-trees/bst_implementation.html">CSC148 Course Notes Section 8.5 BST Implementation and Search</a>
 * if you want a refresher on BSTs, but it is not required to complete this assignment.
 */
public class BST {
    private Integer root;

    private BST left;
    private BST right;

    public BST(Integer root) {
        if (root != null) { // check to ensure we don't accidentally try to store null at the root!
            this.root = root;
            left = new BST();
            right = new BST();
        }
        // Note: each of the attributes will default to null if root == null
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        this(null);
    }
    // check if the BST is empty
    public boolean isEmpty() {
        return this.root == null;
    }
    // check if this integer is in the BST
    public boolean contains(Integer item) {
        // provided code; do not change
        if (this.isEmpty()) {
            return false;
        } else if (item.equals(this.root)) { // see comment below
            // In general, we need to use .equals and not == to properly compare values.
            // Since we are storing integers, one _could_ implement this class such that
            // using == would be fine instead, but that has not been done here since we
            // are using Integer objects.
            return true;
        } else if (item.compareTo(this.root) < 0) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }
    // insert an item into the BST
    public void insert(Integer item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST();  // Ensure subtrees are initialized
            this.right = new BST(); // Ensure subtrees are initialized
        } else if (item < this.root) {
            if (this.left == null) {  // Safety check (shouldn't be necessary with correct initialization)
                this.left = new BST();
            }
            this.left.insert(item);
        } else {
            if (this.right == null) {  // Safety check (shouldn't be necessary with correct initialization)
                this.right = new BST();
            }
            this.right.insert(item);
        }
    }

    // Delete an item from the BST
    public void delete(int item) {
        if (this.isEmpty()) {
            return; // Tree is empty, nothing to delete
        }
        // If the item is less than root, delete from the left subtree
        if (item < this.root) {
            this.left.delete(item);
        }
        // If the item is greater than root, delete from the right subtree
        else if (item > this.root) {
            this.right.delete(item);
        }
        // If item is equal to the root, handle deletion
        else {
            this.deleteRoot();
        }
    }
    // delete the root of the BST
    private void deleteRoot() {
        if (this.left.isEmpty() && this.right.isEmpty()) {
            // Case 1: Node is a leaf node
            this.root = null;
        } else if (this.left.isEmpty()) {
            // Case 2: Only right child
            this.root = this.right.root;
            this.left = this.right.left;
            this.right = this.right.right;
        } else if (this.right.isEmpty()) {
            // Case 3: Only left child
            this.root = this.left.root;
            this.right = this.left.right;
            this.left = this.left.left;
        } else {
            // Case 4: Two children, replace root with max of left subtree
            this.root = this.left.extractMax();
        }
    }

    // extract the maximum value in this BST
    private Integer extractMax() {
        if (this.right.isEmpty()) {
            Integer max = this.root;
            this.root = this.left.root;
            this.right = this.left.right;
            this.left = this.left.left;
            return max;
        }
        return this.right.extractMax();
    }
    // find the height of this BST
    public int height() {
        if (this.isEmpty()) {
            return -1;  // Convention: height of an empty tree is -1
        } else {
            // Assuming `left` and `right` are either null or point to BST instances
            int leftHeight = (this.left != null) ? this.left.height() : -1;
            int rightHeight = (this.right != null) ? this.right.height() : -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    // count the number of times item appears in the BST
    public int count(Integer item) {
        if (this.isEmpty()) {
            return 0;
        }

        int count = 0;

        // If the current root is equal to the item, increment the count
        if (this.root.equals(item)) {
            count = 1;
        }

        // Recursively count occurrences in the left and right subtrees
        return count + this.left.count(item) + this.right.count(item);
    }

    // gets the length of the BST
    public int getLength() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return 1 + this.left.getLength() + this.right.getLength();
        }
    }

    public static void main(String[] args) {
        // Important: do not add any code to a "psvm" main method in this class,
        //            as it may prevent your code from running on MarkUs.
        //            If you want to test this code, you can either create a test file
        //            similar to the provided BSTSelfTest.java or create a main method
        //            in a local .java file which you don't push to MarkUs.
        //            In particular, if you include any code on MarkUs which calls:
        //            new Integer(x); // for any x
        //            then your code won't be able to be compiled and run, with an error
        //            similar to:
        //            "warning: [removal] Integer(int) in Integer has been deprecated and marked for removal"
    }

}


