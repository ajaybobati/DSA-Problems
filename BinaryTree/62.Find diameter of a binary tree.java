package BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;
 
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class getDiame
{
    public static int getDiameter(Node root, AtomicInteger diameter)
    {
        if (root == null) {
            return 0;
        }
        int left_height = getDiameter(root.left, diameter);
        int right_height = getDiameter(root.right, diameter);
 
        int max_diameter = left_height + right_height + 1;
 
        diameter.set(Math.max(diameter.get(), max_diameter));
 
        return Math.max(left_height, right_height) + 1;
    }
 
    public static int getDiameter(Node root)
    {
        AtomicInteger diameter = new AtomicInteger(0);
        getDiameter(root, diameter);
 
        return diameter.get();
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        System.out.print("The diameter of the tree is " + getDiameter(root));
    }
}


