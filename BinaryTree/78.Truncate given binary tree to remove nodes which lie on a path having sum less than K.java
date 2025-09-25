package BinaryTree;

class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Truncat
{
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    public static Node trunc(Node curr, int k, int target)
    {
        if (curr == null) {
            return null;
        }
        target = target + (curr.data);
        curr.left = trunc(curr.left, k, target);
        curr.right = trunc(curr.right, k, target);
 
        if (target < k && isLeaf(curr))
        {
            return null;
        }
 
        return curr;
    }
    public static Node truncate(Node root, int k)
    {
        int target = 0;
        return trunc(root, k, target);
    }
 
    public static void main(String[] args)
    {
 
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(4);
        root.right.right = new Node(2);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(3);
 
        int k = 20;
        root = truncate(root, k);
        inorder(root);
    }
}

