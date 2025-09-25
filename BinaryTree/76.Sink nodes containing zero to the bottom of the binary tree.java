package BinaryTree;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class inor
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
    public static void sink(Node root)
    {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.data != 0)
        {
            int temp = root.data;
            root.data = root.left.data;
            root.left.data = temp;
            sink(root.left);
        }
        else if (root.right != null && root.right.data != 0)
        {
            int temp = root.data;
            root.data = root.right.data;
            root.right.data = temp;
 
            sink(root.right);
        }
    }
    public static void sinkNodes(Node root)
    {
        if (root == null) {
            return;
        }
        sinkNodes(root.left);
        sinkNodes(root.right);
        if (root.data == 0) {
            sink(root);
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(2);
        root.right.left.left = new Node(3);
        root.right.left.right = new Node(4);
 
        sinkNodes(root);
 
        inorder(root);
    }
}


