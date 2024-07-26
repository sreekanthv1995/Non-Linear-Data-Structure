package workout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {
    Node root;
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            left = right = null;
        }
    }
    public BST(int value){
        root = new Node(value);
    }

    public void insert(int value){
        recursiveInsert(root,value);
    }

    public Node recursiveInsert(Node root,int value){
        if (root == null){
            return new Node(value);
        }
        if (value > root.value){
            root.right = recursiveInsert(root.right,value);
        }else {
            root.left = recursiveInsert(root.left,value);
        }
        return root;
    }

    public void inOrderTraversal(Node root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(Node root){
        if (root == null) return;
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }

    public void delete(int value){
        recursiveDelete(root,value);
    }
    public Node recursiveDelete(Node root,int value){
        if (root.value < value){
           root.right =  recursiveDelete(root.right,value);
        }else if (root.value > value){
           root.left = recursiveDelete(root.left,value);
        }else {
            if (root.left == null && root.right == null){
                return null;
            } else if (root.left == null) {
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {
                root.value = findMinValue(root.right);
                root.right = recursiveDelete(root.right,root.value);
            }
        }
        return root;
    }

    public int findMinValue(Node root){
        int minValue = root.value;
        while (root.left != null){
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public int heightOfBST(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = -1;

        while (true){

            int nodeCountAtLevel = queue.size();
            if (nodeCountAtLevel == 0) {
                return level;
            }
            while (nodeCountAtLevel > 0){
                Node element = queue.poll();

                if (element.left != null){
                    queue.add(element.left);
                }
                if (element.right != null){
                    queue.add(element.right);
                }
                nodeCountAtLevel--;
            }
            level++;
        }
    }

    public boolean validateBst(Node root){
        List<Integer> inOrderList = new ArrayList<>();
        addElementInArrayList(inOrderList,root);
        boolean isBst = true;
        int prev = inOrderList.get(0);

        for (int i = 1; i < inOrderList.size(); i++){
            if (inOrderList.get(i) <= prev){
                isBst = false;
            }
            prev = inOrderList.get(i);
        }
        return isBst;
    }

    private void addElementInArrayList(List<Integer> list,Node root){
        if (root == null) return;
        addElementInArrayList(list,root.left);
        list.add(root.value);
        addElementInArrayList(list,root.right);
    }

    public Node recursiveSearch(Node root,int value){
        if (root == null ||root.value == value){
            return root;
        }
        if (value < root.value)
            return recursiveSearch(root.left,value);
        return recursiveSearch(root.right,value);
    }
}
