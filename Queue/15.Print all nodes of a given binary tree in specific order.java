package Queue;


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
 
class Main
{
    public static void printNodes(Node root)
    {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
 
        Queue<Node> first = new ArrayDeque<>();
        Queue<Node> second = new ArrayDeque<>();
 
        if (root.left != null && root.right != null)
        {
            first.add(root.left);
            second.add(root.right);
        }
 
        while (!first.isEmpty())
        {
            int n = first.size();
            while (n-- > 0)
            {
                Node x = first.poll();
 
                System.out.print(x.key + " ");
 
                if (x.left != null) {
                    first.add(x.left);
                }
 
                if (x.right != null) {
                    first.add(x.right);
                }
                Node y = second.poll();
 
                System.out.print(y.key + " ");
                if (y.right != null) {
                    second.add(y.right);
                }
 
                if (y.left != null) {
                    second.add(y.left);
                }
            }
        }
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
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
 
        printNodes(root);
    }
}

