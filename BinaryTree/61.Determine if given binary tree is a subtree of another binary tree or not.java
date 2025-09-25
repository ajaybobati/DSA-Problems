package BinaryTree;

import java.util.ArrayList;
import java.util.List;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
 
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
 
class inorde
{
    public static void inorder(Node node, List<Integer> list)
    {
        if (node == null) {
            return;
        }
 
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }
 
    public static void postorder(Node node, List<Integer> list)
    {
        if (node == null) {
            return;
        }
 
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.data);
    }
    public static boolean isSublist(List<Integer> x, List<Integer> y) {
 
        for (int i = 0; i < x.size() - y.size() + 1; i++)
        {
            if (x.subList(i, i + y.size()).equals(y)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkSubtree(Node tree, Node subtree)
    {
        if (tree == subtree) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);
        if (!isSublist(first, second)) {
            return false;
        }
        first.clear();
        second.clear();
        postorder(tree, first);
        postorder(subtree, second);
        if (!isSublist(first, second)) {
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}


