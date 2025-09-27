package Stack;

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
    public static boolean printAncestors(Node root, Node node)
    {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean left = printAncestors(root.left, node);
 
        boolean right = false;
        if (!left) {
            right = printAncestors(root.right, node);
        }
        if (left || right) {
            System.out.print(root.data + " ");
        }
 
        return left || right;
    }
 
    public static void main(String[] args)
    {
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        Node node = root.right.left.left;   
        printAncestors(root, node);
    }
}


