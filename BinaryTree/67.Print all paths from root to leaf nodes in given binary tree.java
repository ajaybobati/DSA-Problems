package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
 
// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class isLe
{
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    public static void printRootToLeafPaths(Node node, Deque<Integer> path)
    {
        if (node == null) {
            return;
        }
 
        path.addLast(node.data);
 
        if (isLeaf(node)) {
            System.out.println(path);
        }
        printRootToLeafPaths(node.left, path);
        printRootToLeafPaths(node.right, path);
        path.removeLast();
    }
    public static void printRootToLeafPaths(Node node)
    {
        Deque<Integer> path = new ArrayDeque<>();
        printRootToLeafPaths(node, path);
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
        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);
        printRootToLeafPaths(root);
    }
}