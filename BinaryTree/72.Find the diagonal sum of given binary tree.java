package BinaryTree;

import java.util.HashMap;
import java.util.Map;
 
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class diagona
{
    public static void diagonalSum(Node root, int diagonal, Map<Integer, Integer> map)
    {
        if (root == null) {
            return;
        }
 
        map.put(diagonal, map.getOrDefault(diagonal, 0) + root.data);
 
        diagonalSum(root.left, diagonal + 1, map);
 
        diagonalSum(root.right, diagonal, map);
    }
 
    public static void diagonalSum(Node root)
    {
        Map<Integer, Integer> map = new HashMap<>();
 
        diagonalSum(root, 0, map);
        System.out.println(map.values());
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        diagonalSum(root);
    }
}