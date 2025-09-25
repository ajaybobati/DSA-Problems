package BinaryTree;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class isNodePr
{
    public static boolean isNodePresent(Node root, Node node)
    {
        // base case
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return isNodePresent(root.left, node) || isNodePresent(root.right, node);
    }
    public static int findLevel(Node root, Node node, int level)
    {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root == node) {
            return level;
        }
        int left = findLevel(root.left, node, level + 1);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return findLevel(root.right, node, level + 1);
    }
    public static Node findLCA(Node root, Node x, Node y)
    {
        if (root == null) {
            return null;
        }
 
        if (root == x || root == y) {
            return root;
        }
 
        Node left = findLCA(root.left, x, y);
        Node right = findLCA(root.right, x, y);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
 
        return null;
    }
    public static int findDistance(Node root, Node x, Node y)
    {
        Node lca = null;
        if (isNodePresent(root, y) && isNodePresent(root, x)) {
            lca = findLCA(root, x, y);
        }
        else {
            return Integer.MIN_VALUE;
        }
        return findLevel(lca, x, 0) + findLevel(lca, y, 0);
 
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
        root.right.right.right = new Node(8);
 
        // find the distance between node 7 and node 6
        System.out.print(findDistance(root, root.right.left.left, root.right.right));
    }
}


