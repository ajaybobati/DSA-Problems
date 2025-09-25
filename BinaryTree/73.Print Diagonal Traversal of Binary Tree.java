package BinaryTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class printDiagon
{
    public static void printDiagonal(Node node, int diagonal,
                                    Map<Integer, List<Integer>> map)
    {
        if (node == null) {
            return;
        }
        map.putIfAbsent(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.data);
 
        printDiagonal(node.left, diagonal + 1, map);
 
        printDiagonal(node.right, diagonal, map);
    }
    public static void printDiagonal(Node root)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
 
        printDiagonal(root, 0, map);
 
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
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
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        printDiagonal(root);
    }
}

