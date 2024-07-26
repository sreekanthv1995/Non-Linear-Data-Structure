package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(50);

        bst.insert(20);
        bst.insert(70);
        bst.insert(10);
        bst.insert(25);
        bst.insert(60);
        bst.insert(90);
        bst.insert(80);
        bst.insert(75);

        bst.inorderTraversal(bst.root);
        bst.delete(bst.root,70);
        System.out.println();
        bst.inorderTraversal(bst.root);

    }
}
