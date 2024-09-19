import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTTest {

    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();  // Initialize the BST before each test
    }

    // Test inserting elements
    @Test
    public void testInsert() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    // Test searching for elements
    @Test
    public void testContains() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.contains(10));
        assertFalse(bst.contains(20));  // Element not in tree
    }

    // Test deleting leaf nodes
    @Test
    public void testDeleteLeafNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(5);  // 5 is a leaf node
        assertFalse(bst.contains(5));
    }

    // Test deleting node with one child
    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);  // 15 will have only one child, 12

        bst.delete(15);
        assertFalse(bst.contains(15));
        assertTrue(bst.contains(12));  // Ensure 12 is still in the tree
    }

    // Test deleting node with two children
    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(17);

        bst.delete(15);  // 15 has two children: 12 and 17
        assertFalse(bst.contains(15));
        assertTrue(bst.contains(12));
        assertTrue(bst.contains(17));
    }

    // Test deleting the root node
    @Test
    public void testDeleteRoot() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(10);  // Deleting the root node
        assertFalse(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    // Test deleting a non-existing element
    @Test
    public void testDeleteNonExistingElement() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(20);  // 20 is not in the tree
        assertTrue(bst.contains(10));  // Tree should remain unchanged
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    // Test tree is empty after all elements are deleted
    @Test
    public void testIsEmptyAfterAllDeleted() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(10);
        bst.delete(5);
        bst.delete(15);

        assertTrue(bst.isEmpty());
    }

    // Test operations on an empty tree
    @Test
    public void testOperationsOnEmptyTree() {
        assertTrue(bst.isEmpty());
        assertFalse(bst.contains(10));
        bst.delete(10);  // Should handle gracefully
        assertTrue(bst.isEmpty());
    }

    // Test inserting duplicate elements (if allowed)
    @Test
    public void testInsertDuplicates() {
        bst.insert(10);
        bst.insert(10);  // Insert a duplicate
        bst.insert(10);

        assertEquals(3, bst.count(10));  // Assuming duplicates are counted
        bst.delete(10);  // Delete one occurrence
        assertEquals(2, bst.count(10));
    }

    // Test the height of the tree
    @Test
    public void testHeight() {
        assertEquals(-1, bst.height());  // Empty tree height

        bst.insert(10);
        assertEquals(0, bst.height());  // Single node height

        bst.insert(5);
        bst.insert(15);
        assertEquals(1, bst.height());  // Height should now be 1

        bst.insert(2);
        assertEquals(2, bst.height());  // Height should increase
    }

    // Test the size of the tree
    @Test
    public void testSize() {
        assertEquals(0, bst.getLength());

        bst.insert(10);
        assertEquals(1, bst.getLength());

        bst.insert(5);
        bst.insert(15);
        assertEquals(3, bst.getLength());

        bst.delete(10);
        assertEquals(2, bst.getLength());
    }

    // Performance testing (optional, for large datasets)
    @Test
    public void testLargeDataset() {
        for (int i = 1; i <= 100000; i++) {
            bst.insert(i);
        }

        assertEquals(100000, bst.getLength());
        assertTrue(bst.contains(50000));

        bst.delete(50000);
        assertFalse(bst.contains(50000));
        assertEquals(99999, bst.getLength());
    }
}
