package BinaryTree;
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class printP
{
    public static boolean printPath(Node root, int sum)
    {
        if (sum == 0 && root == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean left = printPath(root.left, sum - root.data);
        boolean right = false;
        
        if (!left) {
            right = printPath(root.right, sum - root.data);
        }
        if (left || right) {
            System.out.print(root.data + " ");
        }
 
        return left || right;
    }
    public static int getRootToLeafSum(Node root)
    {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
 
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int left = getRootToLeafSum(root.left);
        int right = getRootToLeafSum(root.right);
        return (left > right? left : right) + root.data;
    }
    public static void findMaxSumPath(Node root)
    {
        int sum = getRootToLeafSum(root);
        System.out.println("The maximum sum is " + sum);
        System.out.print("The maximum sum path is ");
 
        printPath(root, sum);
    }
 
    public static void main(String[] args)
    {
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(5);
 
        findMaxSumPath(root);
    }
}

