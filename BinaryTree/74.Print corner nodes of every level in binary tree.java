package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class pri
{
    public static void print(Node root)
    {
        if (root == null) {
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
 
        q.add(root);
 
        while (!q.isEmpty())
        {
            int size = q.size();
            int n = size;
 
            while (n-- > 0)
            {
                Node node = q.poll();
 
                if (n == size - 1 || n == 0) {
                    System.out.print(node.data + " ");
                }
 
                if (node.left != null) {
                    q.add(node.left);
                }
 
                if (node.right != null) {
                    q.add(node.right);
                }
            }
 
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(10);
 
        print(root);
    }
}

