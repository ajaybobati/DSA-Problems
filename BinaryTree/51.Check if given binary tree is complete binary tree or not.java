package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class isComp
{
    public static boolean isComplete(Node root)
    {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node front;
        boolean flag = false;
        while (!queue.isEmpty())
        {
            front = queue.poll();
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
            if (front.left == null && front.right != null) {
                return false;
            }

            if (front.left != null) {
                queue.add(front.left);
            }
            else {
                flag = true;
            }

            if (front.right != null) {
                queue.add(front.right);
            }
            else {
                flag = true;
            }
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
 
        if (isComplete(root)) {
            System.out.println("Complete binary tree");
        }
        else {
            System.out.println("Not a complete binary tree");
        }
    }
}
