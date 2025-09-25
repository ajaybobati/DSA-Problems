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
 
class findRightNo
{
    public static Node findRightNode(Node root, Node node)
    {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node front;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size-- > 0)
            {
                front = queue.poll();
 
                if (front == node)
                {
                    if (size == 0) {
                        return null;
                    }
 
                    return queue.peek();
                }
 
                if (front.left != null) {
                    queue.add(front.left);
                }
 
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
 
        return null;
    }
 
    public static void main(String[] args) {
      
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        Node right = findRightNode(root, root.left.right);
        if (right != null) {
            System.out.print("Right node is " + right.data);
        }
        else {
            System.out.print("Right node doesn't exist");
        }
    }
}

