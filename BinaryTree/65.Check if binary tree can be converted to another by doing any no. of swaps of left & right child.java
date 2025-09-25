package BinaryTree;


class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class equ
{
    public static boolean equal(Node X, Node Y)
    {
        if (X == Y) {
            return true;
        }
 
        return (X != null && Y != null ) && (X.data == Y.data) &&
                ((equal(X.left, Y.left) && equal(X.right, Y.right)) ||
                        (equal(X.right, Y.left) && equal(X.left, Y.right)));
    }
 
    public static void main(String[] args)
    {
        Node X = new Node(6);
        X.left = new Node(3);
        X.right = new Node(8);
        X.left.left = new Node(1);
        X.left.right = new Node(7);
        X.right.left = new Node(4);
        X.right.right = new Node(2);
        X.right.left.left = new Node(1);
        X.right.left.right = new Node(7);
        X.right.right.right = new Node(3);
 
        Node Y = new Node(6);
        Y.left = new Node(8);
        Y.right = new Node(3);
        Y.left.left = new Node(2);
        Y.left.right = new Node(4);
        Y.right.left = new Node(7);
        Y.right.right = new Node(1);
        Y.left.left.left = new Node(3);
        Y.left.right.left = new Node(1);
        Y.left.right.right = new Node(7);
 
        if (equal(X, Y)) {
            System.out.println("Binary tree can be converted");
        }
        else {
            System.out.println("Binary tree cannot be converted");
        }
    }
}

