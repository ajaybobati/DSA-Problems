package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
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
 
class Main
{
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    public static void printPathRecursive(Node curr, Map<Node, Node> map)
    {
        if (curr == null) {
            return;
        }
        printPathRecursive(map.get(curr), map);
        System.out.print(curr.data + (isLeaf(curr) ? "\n" : " —> "));
    }
    public static void printPathIterative(Node leafNode, Map<Node, Node> map)
    {
        Node curr = leafNode;
        while (map.get(curr) != null)
        {
            System.out.print(curr.data + " —> ");
            curr = map.get(curr);
        }
 
        System.out.println(curr.data);
    }
 
    public static void postorderIterative(Node root)
    {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
 
        Map<Node, Node> map = new HashMap<>();
 
        map.put(root, null);
 
        stack.add(root);
        while (!stack.isEmpty())
        {
            Node curr = stack.pollLast();
            if (isLeaf(curr))
            {
                printPathIterative(curr, map);
            }
            if (curr.right != null)
            {
                stack.add(curr.right);
                map.put(curr.right, curr);
            }
 
            if (curr.left != null)
            {
                stack.add(curr.left);
                map.put(curr.left, curr);
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
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
 
        postorderIterative(root);
    }
}


