public class BSTMultiSet extends MultiSet {

    // a multiset always starts empty, so we can directly instantiate our private attribute
    // here; no need to explicitly write a new constructor.
    private final BST bst = new BST();

    @Override
    void add(Integer item) {
        bst.insert(item);
    }

    @Override
    void remove(Integer item) {
        bst.delete(item);
    }

    @Override
    boolean contains(Integer item) {
        return bst.contains(item);
    }

    @Override
    boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    int count(Integer item) {
        return bst.count(item);
    }

    @Override
    int size() {
        return bst.getLength();
    }

    //
    //            Hint: autocomplete will help as you look for the right bst methods to call,
    //                  but make sure to double-check that you are calling the correct methods!
    //
    //.           Note: if the red squiggly line isn't there, make sure src is marked as
    //                  the sources root; if it still isn't there, you will just need to manually
    //                  copy over the method headers from MultiSet.java to be implemented.

}
