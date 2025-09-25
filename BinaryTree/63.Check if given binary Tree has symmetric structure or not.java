package BinaryTree;

class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class isSymm
{
    public static boolean isSymmetric(Node X, Node Y)
    {
        if (X == null && Y == null) {
            return true;
        }
        return (X != null && Y != null) &&
                    isSymmetric(X.left, Y.right) &&
                    isSymmetric(X.right, Y.left);
    }
    public static boolean isSymmetric(Node root)
    {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
 
    public static void main(String[] args)
    {
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
 
        if (isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }
}


