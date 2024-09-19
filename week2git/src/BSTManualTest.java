public class BSTManualTest {

    public static void main(String[] args) {
        BST bst = new BST();

        // Test inserting elements
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        if (bst.contains(10) && bst.contains(5) && bst.contains(15)) {
            System.out.println("testInsert: PASSED");
        } else {
            System.out.println("testInsert: FAILED");
        }

        // Test searching for elements
        if (bst.contains(10) && !bst.contains(20)) {
            System.out.println("testContains: PASSED");
        } else {
            System.out.println("testContains: FAILED");
        }

        // Test deleting leaf nodes
        bst.delete(5);  // 5 is a leaf node
        if (!bst.contains(5)) {
            System.out.println("testDeleteLeafNode: PASSED");
        } else {
            System.out.println("testDeleteLeafNode: FAILED");
        }

        // Test deleting node with one child
        bst.insert(5);
        bst.insert(12);  // 15 will have only one child, 12
        bst.delete(15);
        if (!bst.contains(15) && bst.contains(12)) {
            System.out.println("testDeleteNodeWithOneChild: PASSED");
        } else {
            System.out.println("testDeleteNodeWithOneChild: FAILED");
        }

        // Test deleting node with two children
        bst.insert(17);
        bst.delete(15); // 15 has two children: 12 and 17
        if (!bst.contains(15) && bst.contains(12) && bst.contains(17)) {
            System.out.println("testDeleteNodeWithTwoChildren: PASSED");
        } else {
            System.out.println("testDeleteNodeWithTwoChildren: FAILED");
        }

        // Test deleting the root node
        bst.insert(15);
        bst.delete(10); // Deleting the root node
        if (!bst.contains(10) && bst.contains(5) && bst.contains(15)) {
            System.out.println("testDeleteRoot: PASSED");
        } else {
            System.out.println("testDeleteRoot: FAILED");
        }

        // Add more tests as needed...
    }
}
