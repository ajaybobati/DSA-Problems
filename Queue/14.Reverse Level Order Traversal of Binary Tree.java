package Queue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

 class ReverseLevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void reverseLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp);
            if (temp.right != null) queue.add(temp.right);
            if (temp.left != null) queue.add(temp.left);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Reverse Level Order Traversal:");
        reverseLevelOrder(root);
    }
}

