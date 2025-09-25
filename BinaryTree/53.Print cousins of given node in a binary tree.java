package BinaryTree;
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class indLeve
{
    public static int findLevel(Node root, Node x, int index, int level)
    {
        if (root == null || level != 0) {
            return level;
        }
        if (root == x) {
            level = index;
        }
        level = findLevel(root.left, x, index + 1, level);
        level = findLevel(root.right, x, index + 1, level);
 
        return level;
    }
 
    public static void printLevel(Node root, Node node, int level)
    {
        if (root == null) {
            return;
        }
        if (level == 1)
        {
            System.out.print(root.key + " ");
            return;
        }
        if (!(root.left != null && root.left == node ||
                root.right != null && root.right == node))
        {
            printLevel(root.left, node, level - 1);
            printLevel(root.right, node, level - 1);
        }
    }
    public static void printAllCousins(Node root, Node node)
    {
        if (root == null || root == node) {
            return;
        }
        int level = findLevel(root, node, 1, 0);
 
        printLevel(root, node, level);
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
 
        printAllCousins(root, root.right.left);
    }
}
