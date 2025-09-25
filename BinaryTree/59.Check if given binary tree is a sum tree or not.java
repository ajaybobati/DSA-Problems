package BinaryTree;
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class isSumTr
{
    public static int isSumTree(Node root)
    {
        if (root == null) {
            return 0;
        }
 
        if (root.left == null && root.right == null) {
            return root.key;
        }
 
        int left = isSumTree(root.left);
        int right = isSumTree(root.right);

        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE &&
                root.key == left + right) {
            return 2 * root.key;
        }
 
        return Integer.MIN_VALUE;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.println("Binary tree is a sum tree");
        }
        else {
            System.out.println("Binary tree is not a sum tree");
        }
    }
}