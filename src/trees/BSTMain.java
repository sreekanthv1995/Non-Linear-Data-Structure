package trees;

public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);

        System.out.println(bst.insert(27));
        System.out.println(bst.root.value);
        System.out.println(bst.root.left.right.value);
        System.out.println(bst.contains(1));
    }
}
