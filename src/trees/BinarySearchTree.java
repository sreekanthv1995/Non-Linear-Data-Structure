package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
    public BinarySearchTree(int value){
        root = new Node(value);
    }
//    public BinarySearchTree(){
//        root = null;
//    }

    public void insertNonRecursive(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return;
        }
        Node temp = root;
        while (true){
            if (newNode.value == temp.value) return;
            if (newNode.value < temp.value){
                if (temp.left == null){
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null){
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        Node temp = root;
        while (temp != null){
            if (value < temp.value){
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            }else {
                return true;
            }
        }
        return false;
    }
    public Node search(Node root, int value){
        if (root == null || root.value == value){
            return root;
        }
        if (root.value < value)
            return search(root.right,value);
        return search(root.left,value);
    }



    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0){
            currentNode = queue.remove();
            result.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return result;
    }
    public void insert(int value){
         recursiveInsert(root,value);
    }
    public Node recursiveInsert(Node root, int value){
        if (root == null){
            return new Node(value);
        }
        if (root.value > value){
            root.left = recursiveInsert(root.left,value);
        }else{
            root.right = recursiveInsert(root.right,value);
        }
        return root;
    }

    public Node delete(Node root,int value){
        if (root.value < value){
            root.right = delete(root.right,value);
        } else if (root.value > value) {
            root.left = delete(root.left,value);
        }else {
            if (root.left == null && root.right == null){
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }else {
//                Node minValue = findMin(root.right);
                root.value = min(root.right);
                root.right = delete(root.right,root.value);
            }
        }
        return root;
    }

    public int min(Node root){
        int minValue = root.value;
        while (root.left != null){
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
    private Node findMin(Node root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public void inorderTraversal(Node root){
        if (root == null)return;
        inorderTraversal(root.left);
        System.out.print(root.value+" ");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal(Node root){
        if (root == null)return;
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if (root == null)return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }


    boolean checkBST(Node root){
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        boolean isBST = true;
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) <= prev){
                isBST = false;
            }
            prev = list.get(i);
        }
        return isBST;
    }

    void helper(Node node,List<Integer> inOrderList){
        if (node == null) return;
        helper(node.left,inOrderList);
        inOrderList.add(node.value);
        helper(node.right,inOrderList);
    }

    int height(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int numOfLevels = -1;
        while (true){
            int nodeCountAtLevel = queue.size();
            if (nodeCountAtLevel == 0){
                return numOfLevels;
            }
            while (nodeCountAtLevel > 0){
                Node element = queue.poll();
                if (element.left != null)
                    queue.add(element.left);
                if (element.right != null)
                    queue.add(element.right);
                nodeCountAtLevel--;
            }
            numOfLevels++;
        }
    }
}
