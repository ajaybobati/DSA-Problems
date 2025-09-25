package BinaryTree;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class inorde
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
    public static Node truncate(Node root)
    {
        if (root == null) {
            return null;
        }
        root.left = truncate(root.left);
        root.right = truncate(root.right);
        if ((root.left != null && root.right != null) || isLeaf(root)) {
            return root;
        }
        Node child = (root.left != null) ? root.left: root.right;
        return child;
    }
 
    public static void main(String[] args)
    {
        
 
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.left.left.left = new Node(5);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
 
        root = truncate(root);
        inorder(root);
    }
}
