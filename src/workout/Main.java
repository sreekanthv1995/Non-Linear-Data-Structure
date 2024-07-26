package workout;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST(40);
        bst.insert(10);
        bst.insert(5);
        bst.insert(70);
        bst.insert(65);
        bst.insert(30);
        bst.insert(80);

//        bst.inOrderTraversal(bst.root);
//        System.out.println();
        System.out.println(bst.heightOfBST(bst.root)+ " is the Height");
        System.out.println(bst.validateBst(bst.root));

        BST.Node node = bst.recursiveSearch(bst.root,830);
       if (node != null){
           System.out.println("found element "+node.value);
       }else {
           System.out.println("Element Not found");
       }
    }
}
