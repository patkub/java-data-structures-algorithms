//Binary Tree Test - Patrick Kubiak - 4/13/2015
//Test the implementation of a node-based, linked binary search tree.

import net.datastructures.*;

public class BinaryTreeTest {

    private static net.datastructures.LinkedBinaryTree<Integer> bintree = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> bintree2 = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> binTreeLeft = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> binTreeRight = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> binTreeInsert = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> binTreeDelete = new LinkedBinaryTree<Integer>();
    private static net.datastructures.LinkedBinaryTree<Integer> binTreeDelete2 = new LinkedBinaryTree<Integer>();

    public static void main(String[] args) {
        Position<Integer> root, left, right;
        bintree.addRoot(3);
        bintree.addLeft(bintree.root(), 1);
        right = bintree.addRight(bintree.root(), 4);
        right = bintree.addRight(right, 6);
        Position<Integer> lastPos = bintree.addRight(right, 9);
        Position<Integer> foundPos;
        int size, depth, height, biggest, smallest;

        /**
         * Test Print Methods
         */
        System.out.println("===================================================");
        System.out.println("           WELCOME TO THE LINKEDBST TEST           ");
        System.out.println("ALL TREES ARE PRINTED USING IN-ORDER TRAVERSAL");
        System.out.println("UNLESS OTHERWISE STATED");
        System.out.println("===================================================");

        /**
         * Test Print Methods
         */
        System.out.println("\n==================================================");
        System.out.println("               TESTING PRINT METHODS               ");
        System.out.println("==================================================");

        System.out.print("Tree is printed inorder (left, root, right): ");      //test printInOrder() method
        bintree.printInOrder(bintree.root());

        System.out.print("\nTree is printed preorder (root, left, right): ");  //test printPreOrder() method
        bintree.printPreOrder(bintree.root());

        System.out.print("\nTree is printed postorder (left, right, root): ");  //test printPostOrder() method
        bintree.printPostOrder(bintree.root());

        size = bintree.size();                                          //test size() method
        root = bintree.root();                                              //test root() method
        System.out.println("\nSize of tree: " + size);
        System.out.println("Root: " + root.getElement());

        left = bintree.left(root);                                          //test left() method
        right = bintree.right(root);                                        //test right() method
        System.out.println("Element left of root: " + left.getElement());
        System.out.println("Element right of root: " + right.getElement());
        Position<Integer> rightParent = bintree.parent(lastPos);            //test parent(Position<E> p) method
        System.out.println("Parent element of last element: " + rightParent.getElement());

        bintree.set(root, 0);
        System.out.print("\nTree after setting root to 0: ");
        bintree.printInOrder(bintree.root());

        /**
         * Test Remove Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("               TESTING REMOVE METHOD               ");
        System.out.println("==================================================");
        System.out.println("\nTrying to remove root node: ");
        try {
            bintree.remove(root);
            System.out.println("\nIMPOSSIBLE: We removed a node that has two children.");
        } catch (Exception e) {
            System.out.println("ERROR: We cannot remove a node that has two children.");
            System.out.println(e);
        }

        bintree.remove(bintree.left(root));
        System.out.print("\nTree after removing element left of root: ");
        bintree.printInOrder(bintree.root());
        bintree.remove(lastPos);
        System.out.print("\nTree after removing last element added (9): ");
        bintree.printInOrder(bintree.root());

        /**
         * Test Attaching Trees
         */
        System.out.println("\n\n==================================================");
        System.out.println("               TESTING ATTACH METHOD               ");
        System.out.println("==================================================");
        root = binTreeLeft.addRoot(2);
        binTreeLeft.addLeft(root, 1);
        binTreeLeft.addRight(root, 4);
        //1, 2, 4

        root = binTreeRight.addRoot(8);
        binTreeRight.addLeft(root, 3);
        binTreeRight.addRight(root, 12);
        //3, 8, 12

        System.out.print("\nLeft Subtree: ");
        binTreeLeft.printInOrder(binTreeLeft.root());

        System.out.print("\nRight Subtree: ");
        binTreeRight.printInOrder(binTreeRight.root());
        System.out.println();

        bintree2.addRoot(5);
        bintree2.attach(bintree2.root(), binTreeLeft, binTreeRight);
        System.out.print("Attached to a tree with root node of 5: ");
        bintree2.printInOrder(bintree2.root());

        /**
         * Test Insertion Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("              TESTING INSERTION METHOD             ");
        System.out.println("==================================================");
        System.out.print("\nAfter inserting 7: ");
        binTreeInsert.insert(7);
        binTreeInsert.printInOrder(binTreeInsert.root());
        binTreeInsert.insert(8);
        System.out.print("\nAfter inserting 8: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        binTreeInsert.insert(9);
        System.out.print("\nAfter inserting 9: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        binTreeInsert.insert(1);
        System.out.print("\nAfter inserting 1: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        binTreeInsert.insert(43);
        System.out.print("\nAfter inserting 43: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        binTreeInsert.insert(5);
        System.out.print("\nAfter inserting 5: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        System.out.print("\nAttempting to insert 5 again...");
        boolean bResult = binTreeInsert.insert(5, binTreeInsert.root());

        if (bResult) {
            System.out.print("\nIMPOSSIBLE: We added an element that already exists in the tree!");
        } else {
            System.out.print("\nERROR: We cannot added an element that already exists in the tree!");
        }

        /**
         * Test Deletion Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("              TESTING DELETION METHOD              ");
        System.out.println("==================================================");

        //create tree
        binTreeDelete.insert(7);
        binTreeDelete.insert(6, binTreeDelete.root());
        binTreeDelete.insert(9, binTreeDelete.root());
        binTreeDelete.insert(13, binTreeDelete.root());
        binTreeDelete.insert(3, binTreeDelete.root());
        binTreeDelete.insert(8, binTreeDelete.root());
        binTreeDelete.insert(65, binTreeDelete.root());
        binTreeDelete.insert(10, binTreeDelete.root());
        System.out.print("\nTree: ");
        binTreeDelete.printInOrder(binTreeDelete.root());

        //delete from tree
        binTreeDelete.delete(7);
        System.out.print("\nTree after deleting 7: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(13);
        System.out.print("\nTree after deleting 13: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(8);
        System.out.print("\nTree after deleting 8: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(3);
        System.out.print("\nTree after deleting 3: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(65);
        System.out.print("\nTree after deleting 65: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(10);
        System.out.print("\nTree after deleting 10: ");
        binTreeDelete.printInOrder(binTreeDelete.root());
        binTreeDelete.delete(9);
        System.out.print("\nTree after deleting 9: ");
        binTreeDelete.printInOrder(binTreeDelete.root());

        //create tree
        binTreeDelete2.insert(9);
        binTreeDelete2.insert(5);
        binTreeDelete2.insert(11);
        binTreeDelete2.insert(1);
        binTreeDelete2.insert(7);
        System.out.print("\n\nTree: ");
        binTreeDelete2.printInOrder(binTreeDelete2.root());

        //delete from tree
        binTreeDelete2.delete(9);
        System.out.print("\nTree after deleting 9: ");
        binTreeDelete2.printInOrder(binTreeDelete2.root());

        binTreeDelete2.delete(5);
        System.out.print("\nTree after deleting 5: ");
        binTreeDelete2.printInOrder(binTreeDelete2.root());

        /**
         * Test Search Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("               TESTING SEARCH METHOD               ");
        System.out.println("==================================================");
        System.out.println("\nSearching for 7 in the following BST: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        foundPos = binTreeInsert.search(7, binTreeInsert.root());
        if (foundPos != null) {
            System.out.print("\n7 was found.");
        } else {
            System.out.print("\n7 was not found.");
        }

        System.out.println("\nSearching for 19 in the following BST: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        foundPos = binTreeInsert.search(19, binTreeInsert.root());
        if (foundPos != null) {
            System.out.print("\n19 was found.");
        } else {
            System.out.print("\n19 was not found.");
        }

        System.out.println("\nSearching for 5 in the following BST: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        foundPos = binTreeInsert.search(5, binTreeInsert.root());
        if (foundPos != null) {
            System.out.print("\n5 was found.");
        } else {
            System.out.print("\n5 was not found.");
        }

        System.out.println("\nSearching for 9 in the following BST: ");
        binTreeInsert.printInOrder(binTreeInsert.root());
        foundPos = binTreeInsert.search(9, binTreeInsert.root());
        if (foundPos != null) {
            System.out.print("\n9 was found.");
        } else {
            System.out.print("\n9 was not found.");
        }

        /**
         * Test Depth Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("               TESTING DEPTH METHOD                ");
        System.out.println("==================================================");
        binTreeInsert.printInOrder(binTreeInsert.root());
        depth = binTreeInsert.depth(binTreeInsert.root());
        System.out.println("\nDepth of root is: " + depth);
        depth = binTreeInsert.depth(foundPos);
        System.out.print("Depth of 9 is: " + depth);

        /**
         * Test Height Method
         */
        System.out.println("\n\n==================================================");
        System.out.println("               TESTING HEIGHT METHOD               ");
        System.out.println("==================================================");
        binTreeInsert.printInOrder(binTreeInsert.root());
        height = binTreeInsert.height(binTreeInsert.root());
        System.out.println("\nHeight of root is: " + height);
        height = binTreeInsert.height(foundPos);
        System.out.println("Height of 9 is: " + height);

        /**
         * Test Search Methods
         */
        System.out.println("\n==================================================");
        System.out.println("               TESTING SEARCH METHODS              ");
        System.out.println("==================================================");
        binTreeInsert.printInOrder(binTreeInsert.root());
        biggest = binTreeInsert.findBiggest(binTreeInsert.root()).getElement();
        System.out.println("\nBiggest value in tree is: " + biggest);
        smallest = binTreeInsert.findSmallest(binTreeInsert.root()).getElement();
        System.out.println("Smallest value in tree is: " + smallest);
    }
}
